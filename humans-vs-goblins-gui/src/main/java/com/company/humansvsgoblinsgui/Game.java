package com.company.humansvsgoblinsgui;

import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    public static Land land = new Land(11, 15);
    public static Human player = new Human(5,7);
    public static GridPane gridPane;
    private Scanner myInput = new Scanner(System.in);

    public static Human getPlayer() {return player;}

    public static String turn(GridPane gridPane, Direction direction) { //returns true if player is still alive
        // move human
        player.move(gridPane, direction);
        // process attack
        for(BoardCharacter c: land.getCharacters()){
            if(c!=player&&c.getLocation().getX()==player.getLocation().getX()&&c.getLocation().getY()==player.getLocation().getY()){
                player.attack((Goblin)c);
            }
        }
        // remove dead characters from the board.
        // land.getCharacters().removeIf(character -> character.getHealth()<=0);
        ArrayList<BoardCharacter> charactersToRemove = new ArrayList();
        for(BoardCharacter boardCharacter:land.getCharacters()){
            if(boardCharacter.getHealth()<=0){
                charactersToRemove.add(boardCharacter);
            }
        }
        for(BoardCharacter boardCharacter:charactersToRemove){
            land.getCharacters().remove(boardCharacter);
            gridPane.getChildren().remove(boardCharacter.getImageView());
        }
        // If player is alive return true else false.
       if(player.getHealth()>0){
           if(land.getCharacters().size()==1) {
               return "Won"; // only player left, player won
           } else {
               return "Play"; // still more goblins, keep playing
           }
       } else {
           return "Lost"; // player dead.
       }
    }
    public void winLose(){
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
        gridPane.getChildren().remove(player.getImageView());
        Game.populateLand(Game.gridPane);
    }
    public void displayLand(){
        System.out.println(land);
        for(BoardCharacter c: land.getCharacters()) {
            System.out.println(c);
        }
    }
    public static void populateLand(GridPane gridPane){
        Game.gridPane = gridPane;
        land.addCharacter(player);
        gridPane.add(player.getImageView(), player.getLocation().getX(), player.getLocation().getY());
        addGoblin(gridPane,2,2);
        addGoblin(gridPane,9,12);
        addGoblin(gridPane,2,12);
        addGoblin(gridPane,9,2);
        }
    public static void addGoblin(GridPane gridPane, int x, int y){
        Goblin goblin = new Goblin(x,y);
        land.addCharacter(goblin);
        gridPane.add(goblin.getImageView(), goblin.getLocation().getX(), goblin.getLocation().getY());

    }
}
