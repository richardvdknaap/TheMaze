import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu {

    private int level;
    private Color bg = new Color(0x45220e);



    public static void main(String[] args){
        new Menu();
    }

    public Menu(){

        JFrame m = new JFrame();
        JPanel p = new JPanel();
        JPanel b = new JPanel(new GridBagLayout());

        // Scherm
        m.setTitle("SleutelBarricade");
        m.setSize(800,485);
        m.add(p, BorderLayout.NORTH);
        m.add(b, BorderLayout.CENTER);
        m.setLocationRelativeTo(null);
        m.setResizable(false);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        // Label TITEL
        JLabel title = new JLabel(new ImageIcon("Sprites\\Title.gif"));
        title.setSize(509,86);

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
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15,15,15,15);
        gbc.gridx = 0;
        gbc.gridy = 0;
        b.add(title,gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        b.add(start , gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        b.add(levels , gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        b.add(exit, gbc);

        b.setBackground(bg);
        p.setBackground(bg);



        // Button event

        m.setVisible(true);

    }

}
