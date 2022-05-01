package com.company.humansvsgoblinsgui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Goblin extends BoardCharacter {
    private ArrayList<Loot> drops;
    public Goblin(int x, int y) {
//        Main.land.addCharacter(this);
        this.setLocation(x, y);
        this.setStrength((int)(Math.random()*5+5));
        this.setHealth((int)(Math.random()*5+5));
        this.setSymbol('\u00A3');
        this.setImageFile("/home/brian/IdeaProjects/humans-vs-goblins-gui/src/main/resources/goblin.jpeg");
        try {
            this.setImage(new Image(new FileInputStream(this.getImageFile())));
            this.setImageView(new ImageView(this.getImage()));
        } catch(IOException e){
            System.out.println("IOException");
        }
    }
    public void attack(java.lang.Character character) {
    }
    public String toString(){
        return this.getSymbol()+" Strength: "+this.getStrength()+" Health: "+this.getHealth();
    }
}
