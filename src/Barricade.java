import javax.swing.*;
import java.awt.*;

public class Barricade {

    private Image barricade;
    private int Tx,Ty;

    Barricade myBarricade = new Barricade();


    public Barricade(){

        myBarricade.getX(3);
        myBarricade.getY(11);
        myBarricade.setImage();

    }

    public int getX(int X){
        return X = Tx;


    }

    public int getY(int Y){
        return Y = Ty;

    }


    public Image getBarricade(){
        return  this.barricade;


    }

    public void changeBarricade(){
        this.barricade = new ImageIcon("Sprites\\grass.png").getImage();
        this.barricade = new Grass().getGrass();

    }

    public void setImage(){
        ImageIcon img = new ImageIcon("Sprites\\barricade.png");
        barricade = img.getImage();
    }







}
