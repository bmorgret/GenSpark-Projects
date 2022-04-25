import com.google.gson.Gson;
import java.io.*;
import java.util.HashMap;

public class HighScores {
    private HashMap<String,Double> highScores;
    private String jsonFile = "/home/brian/IdeaProjects/functional-hang-man/src/main/resources/high-scores.json";

    public HighScores() {
        try {
            this.highScores = new Gson().fromJson(new BufferedReader(new FileReader(jsonFile)), HashMap.class);
        } catch (IOException e) {
            System.out.println("high score file IO error");
        }
    }
    public void setHighScores(String player, double currentScore){
        highScores.put(player, currentScore);
    }

    public double getHighScore(String player) {
        if (highScores.containsKey(player)) {
            return (highScores.get(player));
        } else {
            return (double)0;
        }
    }
    public void save(){
        try {
            Writer writer = new FileWriter(jsonFile);
            new Gson().toJson(highScores, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("high score file IO error");
        }
    }
 }
