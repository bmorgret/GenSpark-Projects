import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main() {
    }

    @Test
    void guess() {
        Main.wordToFind="cat";
        Main.curWord="*a*";
        Main.curGuess='t';
        Main.missedGuessesAllowed = 3; //total missed guesses allowed
        Main.currentMissedGuesses = 0; //current number of guesses
        Main.missedLetters = "j";
        assertEquals(true, Main.guess('y'),"good guess");
        Main.wordToFind="cat";
        Main.curWord="ca*";
        Main.curGuess='t';
        Main.missedGuessesAllowed = 3; //total missed guesses allowed
        Main.currentMissedGuesses = 0; //current number of guesses
        Main.missedLetters = "j";
        assertEquals(false, Main.guess('a'),"all guessed");
        Main.wordToFind="cat";
        Main.curWord="ca*";
        Main.curGuess='k';
        Main.missedGuessesAllowed = 3; //total missed guesses allowed
        Main.currentMissedGuesses = 0; //current number of guesses
        Main.missedLetters = "j";
        assertEquals(true, Main.guess('n'),"bad guess");
        Main.wordToFind="cat";
        Main.curWord="ca*";
        Main.curGuess='j';
        Main.missedGuessesAllowed = 3; //total missed guesses allowed
        Main.currentMissedGuesses = 0; //current number of guesses
        Main.missedLetters = "j";
        assertEquals(true, Main.guess('r'),"repeated guess");
        Main.wordToFind="cat";
        Main.curWord="ca*";
        Main.curGuess='l';
        Main.missedGuessesAllowed = 3; //total missed guesses allowed
        Main.currentMissedGuesses = 3; //current number of guesses
        Main.missedLetters = "jk";
        assertEquals(false, Main.guess('h'),"hung");
    }
    @Test
    void parseGuess() {
        Main.wordToFind="cat";
        Main.curWord="*a*";
        Main.curGuess='t';
        Main.missedGuessesAllowed = 3; //total missed guesses allowed
        Main.currentMissedGuesses = 1; //current number of guesses
        Main.missedLetters = "j";
        assertEquals('y', Main.checkResult(Main.curGuess),"good guess");
        Main.wordToFind="cat";
        Main.curWord="ca*";
        Main.curGuess='t';
        Main.missedGuessesAllowed = 3; //total missed guesses allowed
        Main.currentMissedGuesses = 0; //current number of guesses
        Main.missedLetters = "j";
        assertEquals('a', Main.checkResult(Main.curGuess),"all guessed");
        Main.wordToFind="cat";
        Main.curWord="ca*";
        Main.curGuess='k';
        Main.missedGuessesAllowed = 3; //total missed guesses allowed
        Main.currentMissedGuesses = 0; //current number of guesses
        Main.missedLetters = "j";
        assertEquals('n', Main.checkResult(Main.curGuess),"bad guess");
        Main.wordToFind="cat";
        Main.curWord="ca*";
        Main.curGuess='j';
        Main.missedGuessesAllowed = 3; //total missed guesses allowed
        Main.currentMissedGuesses = 0; //current number of guesses
        Main.missedLetters = "j";
        assertEquals('r', Main.checkResult(Main.curGuess),"repeated guess");
        Main.wordToFind="cat";
        Main.curWord="ca*";
        Main.curGuess='l';
        Main.missedGuessesAllowed = 3; //total missed guesses allowed
        Main.currentMissedGuesses = 2; //current number of guesses
        Main.missedLetters = "jk";
        assertEquals('h', Main.checkResult(Main.curGuess),"hung");
    }
    @Test
    void parseOneGuess() {
        Main.wordToFind="cat";
        Main.curWord="ca*";
        Main.curGuess='l';
        Main.missedGuessesAllowed = 3; //total missed guesses allowed
        Main.currentMissedGuesses = 2; //current number of missed guesses
        Main.missedLetters = "jk";
        assertEquals('h', Main.checkResult(Main.curGuess),"hung");
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