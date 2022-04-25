import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Game {
    private GameState gameState = GameState.GetName;
    private Panels panels = new Panels();
    private HighScores highScores = new HighScores();
    private SecretWords secretwords = new SecretWords();
    private String player;
    private String secretWord;
    private String currentGuess;
    private String badGuesses = "";
    private double Score = 0;
    public Game(){
        //select random word from the word list
        secretWord = secretwords.randomWord();
        //set currentGuess to all * the length of secretWord
        currentGuess = "*".repeat(secretWord.length());
        displayBoard();
    }
    public void displayBoard(){
        String[] currentPanel = panels.getPanel(badGuesses.length());
        Arrays.stream(currentPanel).forEach(System.out::println);
        System.out.println("Current guess: "+currentGuess+" Bad guesses: "+badGuesses);
        System.out.println("Player: "+player+ " High score: "+(int)highScores.getHighScore(player)+" Current score: "+ String.valueOf(currentScore()));
        String prompt = "";
        switch(gameState){
            case GetName:
                prompt = "Please enter your name."; break;
            case GetNameError:
                prompt = "Input error: Please enter your name."; break;
            case GetGuess:
                prompt = "Please enter a letter."; break;
            case GetGuessError:
                prompt = "Input error: please enter a single letter."; break;
            case RepeatedGuess:
                prompt = "You already tried that letter.  Please pick a new letter."; break;
            case PlayAgain:
                if(gameWon()) {
                    prompt = "You won!!! Would you like to play again? (y or n)";
                } else {
                    prompt = "You lost.  Would you like to play again? (y or n)";
                }
                break;
            case PlayAgainError:
                prompt = "Input error: Please enter y or n"; break;
            default :
                break;
        }
        System.out.println(prompt);
    }
    public int currentScore(){
        return goodGuesses(currentGuess).length() - badGuesses.length();
    }
    public boolean newInput(String s) {
        boolean playAgain = false;
        switch (gameState) {
            case GetName: case GetNameError:
                parseName(s);
                break;
            case GetGuess: case GetGuessError: case RepeatedGuess:
                parseGuess(s);
                break;
            case PlayAgain: case PlayAgainError:
                playAgain = parsePlayAgain(s);
                break;
        }
        displayBoard();
        return playAgain;
    }
    void parseName(String s) {
        if(s.length()>0) {
            player = s;
            gameState = GameState.GetGuess;
        } else {
            gameState = GameState.GetNameError;
        }
    }
    void parseGuess(String s) {
        if(s.length()==1){
            if(currentGuess.contains(s)||badGuesses.contains(s)) { //repeated guess
                gameState = GameState.RepeatedGuess;
            } else if (secretWord.contains(s)) { //good guess
                currentGuess=addLetterToCurrentGuess(secretWord,currentGuess,s);
                if(gameWon()){
                    if(currentScore()> highScores.getHighScore(player)){
                        highScores.setHighScores(player, currentScore());
                    }
                    highScores.save();
                    gameState=GameState.PlayAgain;
                } else{
                    gameState=GameState.GetGuess;
                }
            } else { //bad guess
                badGuesses = badGuesses + s;
                if(gameLost()){
                    gameState=GameState.PlayAgain;
                } else{
                    gameState=GameState.GetGuess;
                }
            }
        } else { // more than 1 character
            gameState = GameState.GetGuessError;
        }
    }
    boolean parsePlayAgain(String s) {
        if(s.length()==1){
            if(s.charAt(0)=='y'){ //reset game
                gameState = GameState.GetName;
                //select random word from the word list
                secretWord = secretwords.randomWord();
                //set currentGuess to all * the length of secretWord
                currentGuess = "*".repeat(secretWord.length());
                // clear bad guesses
                badGuesses = "";
                return false;
            } else if (s.charAt(0) == 'n') {
                // exit game
                return true;
            } else { // first character not y or n
                gameState = GameState.PlayAgainError;
                return false;
            }
        } else { // more than 1 character
            gameState = GameState.PlayAgainError;
            return false;
        }
    }
    public String addLetterToCurrentGuess(String secretWord, String currentGuess, String letter){
        // get a string of good guesses from currentGuess
        // add the new letter to the end of the string
        // Stream the secretWord thru the mask function that returns * if the letter does not exist in the newgoodguesses
        String newGoodGuesses = goodGuesses(currentGuess)+letter;
        Optional newCurrentGuess = Arrays.stream(secretWord.split(""))
                .map(c -> maskGuessCharacter(c, newGoodGuesses))
                .reduce((a,c) -> a + c);
        if(newCurrentGuess.isEmpty()){return "";}else{return newCurrentGuess.get().toString();}
    }
    public String maskGuessCharacter(String c, String goodGuesses){
        // returns a single character string that is the character if that character exists in secretWord otherwhise *.
        if(goodGuesses.contains(c)) return ""+c; else return "*";
    }
    public String goodGuesses(String currentGuess) {
        // returns just the good guesses by elimintating the * from currentGuess
        Optional result = Arrays.stream(currentGuess.split(""))
                .filter(str -> !(str.equals("*")))
                .reduce((a,c) ->a+c);
        if(result.isEmpty()){return "";}else{return result.get().toString();}
    }
    public boolean gameLost(){
        //if number of bad guesses = number of Panels
        if(badGuesses.length()>=panels.getNumPanels()-1){
            return true;
        }
        return false;
    }
    public boolean gameWon(){
        //if currentGuess does not contain an *
        if(currentGuess.contains("*")){return false;} else {return true;}
    }
    public String[] getCurrentPanel(){return panels.getPanel(badGuesses.length());}
    public String getPlayer(){return player;}
    public String getPrompt(){

        return "Please enter player name";
    }
}
