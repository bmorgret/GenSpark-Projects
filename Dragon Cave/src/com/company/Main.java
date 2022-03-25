package com.company;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	    // display intro text
        System.out.println("You are in a land full of dragons. In front of you,");
        System.out.println("you see two caves. In one cave, the dragon is friendly");
        System.out.println("and will share his treasure with you.  The other dragon");
        System.out.println("is greedy and hungry and will eat you on sight.");
        System.out.println("Which cave will you go into? (1 or 2)");
        // read an integer from the console
        Scanner myInput = new Scanner(System.in);
        boolean goodinput = false;
        int cavenum = 1;
        do {
            try {
                cavenum = myInput.nextInt();
                if (!(cavenum==1||cavenum==2)) {
                    throw new InputMismatchException("not 1 or 2");
                }
                goodinput = true;
            }
            catch(InputMismatchException e) {
                System.out.println("Incorrect input: enter (1 or 2)");
                myInput.nextLine();
                goodinput = false;
            }
        } while(!goodinput);

        // test for user input equal to 1
        if(cavenum==1){
            System.out.println("You approach the cave...");
            System.out.println("It is dark and spooky...");
            System.out.println("A large dragon jumps out in front of you! He opens his jaws and...");
            System.out.println("Gobbles you down in one bite!");
        }
        // test if user input equal to 2
        else if (cavenum==2){
            System.out.println("You approach the cave...");
            System.out.println("It is dark and spooky...");
            System.out.println("A large dragon jumps out in front of you! He opens his jaws and...");
            System.out.println("says 'come share my treasure!'");
        }
    }
}
