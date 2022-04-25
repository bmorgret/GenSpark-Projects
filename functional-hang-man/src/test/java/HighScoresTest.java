import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HighScoresTest {

    @Test
    void getHighScore() {
        HighScores highScores = new HighScores();
        assertEquals(3, highScores.getHighScore("Brian"), "Brian");
        assertEquals(5, highScores.getHighScore("Jack"), "Jack");
    }
    @Test
    void setHighScores() {
        HighScores highScores = new HighScores();
        highScores.setHighScores("Joe", 7);
        assertEquals(7, highScores.getHighScore("Joe"), "Joe");
    }

    @Test
    void save() {
        HighScores highScores = new HighScores();
        highScores.setHighScores("John", 8);
        highScores.save();
        highScores = new HighScores();
        assertEquals(8, highScores.getHighScore("John"), "John");

    }
}