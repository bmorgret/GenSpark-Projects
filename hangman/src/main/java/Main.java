import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static String wordToFind;
    public static String curWord;
    public static char curGuess;
    public static int missedGuessesAllowed = 3; //total missed guesses allowed
    public static int currentMissedGuesses = 0; //current number of guesses
    public static String missedLetters;
    public static Scanner myInput = new Scanner(System.in);
    public static final Random RANDOM = new Random();
    public static String[] wordsList = {"geography", "cat", "yesterday", "java", "truck", "opportunity",
            "fish", "token", "transportation", "bottom", "apple", "cake",
            "remote", "boots", "terminology", "arm", "cranberry", "tool",
            "caterpillar", "spoon", "watermelon", "laptop", "toe", "toad",
            "fundamental", "capitol", "garbage", "anticipate", "pesky"};
    //returns true if guess again
    public static boolean guess(char result) {
        switch (result) {
            case 'n': // not found
                missedLetters = missedLetters + curGuess;
                System.out.println("Oops bad guess. Choose again");
                return true;
            case 'y': // found
                System.out.println("Good guess!  Choose again");
                return true;
            case 'a': // all found
                System.out.println("Yes! The secret word is \"" + wordToFind + "\"! You have won!");
                return false;
            case 'r': //repeated guess
                System.out.println("You have already guessed that letter.  Choose again.");
                return true;
            case 'h': //no more gueses
                System.out.println("Oops bad guess.  Your hung.  Game over");
                return false;
        }
        return true;
    }
    //parseGuess returns the first character from the inputed string.
    public static char parseGuess(String guess) {
        if (guess.length() > 0) {
            curGuess = guess.charAt(0);
            return curGuess;
        }
        return ' ';
    }
    //returns true if the user wants to play again.
    public static boolean playAgain() {
        boolean inputerror = false;
        do {
            System.out.println("Would you like to plan again y or n");
            char result = parseReplay(myInput.nextLine());
            switch (result) {
                case 'y':
                    return true;
                case 'n':
                    return false;
                case 'e':
                    System.out.println("Invalid input please enter y or n");
                    inputerror = true;
            }
        } while (inputerror);
        return false;
    }
    // returns 'y' if play again 'n' if not and 'e' if input error
    public static char parseReplay(String input) {
        char yn = 'y';
        try {
            if (input.length() > 1) {
                throw new InputMismatchException("length longer than 1 character");
            }
            yn = input.toCharArray()[0];
            if (!(yn == 'y' || yn == 'n')) {
                throw new InputMismatchException("Not y or n");
            }
        } catch (InputMismatchException e) {
            return 'e';
        }
        return yn;
    }
    // this method sets up a new game
    private static void newGame() {
        wordToFind = randomWord();
        currentMissedGuesses = 0;
        missedLetters = "";
        curWord = "*".repeat(wordToFind.length());
        return;
    }
    // this method returns a random word from the wordlist
    private static String randomWord() {
        return wordsList[RANDOM.nextInt(wordsList.length)];
    }
    // this method checks the user inputed character and returns a code based on the results
    // 'r' = repeated guess 'a' = all guessed 'y' = good guess 'h'=hung 'n' = not found
    public static char checkResult(char guess) {
        if (curWord.contains("" + guess) || missedLetters.contains("" + guess)) {
            return 'r'; // r=repeated guess
        }
        if (wordToFind.contains("" + guess)) {
            for (int i = 0; i < wordToFind.length(); i++) {
                if (wordToFind.charAt(i) == guess) {
                    curWord = curWord.substring(0, i) + guess + curWord.substring(i + 1);
                }
            }
            if (wordToFind.equals(curWord)) {
                return 'a'; // a=all found
            }
            return 'y'; // y=good guess
        }
        currentMissedGuesses++;
        if (missedGuessesAllowed == currentMissedGuesses) {
            return 'h'; // h=hung
        }
        return 'n'; // n=not found
    }
    // This method displays the game board
    private static void displayGameBoard() {
        ArrayList<String> gallows = new ArrayList<>();
        gallows.add("+---+");
        gallows.add("    |");
        gallows.add("    |");
        gallows.add("    |");
        gallows.add("=====");
        if (currentMissedGuesses >= 1) {
            gallows.set(1, "O   |");
        }
        if (currentMissedGuesses >= 2) {
            gallows.set(2, "|   |");
        }
        if (currentMissedGuesses >= 3) {
            gallows.set(3, "|   |");
        }
        for (String s : gallows) {
            System.out.println(s);
        }
        System.out.println("Missed letters: " + missedLetters);
        System.out.println(curWord);

        return;
    }
    public static void main(String[] args) {
        do {
            newGame();
            do {
                displayGameBoard();
            } while (guess(checkResult(parseGuess(myInput.nextLine()))));
        } while (playAgain());
    }
}