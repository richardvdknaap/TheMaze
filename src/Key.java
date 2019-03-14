import javax.swing.*;
import java.awt.*;

public class Key {

    private Image key;
    private static int amountKey;


    public Key() {

        ImageIcon img = new ImageIcon("Sprites\\sleutel.png");
        key = img.getImage();


    }

    public Image getKey() {
        return key;
    }

    public void captureKey() {
        while (amountKey != 1) {
            amountKey = amountKey + 1;

        }
    }

    public static int getAmountKey() {
        return amountKey;
    }

    public void changeKey(){
        this.key = new Grass().getGrass();
    }

}