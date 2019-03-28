import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.function.BinaryOperator;

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
        m.add(b, BorderLayout.CENTER);
        m.setLocationRelativeTo(null);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Label
        JLabel titel = new JLabel("Sleutelbarricade The Game!\n");
        titel.setForeground(Color.white);
        titel.setFont(new Font("Serif", Font.PLAIN, 50));
        titel.repaint();


        // Button
        JButton start = new JButton("Start");
        start.setSize(200,200);
        start.setPreferredSize(new Dimension(200, 60));
        JButton levels = new JButton("Levels");



        // Object in Panel
        b.add(start);
        b.setBackground(Color.BLACK);
        b.add(levels);
        p.add(titel, BorderLayout.PAGE_START);
        p.setBackground(Color.BLACK);


        // Button event

        class ClickListerner implements ActionListener{


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
            }
        }

        ActionListener listener = new ClickListerner();
        start.addActionListener(listener);
        levels.addActionListener(listener);

        m.setVisible(true);


    }
}
