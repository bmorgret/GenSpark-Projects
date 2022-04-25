import com.google.gson.Gson;
import java.io.*;

public class Panels {
    private String[][] panels;
    public Panels(){
        try{
            this.panels = new Gson().fromJson(new BufferedReader(new FileReader("/home/brian/IdeaProjects/functional-hang-man/src/main/resources/panels.json")), String[][].class);
        }catch(IOException e) {
            System.out.println("panel file IO error");
        }
    }
    public int getNumPanels(){
        return panels.length;
    }
    public String[] getPanel(int i){
        return panels[i];
    }
}
