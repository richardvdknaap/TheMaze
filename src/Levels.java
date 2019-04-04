import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Levels {

    private int level;
    private Color bg = new Color(0x45220e);

    public Levels() {

        JFrame m = new JFrame();
        JPanel b = new JPanel(new GridBagLayout());
        m.add(b, BorderLayout.CENTER);
        m.setTitle("SleutelBarricade");
        m.setSize(800, 485);
        m.setLocationRelativeTo(null);
        m.setResizable(false);
        m.setVisible(true);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // LABEL VOOR LEVEL 1
        JLabel l1 = new JLabel();
        l1.setIcon(new ImageIcon("Sprites\\Level1.png"));
        l1.setSize(new Dimension(300, 86));


        // MOUSELISTENER VOOR LEVEL 1
        l1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                level = 1;
                new Maze(level);
                m.dispose();

            }

            public void mouseEntered(MouseEvent e) {
                l1.setIcon(new ImageIcon("Sprites\\Level1_hover.gif"));

            }

            public void mouseExited(MouseEvent e) {
                l1.setIcon(new ImageIcon("Sprites\\Level1.png"));
            }
        });

        // LABEL VOOR LEVEL 2
                JLabel l2 = new JLabel();
                l2.setIcon(new ImageIcon("Sprites\\Level2.png"));
                l2.setSize(new Dimension(300, 86));


        // MOUSELISTENER VOOR LEVEL 2
        l2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                level = 2;
                new Maze(level);
                m.dispose();

            }

            public void mouseEntered(MouseEvent e) {
                l2.setIcon(new ImageIcon("Sprites\\Level2_hover.gif"));

            }

            public void mouseExited(MouseEvent e) {
                l2.setIcon(new ImageIcon("Sprites\\Level2.png"));
            }
        });

        // LABEL VOOR LEVEL 3
        JLabel l3 = new JLabel();
        l3.setIcon(new ImageIcon("Sprites\\Level3.png"));
        l3.setSize(new Dimension(300, 86));


        // MOUSELISTENER VOOR LEVEL 3
        l3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                level = 3;
                new Maze(level);
                m.dispose();

            }

            public void mouseEntered(MouseEvent e) {
                l3.setIcon(new ImageIcon("Sprites\\Level3_hover.gif"));

            }

            public void mouseExited(MouseEvent e) {
                l3.setIcon(new ImageIcon("Sprites\\Level3.png"));
            }
        });


        // LABEL MENU
        JLabel menu = new JLabel();
        menu.setIcon(new ImageIcon("Sprites\\Menu.png"));
        menu.setSize(300,86);

        // MOUSELISTENER VOOR MENU
        menu.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                new Menu();
                m.dispose();

            }
            public void mouseEntered(MouseEvent e) {
                menu.setIcon(new ImageIcon("Sprites\\Menu_hover.gif"));

            }
            public void mouseExited(MouseEvent e){
                menu.setIcon(new ImageIcon("Sprites\\Menu.png"));
            }
        });

        //Add Objects in panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15,15,15,15);

        gbc.gridx = 0;
        gbc.gridy = 0;
        b.add(l1 , gbc);
        gbc.gridy = 1;
        b.add(l2 , gbc);
        gbc.gridy = 2;
        b.add(l3, gbc);
        gbc.gridy = 3;
        b.add(menu, gbc);
        b.setBackground(bg);
    }
}

