import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.beans.Visibility;
import java.io.File;
import java.util.*;

public class Map {

    private Scanner m;
    private String Map[] = new String[14];
    private Image grass, wall,barricade,sleutel,finish;

    public Map(){

        ImageIcon img = new ImageIcon("Sprites\\grass.png");
        grass = img.getImage();
        img = new ImageIcon("Sprites\\Muur.png");
        wall = img.getImage();
        img = new ImageIcon("Sprites\\barricade.png");
        barricade = img.getImage();
        img = new ImageIcon("Sprites\\Sleutel.png");
        sleutel = img.getImage();
        img = new ImageIcon("Sprites\\finish.png");
        finish = img.getImage();



        openFile();
        readFile();
        closeFile();

    }


    public Image getGrass(){
        return grass;
    }




    public String getMap(int x, int y){
        String index = Map[y].substring(x,x+1);
        return index;

    }

    public void openFile(){

        try {
            m = new Scanner(new File("Sprites\\Map.txt"));
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
