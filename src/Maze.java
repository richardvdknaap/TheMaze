import javax.swing.*;

public class Maze {

    private int level;

    public Maze(int level){
        this.level = level;
        JFrame f = new JFrame();
        f.setTitle("SleutelBarricade");
        f.add(new Board(this.level));
        f.setSize(800,485);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
