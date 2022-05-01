package com.company.humansvsgoblinsgui;

import javafx.scene.layout.GridPane;

import static com.company.humansvsgoblinsgui.Direction.West;

public class Location {
    private int x;
    private int y;
    private GridPane gridPane;
    public int getX() {return x;}
    public int getY() {return y;}
    public Location(int x, int y){
        this.x=x;
        this.y=y;
    }
    public void Location(GridPane gridPane, int x, int y){
        this.gridPane = gridPane;
        this.x = x;
        this.y = y;
    }
    public void move(Direction direction){
        int maxx = Game.land.getSizex()-1;
        int maxy = Game.land.getSizey()-1;
        switch(direction){
            case West: if(x>0){x--;}break;
            case South: if(y<maxy){y++;}break;
            case North: if(y>0){y--;}break;
            case East: if(x<maxx){x++;}break;
        }
    }
}
