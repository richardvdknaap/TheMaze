import javax.swing.*;
import java.awt.*;

public class Key {

    private Image key;
    private int tileX, tileY;
    private static int amountKey = 0;
    private int value;


    public Key(int x, int y,int value) {

        this.value = value;
        this.tileX = x;
        this.tileY = y;
        if(value==100) {
            ImageIcon img = new ImageIcon("Sprites\\sleutel.png");
            key = img.getImage();
        }
        if(value==200) {
            ImageIcon img = new ImageIcon("Sprites\\Key 200.png");
            key = img.getImage();
        }
        if(value==300) {
            ImageIcon img = new ImageIcon("Sprites\\Key 300.png");
            key = img.getImage();
        }

    }
    public int getTileX(){
        return tileX;
    }

    public int getTileY(){
        return tileY;
    }

    public Image getKey() {
        return key;
    }

    public void captureKey() {
            amountKey = this.value;
    }

    public  static int getAmountKey() {
        return amountKey;
    }

    public void changeKey(){
        this.key = new Grass().getGrass();
    }

}