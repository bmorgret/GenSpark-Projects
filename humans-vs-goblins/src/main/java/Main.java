import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static Land land = new Land(10, 10);
    static Human player = new Human(5,5);
    static Scanner myInput = new Scanner(System.in);

    public static boolean PlayAgain() { //prompts the user and returns true if player responds with y
        do {
            System.out.println("Would you like to play again? (y or n)");
            try {
                return parsePlayAgain(myInput.nextLine());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
            }
        } while(true);
    }
    public static boolean parsePlayAgain(String input) throws InputMismatchException { //parses the inputed string
        if(input.length()!=1){
            throw new InputMismatchException("length longer than 1 character");
        }
        if(input.toCharArray()[0]=='y'){
            return true;
        } else if(input.toCharArray()[0]=='n'){
            return false;
        } else{
            throw new InputMismatchException("Not y or n");
        }
    }
    public static Direction promptDirection() { // prompts for direction and returns the enum Direction
        do {
            System.out.println("What direction would you like to move? (n,s,e,or w)");
            try {
                return parseDirection(myInput.nextLine());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
            }
        } while(true);
    }
    public static Direction parseDirection(String input) {//parses the inputed string and returns enum Direction
        if(input.length()!=1){
            throw new InputMismatchException("length longer than 1 character");
        } else if(input.toCharArray()[0]=='n'){
            return Direction.North;
        } else if(input.toCharArray()[0]=='s'){
            return Direction.South;
        } else if(input.toCharArray()[0]=='e'){
            return Direction.East;
        } else if(input.toCharArray()[0]=='w'){
            return Direction.West;
        } else{
            throw new InputMismatchException("Not n,s,e,or w");
        }
    }
    public static boolean turn(Direction direction) { //returns true if player is still alive
        // move human
        player.getLocation().move(direction);
        // process attack
        for(Character c: land.getCharacters()){
            if(c!=player&&c.getLocation().getX()==player.getLocation().getX()&&c.getLocation().getY()==player.getLocation().getY()){
                player.attack((Goblin)c);
            }
        }
        // remove dead characters from the board.
        land.getCharacters().removeIf(character -> character.getHealth()<=0);
        // If player is alive return true else false.
       if(player.getHealth()>0){
           if(land.getCharacters().size()==1) {
               return false; // only player left, player won
           } else {
               return true; // still more goblins, keep playing
           }
       } else {
           return false; // player dead.
       }
    }
    public static void winLose(){
        displayLand();
        if(player.getHealth()>0) {
            System.out.println("You killed all the goblins, You win");
        } else {
            System.out.println("Your dead, game over");
        }
        resetGame();
    }
    public static void resetGame(){
        land.getCharacters().clear(); //clears Characters
        player.setLocation(5,5); //resets player location
        player.setHealth((int)(Math.random()*50+50)); //reset player health.
    }
    public static void displayLand(){
        System.out.println(land);
        for(Character c: land.getCharacters()) {
            System.out.println(c);
        }
    }
    public static void populateLand(){
        land.addCharacter(player);
        land.addCharacter(new Goblin(2,2));
        land.addCharacter(new Goblin(8,8));
        land.addCharacter(new Goblin(2,8));
        land.addCharacter(new Goblin(8,2));
    }
    public static void main(String[] args){
        do{
            populateLand();
            do{
                displayLand();
            }while(turn(promptDirection()));
            winLose();
        }while(PlayAgain());
    }
}
