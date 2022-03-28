import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void parsecavenum() {
        assertEquals(1, Main.parsecavenum("1"), "cave 1");
        assertEquals(2, Main.parsecavenum("2"), "cave 1");
        assertEquals(0, Main.parsecavenum("3"), "cave 1");
        assertEquals(0, Main.parsecavenum("0"), "cave 1");
        assertEquals(0, Main.parsecavenum("12"), "cave 1");
        assertEquals(0, Main.parsecavenum("22"), "cave 1");
        assertEquals(0, Main.parsecavenum("qwer"), "cave 1");
    }
}