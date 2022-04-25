import com.google.gson.Gson;
import java.io.*;
import java.util.Random;

public class SecretWords {
    private String[] secretwords;
    public SecretWords(){
        try{
            this.secretwords = new Gson().fromJson(new BufferedReader(new FileReader("/home/brian/IdeaProjects/functional-hang-man/src/main/resources/secret-words.json")), String[].class);
        }catch(IOException e) {
            System.out.println("SecretWords file IO error");
        }
    }
    public String randomWord(){
        return secretwords[(new Random().nextInt(secretwords.length-1))];
    }
}
