import javax.swing.*;
import java.awt.*;

public class Player {

    private int tileX, tileY;

    private Image player;


    public Player(int x, int y) {

        ImageIcon img = new ImageIcon("Sprites\\Guy2.png");
        player = img.getImage();
        this.tileX = x;
        this.tileY = y;


    }


    public Image getPlayer() {
        return player;
    }


    public int getTileX() {
        return tileX;
    }

    public int getTileY() {
        return tileY;
    }


    public void move(int dx, int dy) {

        tileX += dx;
        tileY += dy;
    }

    public Image getPlayerR() {
        ImageIcon img2 = new ImageIcon("Sprites\\Guy Rechts.png");
        player = img2.getImage();
        return player;

    }

    public Image getPlayerL() {
        ImageIcon img3 = new ImageIcon("Sprites\\Guy Links.png");
        player = img3.getImage();
        return player;

    }

    public Image getPlayerA() {
        ImageIcon img4 = new ImageIcon("Sprites\\Guy Achter.png");
        player = img4.getImage();
        return player;

    }

    public Image getPlayerS() {
        ImageIcon img5 = new ImageIcon("Sprites\\Guy2.png");
        player = img5.getImage();
        return player;

    }

}
