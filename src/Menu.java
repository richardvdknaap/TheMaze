import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {

    public static void main(String[] args) {
        new Menu();
    }

    public Menu(){
        JFrame m = new JFrame();
        JPanel p = new JPanel();

        // Scherm
        m.setTitle("SleutelBarricade");
        m.setSize(800,485);
        m.add(p);
        m.setLocationRelativeTo(null);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Button
        JButton Start = new JButton("Start");
        p.add(Start, BorderLayout.CENTER);

        // Button event

        class ClickListerner implements ActionListener{

            public void actionPerformed(ActionEvent event){
                new Maze();
                m.dispose();
            }
        }

        ActionListener listener = new ClickListerner();
        Start.addActionListener(listener);

        m.setVisible(true);



    }
}
