import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;

public class Menu {

    private int level;
    public static void main(String[] args) {
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



        // Label
        JLabel titel = new JLabel("Sleutelbarricade The Game!\n");
        titel.setForeground(Color.BLACK);
        titel.setFont(new Font("Serif", Font.PLAIN, 50));
        titel.repaint();


        // Button
        //JButton start = new JButton();
        //start.setSize(50,50);
        //start.setPreferredSize(new Dimension(100, 60));
        //JButton levels = new JButton("Levels");
        //levels.setSize(200,200);
        //levels.setPreferredSize(new Dimension(100, 60));
        JButton exit = new JButton("Quit Game");
        exit.setSize(100,200);
        exit.setPreferredSize(new Dimension(100, 60));

        // LABEL START
        JLabel start = new JLabel();
        start.setIcon(new ImageIcon("Sprites\\start_goed1.png"));
        start.setSize(new Dimension(299,196));

        start.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                level = 1;
                new Maze(level);
                m.dispose();

            }
            public void mouseEntered(MouseEvent e) {
                start.setIcon(new ImageIcon("Sprites\\ezgif.com-resize.gif"));

            }
            public void mouseExited(MouseEvent e){
                start.setIcon(new ImageIcon("Sprites\\start_goed1.png"));
            }
        });

        // LABEL LEVELS

        JLabel levels = new JLabel();
        levels.setIcon(new ImageIcon("Sprites\\"));


        // Object in Panel
        b.add(start);
        b.add(levels);
        b.add(exit);
        p.add(titel, BorderLayout.PAGE_START);


        // Button event

        class ClickListerner implements ActionListener, KeyListener {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                int keycode = e.getKeyCode();

                if (keycode == KeyEvent.VK_ESCAPE) {
                    System.out.println("YOOOO");
                    System.exit(0);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

            public void actionPerformed(ActionEvent event) {

                if(event.getSource()==start) {
                    level = 1;
                    new Maze(level);
                    m.dispose();
                }
                if (event.getSource()==levels) {
                    new Levels();
                    m.dispose();
                }
                if (event.getSource()==exit) {
                    System.exit(0);
                }
            }
        }

        ActionListener listener = new ClickListerner();
        exit.addActionListener(listener);

        m.setVisible(true);


    }
}
