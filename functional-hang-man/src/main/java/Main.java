import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    // There are no loops anywhere in this program.
    // this is not the most reliable way to handle this task
    // but it is a nice touch in the spirit of this exercise.
    //
    // All variables are defined private and are only modified by methods within the class.
    //
    // Many of the methods are strict in that they only use data taken as parameters and only
    // modify the system through the return.  I think a few more of the methods could be made strict
    // but the main game logic is in a set of functions in the Game class that are far from strict.
    // So, depending on your definition of functional I don't think it is 100% functional.
    //
    // There is a nice touch in that all the data (artwork, words, and highScores) are saved in Json files
    // that are loaded in the constructor when the corresponding class is instantiated.
    // so as an example Highscores highScores = new Highscores creates an object highScores that contains a
    // property that is a hashset with all of scores already loaded from the highScores.json file.
    // the highScores can only be modified thru methode calls and is saved back to the file by calling highScores.save()

    public static Game game = new Game();
    public static void main(String args[]) {
        // this stream will process input from the terminal until newInput returns true signifying game over and no new game.
        boolean end = new BufferedReader(new InputStreamReader(System.in))
                .lines()
                .map(s->game.newInput(s))
                .anyMatch(b->b==true);
    }
}
