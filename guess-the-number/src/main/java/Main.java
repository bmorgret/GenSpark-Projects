import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
public class Main {
    public static int parsenumber(String input){
        int num = 0;
        try{
            num=Integer.parseInt(input);
            if(!(num>=1&&num<=20)){
                throw new NumberFormatException(("Not 1-20"));
            }
        }
        catch(NumberFormatException e) {
            return 0;
        }
        return num;
    }

    public static char parseReplay(String input){
        char yn = 'y';
        try{
            if(input.length()>1){
                throw new InputMismatchException("length longer than 1 character");
            }
            yn=input.toCharArray()[0];
            if(!(yn=='y'||yn=='n')){
                throw new InputMismatchException("Not y or n");
            }
        }
        catch(InputMismatchException e) {
            return 'e';
        }
        return yn;
    }

    public static void main(String[] args) {
        // display intro text
        System.out.println("Hello! What is our name?");

        // get name
        Scanner myInput = new Scanner(System.in);
        String name = myInput.nextLine();

        // create random object
        Random rand = new Random();

        char playagain = 'y';

        do { // while playagain
            // display instructions
            System.out.println("Well, "+name+", I am thinking of a number between 1 and 20.");
            // generate random number between 1 and 20
            int randint = rand.nextInt(20);
            randint++;
            // get guess and check
            int guess = 0;
            int numguess = 0;
            do { // while incorrect guess
                // get guess
                System.out.println("Take a guess.");
                do { // while invalid input
                    guess = parsenumber(myInput.nextLine());
                    if(guess==0){
                        System.out.println("Incorrect response: Enter a number between 1 and 20");
                    }
                } while(guess==0);
                numguess++;
                // check guess
                if (guess > randint) {
                    System.out.println("Your guess is too high.");
                } else if (guess < randint) {
                    System.out.println("Your guess is too low.");
                }
            } while (guess != randint);

            System.out.println("Good job, "+name+"! You guessed my number in "+ Integer.toString(numguess) +" guesses!");
            System.out.println("Would you like to play again? (y or n)");

            do { // while invalid input
                // get play again
                playagain = parseReplay(myInput.nextLine());
                if(playagain=='e'){
                    System.out.println("Incorect input: enter (y or n)");
                }
            } while(playagain=='e');
        } while(playagain=='y');
    }
}
