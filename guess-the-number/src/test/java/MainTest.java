import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void parsenumber() {
        assertEquals(0, Main.parsenumber("0"), "invalid");
        assertEquals(1, Main.parsenumber("1"), "number 1");
        assertEquals(2, Main.parsenumber("2"), "number 2");
        assertEquals(3, Main.parsenumber("3"), "number 3");
        assertEquals(4, Main.parsenumber("4"), "number 4");
        assertEquals(5, Main.parsenumber("5"), "number 5");
        assertEquals(6, Main.parsenumber("6"), "number 6");
        assertEquals(7, Main.parsenumber("7"), "number 7");
        assertEquals(8, Main.parsenumber("8"), "number 8");
        assertEquals(9, Main.parsenumber("9"), "number 9");
        assertEquals(10, Main.parsenumber("10"), "number 10");
        assertEquals(11, Main.parsenumber("11"), "number 11");
        assertEquals(12, Main.parsenumber("12"), "number 12");
        assertEquals(13, Main.parsenumber("13"), "number 13");
        assertEquals(14, Main.parsenumber("14"), "number 14");
        assertEquals(15, Main.parsenumber("15"), "number 15");
        assertEquals(16, Main.parsenumber("16"), "number 16");
        assertEquals(17, Main.parsenumber("17"), "number 17");
        assertEquals(18, Main.parsenumber("18"), "number 18");
        assertEquals(19, Main.parsenumber("19"), "number 19");
        assertEquals(20, Main.parsenumber("20"), "number 20");
        assertEquals(0, Main.parsenumber("21"), "invalid");
        assertEquals(0, Main.parsenumber("asdf"), "invalid");
    }

    @Test
    void parseReplay() {
        assertEquals('y', Main.parseReplay("y"), "answer y");
        assertEquals('n', Main.parseReplay("n"), "answer y");
        assertEquals('e', Main.parseReplay("Y"), "invalid");
        assertEquals('e', Main.parseReplay("N"), "invalid");
        assertEquals('e', Main.parseReplay("yes"), "invalid");
        assertEquals('e', Main.parseReplay("asdf"), "invalid");
    }
}