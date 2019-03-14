import javax.swing.*;
import java.awt.*;

public class Barricade {

    private Image barricade;
    private int x,y;


    public Barricade(){

        ImageIcon img = new ImageIcon("Sprites\\barricade.png");
        barricade = img.getImage();

    }

    public void getXY(int xs, int ys){
        this.x = xs;
        this.y = ys;
        System.out.println(this.y + " " + this.x);
    }


    public Image getBarricade(){
        return  this.barricade;


    }

    public void changeBarricade(){
        //if(hit & key == true) {
            this.barricade = new Grass().getGrass();
        //}
    }



}
