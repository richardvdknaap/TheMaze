import javax.swing.*;
import java.awt.*;

public class Barricade {

    private Image barricade;
    private int x,y;
    private Player p;

    public Barricade(){

        ImageIcon img = new ImageIcon("Sprites\\barricade.png");
        barricade = img.getImage();
        p = new Player();


    }

    public void getXY(int xs, int ys){
        this.x = xs;
        this.y = ys;
    }


    public Image getBarricade(){
        return  this.barricade;


    }

    public void changeBarricade(){
        int playerx = p.getTileX();
        int playery = p.getTileY();

        if(this.x == playerx && this.y==playery) {
            this.barricade = new Grass().getGrass();
        }
    }



}
