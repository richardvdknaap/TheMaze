import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Endgame {
    private int level;
    private Color bg = new Color(0x45220e);

    public Endgame(int levels) {
        this.level = levels;
        JFrame g = new JFrame();
        JPanel p = new JPanel(new GridBagLayout());


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15,15,15,15);
        gbc.gridx=0;
        gbc.gridy=1;

        // Panel
        g.add(p, BorderLayout.CENTER);


        // Scherm
        g.setTitle("SleutelBarricade");
        g.setSize(800,485);
        g.setLocationRelativeTo(null);
        g.setResizable(false);
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // LABEL COMPLETE
        JLabel complete = new JLabel();
        complete.setIcon(new ImageIcon("Sprites\\Complete.gif"));
        complete.setSize(509,86);


        // LABEL NEXT
        if(level!=3) {
            JLabel next = new JLabel();
            next.setIcon(new ImageIcon("Sprites\\Next.png"));
            next.setSize(new Dimension(300, 86));


            // MOUSELISTENER VOOR NEXT
            next.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    level++;
                    new Maze(level);
                    g.dispose();

                }

                public void mouseEntered(MouseEvent e) {
                    next.setIcon(new ImageIcon("Sprites\\Next_hover.gif"));

                }

                public void mouseExited(MouseEvent e) {
                    next.setIcon(new ImageIcon("Sprites\\Next.png"));
                }
            });
            p.add(next,gbc);
        }
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
                g.dispose();

            }
            public void mouseEntered(MouseEvent e) {
                menu.setIcon(new ImageIcon("Sprites\\Menu_hover.gif"));

            }
            public void mouseExited(MouseEvent e){
                menu.setIcon(new ImageIcon("Sprites\\Menu.png"));
            }
        });

        gbc.gridy=0;
        p.add(complete,gbc);
        gbc.gridy=2;
        p.add(menu,gbc);
        p.setBackground(bg);
        g.add(p);

        g.setVisible(true);



    }
}
