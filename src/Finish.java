import javax.swing.*;
import java.awt.*;

public class Finish {

    private Image finish;

    public Finish(){

        ImageIcon img = new ImageIcon("Sprites\\finish.png");
        finish = img.getImage();
    }

    public Image getFinish(){
        return finish;
    }
}
