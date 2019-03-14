import javax.swing.*;
import java.awt.*;


public class Wall {

    private Image wall;

    public Wall(){

        ImageIcon img = new ImageIcon("Sprites\\wall.png");
        wall = img.getImage();
    }
    public Image getWall(){
        return  wall;


    }
}
