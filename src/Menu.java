import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;

public class Menu {
    private int level;


    public static void main(String[] args){
        new Menu();
    }

    public Menu(){

        JFrame m = new JFrame();
        JPanel p = new JPanel();
        JPanel b = new JPanel();

        // Scherm
        m.setTitle("SleutelBarricade");
        m.setSize(800,485);
        m.add(p, BorderLayout.NORTH);
        m.add(b);
        m.setLocationRelativeTo(null);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        // Label TITEL
        JLabel titel = new JLabel("Sleutelbarricade The Game!\n");
        titel.setForeground(Color.BLACK);
        titel.setFont(new Font("Serif", Font.PLAIN, 50));
        titel.repaint();

        // LABEL START
        JLabel start = new JLabel();
        start.setIcon(new ImageIcon("Sprites\\start_goeie_goeie_normaal.png"));
        start.setSize(new Dimension(300,86));

        // LABEL LEVELS
        JLabel levels = new JLabel();
        levels.setIcon(new ImageIcon("Sprites\\Levels.png"));
        levels.setSize(300,86);

        // LABEL EXIT
        JLabel exit = new JLabel();
        exit.setIcon(new ImageIcon("Sprites\\Exit.png"));
        exit.setSize(300,86);


        // MOUSELISTENER VOOR START
        start.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                level = 1;
                new Maze(level);
                m.dispose();

            }
            public void mouseEntered(MouseEvent e) {
                start.setIcon(new ImageIcon("Sprites\\start_goeie_goeie_hover.gif"));

            }
            public void mouseExited(MouseEvent e){
                start.setIcon(new ImageIcon("Sprites\\start_goeie_goeie_normaal.png"));
            }
        });

        // MOUSELISTENER VOOR LEVELS
        levels.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                new Levels();
                m.dispose();

            }
            public void mouseEntered(MouseEvent e) {
                levels.setIcon(new ImageIcon("Sprites\\Levels_hover.gif"));

            }
            public void mouseExited(MouseEvent e){
                levels.setIcon(new ImageIcon("Sprites\\Levels.png"));
            }
        });

        // MOUSELISTENER VOOR EXIT
        exit.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                System.exit(0);

            }
            public void mouseEntered(MouseEvent e) {
                exit.setIcon(new ImageIcon("Sprites\\Exit_hover.gif"));

            }
            public void mouseExited(MouseEvent e){
                exit.setIcon(new ImageIcon("Sprites\\Exit.png"));
            }
        });


        // Object in Panel
        b.add(start);
        b.add(levels);
        b.add(exit);
        p.add(titel, BorderLayout.PAGE_START);


        // Button event

        m.setVisible(true);

    }

}
