public class Location {
    private int x;
    private int y;
    public int getX() {return x;}
    public int getY() {return y;}
    public Location(int x, int y){
        this.x=x;
        this.y=y;
    }
    public void move(Direction direction){
        int maxx = Main.land.getSizex()-1;
        int maxy = Main.land.getSizey()-1;
        switch(direction){
            case West: if(y>0){y--;}break;
            case South: if(x<maxx){x++;}break;
            case North: if(x>0){x--;}break;
            case East: if(y<maxy){y++;}break;
        }
    }
}
