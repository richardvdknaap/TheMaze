import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.beans.Visibility;
import java.io.File;
import java.util.*;

public class Map {

    private Scanner m;
    private String x;
    private String Map[] = new String[14];
    private int level;

    public Map(int level){

        this.level = level;

        openFile(level);
        readFile();
        closeFile();

    }





    public String getMap(int x, int y){
        String index = Map[y].substring(x,x+1);
        return index;

    }


    public void openFile(int level){

        try {
            m = new Scanner(new File("Levels\\level"+level+".txt"));

        }catch(Exception e){
            System.out.println("error");

        }

    }

    public void readFile(){
        while(m.hasNext()){
            for(int i = 0; i < 14; i++){
                Map[i] = m.next();

            }
        }

    }

    public void closeFile(){

    }

}
