import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Endgame {

    public Endgame() {
        JFrame g = new JFrame();
        JPanel p = new JPanel();

        // Scherm
        g.setTitle("SleutelBarricade");
        g.setSize(800,485);
        g.setLocationRelativeTo(null);
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // label
        Icon icon = new ImageIcon("Sprites\\endgame.gif");;
        JLabel label = new JLabel(icon);
        g.add(label);


        g.setVisible(true);



    }
}