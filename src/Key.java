import javax.swing.*;
import java.awt.*;

public class Key {

    private Image key;
    private int tileX, tileY;
    private static int amountKey = 0;


    public Key(int x, int y) {

        this.tileX = x;
        this.tileY = y;
        ImageIcon img = new ImageIcon("Sprites\\sleutel.png");
        key = img.getImage();


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
        while (amountKey != 1) {
            amountKey = amountKey + 1;

        }
    }



    public  static int getAmountKey() {

        return amountKey;
    }

    public void changeKey(){
        this.key = new Grass().getGrass();
    }

}