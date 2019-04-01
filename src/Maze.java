import javax.swing.*;

public class Maze {

    private int level;
    private static JFrame f;

    public Maze(int level){
        this.level = level;
        f = new JFrame();
        f.setTitle("SleutelBarricade");
        f.add(new Board(this.level));
        f.setSize(800,485);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void close(){
        f.dispose();
    }

    public static void pause(){
        f.setVisible(false);
    }
    public static void cont(){
        f.setVisible(true);
    }



}
