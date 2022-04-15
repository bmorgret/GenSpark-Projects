import org.junit.jupiter.api.Assertions;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void parsePlayAgain() {
            assertEquals(true, Main.parsePlayAgain("y"), "answer y");
            assertEquals(false, Main.parsePlayAgain("n"), "answer y");
            assertThrows(InputMismatchException.class, () -> {Main.parsePlayAgain("");}, "Invalid");
            assertThrows(InputMismatchException.class, () -> {Main.parsePlayAgain("Y");}, "Invalid");
            assertThrows(InputMismatchException.class, () -> {Main.parsePlayAgain("N");}, "Invalid");
            assertThrows(InputMismatchException.class, () -> {Main.parsePlayAgain("yes");}, "Invalid");
            assertThrows(InputMismatchException.class, () -> {Main.parsePlayAgain("asdf");}, "Invalid");
            assertThrows(InputMismatchException.class, () -> {Main.parsePlayAgain("asdf asdf");}, "Invalid");
    }
    @org.junit.jupiter.api.Test
    void parseDirection() {
        assertEquals(Direction.North, Main.parseDirection("n"), "answer n");
        assertEquals(Direction.South, Main.parseDirection("s"), "answer s");
        assertEquals(Direction.East, Main.parseDirection("e"), "answer e");
        assertEquals(Direction.West, Main.parseDirection("w"), "answer w");
        assertThrows(InputMismatchException.class, () -> {Main.parseDirection("");}, "Invalid");
        assertThrows(InputMismatchException.class, () -> {Main.parseDirection("Y");}, "Invalid");
        assertThrows(InputMismatchException.class, () -> {Main.parseDirection("N");}, "Invalid");
        assertThrows(InputMismatchException.class, () -> {Main.parseDirection("yes");}, "Invalid");
        assertThrows(InputMismatchException.class, () -> {Main.parseDirection("asdf");}, "Invalid");
        assertThrows(InputMismatchException.class, () -> {Main.parseDirection("asdf asdf");}, "Invalid");
    }
    @org.junit.jupiter.api.Test
    void move() {
        Land land = new Land(10, 10);
        Human player = new Human(5,5);
        int maxx = Main.land.getSizex()-1;
        int maxy = Main.land.getSizey()-1;
        player.getLocation().move(Direction.North);
        assertEquals(4, player.getLocation().getX(), "moved north");
        player.getLocation().move(Direction.North);
        assertEquals(3, player.getLocation().getX(), "moved north");
        player.getLocation().move(Direction.North);
        assertEquals(2, player.getLocation().getX(), "moved north");
        player.getLocation().move(Direction.North);
        assertEquals(1, player.getLocation().getX(), "moved north");
        player.getLocation().move(Direction.North);
        assertEquals(0, player.getLocation().getX(), "moved north");
        player.getLocation().move(Direction.North);
        assertEquals(0, player.getLocation().getX(), "moved north out of bounds");
    }
}