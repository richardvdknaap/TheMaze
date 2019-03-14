import javax.swing.*;
import java.awt.*;

public class Barricade {

    private Image barricade;

    public Barricade(){

        ImageIcon img = new ImageIcon("Sprites\\barricade.png");
        barricade = img.getImage();


    }

    public Image getBarricade(){
        return  barricade;


    }

    public void changeBarricade(){
        this.barricade = new ImageIcon("Sprites\\grass.png").getImage();
    }



}
