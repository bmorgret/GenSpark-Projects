import java.util.ArrayList;

public class Human extends Character{
    private ArrayList<Loot> loot;
    public Human(int x,int y){
//        Main.land.addCharacter(this);
        this.setLocation(x,y);
        this.setStrength((int)(Math.random()*5+10));
        this.setHealth((int)(Math.random()*50+50));
        this.setSymbol('\uC6C3');
    }
    public void attack(Goblin goblin) {
        goblin.setHealth(goblin.getHealth()-this.getStrength());
        this.setHealth(this.getHealth()-goblin.getStrength());
    }
    public String toString(){
        return this.getSymbol()+" Strength: "+this.getStrength()+" Health: "+this.getHealth();
    }
}
