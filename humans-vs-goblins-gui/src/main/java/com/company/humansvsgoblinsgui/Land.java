package com.company.humansvsgoblinsgui;

import java.util.ArrayList;

public class Land {
    private int sizex=10;
    private int sizey=10;
    private char[][] land = new char[sizex][sizey];
    private ArrayList<BoardCharacter> characters = new ArrayList<BoardCharacter>();
    public int getSizex() {return sizex;}
    public int getSizey() {return sizey;}
    public ArrayList<BoardCharacter> getCharacters() {return characters;}

    public Land(int x, int y){
        sizex=x;
        sizey=y;
        land = new char[x][y];
        for(int ix=0; ix<sizex; ix++) {
            for (int iy=0; iy<sizey; iy++){
                land[ix][iy] = '\u1011';
            }
        }
    }

    public void addCharacter(BoardCharacter character) {
        this.characters.add(character);
    }

    public void removeCharacter(BoardCharacter character) {
        characters.remove(character);
    }

    public String toString() {
        for(int ix=0; ix<sizex; ix++) {
            for (int iy=0; iy<sizey; iy++){
                land[ix][iy] = '\u1011';
            }
        }
        for(BoardCharacter character: characters){
            land[character.getLocation().getX()][character.getLocation().getY()]=character.getSymbol();
        }
        String display = new String();
        for(char[] row: land) {
            display = display + String.valueOf(row)+"\n";
        }
        return display;
    }
}
