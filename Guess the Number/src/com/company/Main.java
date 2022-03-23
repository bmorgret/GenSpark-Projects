package com.company;
import java.util.Scanner;
import java.util.Random;
public class Main {

    public static void main(String[] args) {
	    // display intro text
        System.out.println("Hello! What is our name?");
        // get name
        Scanner myInput = new Scanner(System.in);
        String name = myInput.nextLine();
        // display instructions
        System.out.println("Well, "+name+", I am thinking of a number between 1 and 20.");

        // create random object
        Random rand = new Random();

        char playagain = 'y';
        // check play again
        do {
            // generate random number between 1 and 20
            int randint = rand.nextInt(20);
            randint++;
            // get guess and check
            int guess = 0;
            int numguess = 0;
            do {
                // get guess
                System.out.println("Take a guess.");
                guess = myInput.nextInt();
                numguess++;
                // check guess
                if (guess > randint) {
                    System.out.println("Your guess is too high.");
                } else if (guess < randint) {
                    System.out.println("Your guess is too low.");
                }
            } while (guess != randint);
            // get play again
            System.out.println("Good job, "+name+"! You guessed my number in "+ Integer.toString(numguess) +" guesses!");
            System.out.println("Would you like to play again? (y or n)");
            playagain = (char) myInput.next().charAt(0);

        }while(playagain == 'y');
    }
}
