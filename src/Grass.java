import javax.swing.*;
import java.awt.*;

public class Grass {
    private Image grass;

    public Grass(){

        ImageIcon img = new ImageIcon("Sprites\\grass.png");
        grass = img.getImage();


    }

    public Image getGrass(){
        return grass;
    }
}
