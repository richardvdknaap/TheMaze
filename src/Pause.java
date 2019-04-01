import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Pause {
    private int level;

    public Pause(int levels) {
        this.level = levels;
        JFrame g = new JFrame();
        JPanel p = new JPanel();

        //PANEL
        g.add(p, BorderLayout.CENTER);

        // Scherm
        g.setTitle("SleutelBarricade");
        g.setSize(800,485);
        g.setLocationRelativeTo(null);
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // LABEL RESUME
        JLabel resume = new JLabel();
        resume.setIcon(new ImageIcon("Sprites\\Resume.png"));
        resume.setSize(new Dimension(300,86));

        // LABEL RESTART
        JLabel restart = new JLabel();
        restart.setIcon(new ImageIcon("Sprites\\Restart.png"));
        restart.setSize(new Dimension(300,86));

        // LABEL MENU
        JLabel menu = new JLabel();
        menu.setIcon(new ImageIcon("Sprites\\Menu.png"));
        menu.setSize(300,86);


        // MOUSELISTENER VOOR RESUME
        resume.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                Maze.cont();
                g.dispose();

            }
            public void mouseEntered(MouseEvent e) {
                resume.setIcon(new ImageIcon("Sprites\\Resume_Hover.gif"));

            }
            public void mouseExited(MouseEvent e){
                resume.setIcon(new ImageIcon("Sprites\\Resume.png"));
            }
        });

        // MOUSELISTENER VOOR RESTART
        restart.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                Maze.close();
                g.dispose();
                new Maze(level);

            }
            public void mouseEntered(MouseEvent e) {
                restart.setIcon(new ImageIcon("Sprites\\Restart_hover.gif"));

            }
            public void mouseExited(MouseEvent e){
                restart.setIcon(new ImageIcon("Sprites\\Restart.png"));
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
        p.add(resume);
        p.add(restart);
        p.add(menu);

        g.add(p);

        g.setVisible(true);
    }

}
