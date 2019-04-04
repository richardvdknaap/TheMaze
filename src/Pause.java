import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Pause {
    private int level;
    private Color bg = new Color(0x45220e);

    public Pause(int levels) {
        this.level = levels;
        JFrame g = new JFrame();
        JPanel p = new JPanel(new GridBagLayout());

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

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15,15,15,15);
        gbc.gridx=0;
        gbc.gridy=0;
        p.add(resume,gbc);
        gbc.gridy=1;
        p.add(restart,gbc);
        gbc.gridy=2;
        p.add(menu,gbc);
        p.setBackground(bg);
        g.add(p);

        g.setVisible(true);
    }

}
