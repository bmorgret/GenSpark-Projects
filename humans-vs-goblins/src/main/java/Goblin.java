import java.util.ArrayList;

public class Goblin extends Character{
    private ArrayList<Loot> drops;
    public Goblin(int x,int y) {
//        Main.land.addCharacter(this);
        this.setLocation(x, y);
        this.setStrength((int)(Math.random()*5+5));
        this.setHealth((int)(Math.random()*5+5));
        this.setSymbol('\u00A3');
    }
    public void attack(Character character) {
    }
    public String toString(){
        return this.getSymbol()+" Strength: "+this.getStrength()+" Health: "+this.getHealth();
    }
}
