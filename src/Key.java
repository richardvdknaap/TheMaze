import javax.swing.*;
import java.awt.*;

public class Key {

    private Image key;

    public Key(){

        ImageIcon img = new ImageIcon("Sprites\\sleutel.png");
        key = img.getImage();


    }

    public Image getKey(){
        return key;
    }
}
