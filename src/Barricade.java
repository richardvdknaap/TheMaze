import javax.swing.*;
import java.awt.*;

public class Barricade{

    private Image barricade;
    private int tileX,tileY;

    Barricade myBarricade = new Barricade();


    public Barricade(){

        myBarricade.getX(3);
        myBarricade.getY(11);
        myBarricade.setImage();
    private int tileX,tileY;

    public Barricade(int x, int y){
        ImageIcon img = new ImageIcon("Sprites\\barricade.png");
        barricade = img.getImage();

        this.tileX = x;
        this.tileY = y;


    public int getY(int Y){
        return Y = Ty;
    }


    public Image getBarricade(){
        return  barricade;
    }

    public int getTileX(){
        return tileX;
    }

    public int getTileY(){
        return tileY;
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
