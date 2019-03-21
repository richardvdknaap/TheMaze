import javax.swing.*;
import java.awt.*;

public class Barricade{

    private Image barricade;
    private int tileX,tileY;

    public Barricade(int x, int y){
        ImageIcon img = new ImageIcon("Sprites\\barricade.png");
        barricade = img.getImage();

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
    }



}
