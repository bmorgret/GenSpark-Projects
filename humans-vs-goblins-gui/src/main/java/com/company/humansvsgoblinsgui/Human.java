package com.company.humansvsgoblinsgui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Human extends BoardCharacter {
    private ArrayList<Loot> loot;
    public Human(int x, int y){
//        Main.land.addCharacter(this);
        this.setLocation(x,y);
        this.setStrength((int)(Math.random()*5+10));
        this.setHealth((int)(Math.random()*50+50));
        this.setSymbol('\uC6C3');
        this.setImageFile("/home/brian/IdeaProjects/humans-vs-goblins-gui/src/main/resources/human.jpeg");
        try {
            this.setImage(new Image(new FileInputStream(this.getImageFile())));
            this.setImageView(new ImageView(this.getImage()));
        } catch(IOException e){
            System.out.println("IOException");
        }
    }
    public void attack(Goblin goblin) {
        goblin.setHealth(goblin.getHealth()-this.getStrength());
        this.setHealth(this.getHealth()-goblin.getStrength());
    }
    public String toString(){
        return this.getSymbol()+" Strength: "+this.getStrength()+" Health: "+this.getHealth();
    }
}
