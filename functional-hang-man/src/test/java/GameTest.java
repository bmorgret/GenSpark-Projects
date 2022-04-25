import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game = new Game();
    @Test
    void addLetterToCurrentGuess() {
        assertEquals("*a*", game.addLetterToCurrentGuess("cat", "***","a"), "add in middle");
        assertEquals("*at", game.addLetterToCurrentGuess("cat", "*a*","t"), "add in middle");
        assertEquals("cat", game.addLetterToCurrentGuess("cat", "c*t","a"), "add in middle");
        assertEquals("cat", game.addLetterToCurrentGuess("cat", "ca*","t"), "add in middle");
    }

    @Test
    void maskGuess() {
        assertEquals("c", game.maskGuessCharacter("c", "ca*"), "add in middle");
        assertEquals("a", game.maskGuessCharacter("a", "ca*"), "add in middle");
        assertEquals("*", game.maskGuessCharacter("t", "ca*"), "add in middle");
    }

    @Test
    void goodGuesses() {
        Game game = new Game();
        assertEquals("ca", game.goodGuesses("ca*"));
        assertEquals("", game.goodGuesses("***"));
    }
}