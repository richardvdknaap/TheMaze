import javax.swing.*;
import java.awt.*;

public class Barricade{

    private Image barricade;
    private int tileX,tileY;
    private int value;

    public Barricade(int x, int y, int value){

        if(value == 100) {
            ImageIcon img = new ImageIcon("Sprites\\barricade.png");
            barricade = img.getImage();
        }
        if(value == 200) {
            ImageIcon img = new ImageIcon("Sprites\\barricade 200.png");
            barricade = img.getImage();
        }
        if(value == 300) {
            ImageIcon img = new ImageIcon("Sprites\\barricade 300.png");
            barricade = img.getImage();
        }
        this.value = value;
        this.tileX = x;
        this.tileY = y;

    }


    public Image getBarricade(){
        return  barricade;
    }

    public int getTileX(){
        return tileX;
    }

    public int getTileY(){
        return tileY;
    }

    public void changeBarricade(){
            this.barricade = new Grass().getGrass();
            this.value = 0;
    }
    public int getValue(){
        return this.value;
    }



}
