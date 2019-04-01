import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;

public class Endgame {
    private int level;

    public Endgame(int levels) {
        this.level = levels;
        JFrame g = new JFrame();
        JPanel p = new JPanel();

        // Panel
        g.add(p, BorderLayout.CENTER);


        // Scherm
        g.setTitle("SleutelBarricade");
        g.setSize(800,485);
        g.setLocationRelativeTo(null);
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // LABEL START
        JLabel next = new JLabel();
        next.setIcon(new ImageIcon("Sprites\\Next.png"));
        next.setSize(new Dimension(300,86));

        // LABEL LEVELS
        JLabel menu = new JLabel();
        menu.setIcon(new ImageIcon("Sprites\\Menu.png"));
        menu.setSize(300,86);

        // MOUSELISTENER VOOR NEXT
        next.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                level ++;
                new Maze(level);
                g.dispose();

            }
            public void mouseEntered(MouseEvent e) {
                next.setIcon(new ImageIcon("Sprites\\Next_hover.gif"));

            }
            public void mouseExited(MouseEvent e){
                next.setIcon(new ImageIcon("Sprites\\Next.png"));
            }
        });

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
        p.add(next);
        p.add(menu);

        g.add(p);

        g.setVisible(true);



    }
}
