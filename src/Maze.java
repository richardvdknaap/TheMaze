import javax.swing.*;

public class Maze {

    //public static void main(String[] args) {
       // new Maze();
    //}

    public Maze(){
        JFrame f = new JFrame();
        f.setTitle("SleutelBarricade");
        f.add(new Board());
        f.setSize(800,485);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
