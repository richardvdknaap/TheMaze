import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Levels {

    private int level;

    public Levels() {

        JFrame m = new JFrame();
        JPanel b = new JPanel();
        m.add(b, BorderLayout.CENTER);
        m.setTitle("SleutelBarricade");
        m.setSize(800,485);
        m.setLocationRelativeTo(null);
        m.setVisible(true);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Button
        JButton level1 = new JButton("Level 1");
        JButton level2 = new JButton("Level 2");
        JButton level3 = new JButton("Level 3");


        // Object in Panel
        b.add(level1);
        b.add(level2);
        b.add(level3);

        class ClickListerner implements ActionListener {


            public void actionPerformed(ActionEvent event) {
                if (event.getSource() == level1) {
                    level = 1;
                    new Maze(level);
                    m.dispose();
                }
                if (event.getSource() == level2) {
                    level = 2;
                    new Maze(level);
                    m.dispose();
                }
                if (event.getSource() == level3) {
                    level = 3;
                    new Maze(level);
                    m.dispose();
                }
            }
        }

        ActionListener listener = new ClickListerner();
        level1.addActionListener(listener);
        level2.addActionListener(listener);
        level3.addActionListener(listener);

    }
}

