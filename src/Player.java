import javax.swing.*;
import java.awt.*;

public class Player {

    private int tileX, tileY;

    private Image player;


    public Player(int x, int y){

        ImageIcon img = new ImageIcon("Sprites\\Guy2.png");
        player = img.getImage();
        this.tileX = x;
        this.tileY = y;


    }


    public  Image getPlayer(){
        return player;
    }


    public int getTileX(){
        return tileX;
    }

    public int getTileY(){
        return tileY;
    }


    public void move( int dx, int dy){

        tileX += dx;
        tileY += dy;
    }
}
