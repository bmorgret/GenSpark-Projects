import java.util.ArrayList;

public class Character {

    private int health;
    private int strength;
    private Location location;
    private char symbol;
    public Location getLocation() {return location;}
    public void setLocation(int x,int y){
        location=new Location(x,y);
    }
    public char getSymbol() {return symbol;}
    public void setSymbol(char symbol) {this.symbol=symbol;}
    public int getHealth() {return health;}
    public void setHealth(int health) {this.health = health;}
    public int getStrength() {return strength;}
    public void setStrength(int strength) {this.strength = strength;}

}
