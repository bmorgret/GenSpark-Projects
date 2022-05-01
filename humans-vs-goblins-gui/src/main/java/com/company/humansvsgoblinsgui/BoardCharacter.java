package com.company.humansvsgoblinsgui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class BoardCharacter {

    private int health;
    private int strength;
    private Location location;
    private char symbol;
    private String imageFile;
    private Image image;
    private ImageView imageView;
    public Location getLocation() {return location;}
    public void setLocation(int x,int y){
        location=new Location(x,y);
    }
    public char getSymbol() {return symbol;}
    public void setSymbol(char symbol) {this.symbol=symbol;}
    public String getImageFile() {return this.imageFile;}
    public void setImageFile(String imageFile) {this.imageFile=imageFile;}
    public Image getImage() {return this.image;}
    public void setImage(Image image) {this.image=image;}
    public ImageView getImageView() {return this.imageView;}
    public void setImageView(ImageView imageView) {
        this.imageView=imageView;
        this.imageView.setFitHeight(60);
        this.imageView.setFitWidth(60);
    }
    public int getHealth() {return health;}
    public void setHealth(int health) {this.health = health;}
    public int getStrength() {return strength;}
    public void setStrength(int strength) {this.strength = strength;}
    public void move(GridPane gridPane, Direction direction){
        gridPane.getChildren().remove(this.imageView);
        this.location.move(direction);
        gridPane.add(this.imageView, this.location.getX(), this.location.getY());
    }
}
