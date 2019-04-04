import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class Board extends JPanel implements ActionListener{


    private Timer timer;
    private Player p;
    private Map m;
    private List<Barricade> barricades;
    private List<Key> keys;
    private Wall w;
    private Grass n;
    private Finish f;
    private Inventory i;
    private int[][] barricadepos;
    private int[][] keypos;
    private boolean win = false;
    private int playerposx;
    private int playerposy;
    public int level;
    public int goUp;
    public int goRight;
    public int goDown;
    public int goLeft;


    public Board(int level){
        this.level = level;
        i = new Inventory();
        m = new Map(this.level);
        n = new Grass();
        f = new Finish();
        w = new Wall();


        timer = new Timer(25, this);
        addKeyListener(new Al());
        setFocusable(true);
        timer.start();
        setLevel();
        initPlayer();
        initBarricade();
        initKey();

    }



    public void setLevel(){
        if (getLevel()==1){
            barricadepos = new int[][]{{1, 1, 100}, {1, 2, 100}, {1, 3, 100}, {1, 4, 100}, {1, 5, 100}, {1, 6, 100}, {1, 7, 200}, {1, 8, 100}, {1, 9, 100}, {1, 10, 100}, {1, 11, 100}, {1, 12, 100}, {2, 1, 200}, {2, 7, 200}, {2, 12, 200}, {3, 1, 200}, {3, 2, 200}, {3, 4, 100}, {3, 5, 100}, {3, 6, 100}, {3, 8, 200}, {3, 9, 200}, {3, 10, 200}, {3, 12, 200}, {4, 2, 200}, {4, 4, 100}, {4, 10, 200}, {4, 12, 200}, {5, 2, 200}, {5, 4, 100}, {5, 9, 200}, {5, 10, 200}, {5, 12, 200}, {6, 2, 200}, {6, 4, 100}, {6, 5, 100}, {6, 9, 200}, {6, 10, 200}, {6, 12, 200}, {7, 10, 200}, {7, 12, 200}, {8, 2, 200}, {8, 3, 200}, {8, 4, 100}, {8, 5, 200}, {8, 6, 100}, {8, 12, 200}, {9, 2, 200}, {9, 9, 100}, {9, 10, 100}, {9, 11, 100}, {9, 12, 100}, {10, 2, 200}, {11, 10, 300}, {11, 11, 300}, {11, 12, 300}, {12, 2, 300}, {12, 3, 300}, {12, 4, 300}, {12, 5, 300}, {12, 6, 300}};
            Key.resetKey();
            barricadepos = new int[][]{{1, 1, 100}, {1, 2, 100}, {1, 3, 100}, {1, 4, 100}, {1, 5, 100}, {1, 6, 100}, {1, 7, 200}, {1, 8, 100}, {1, 9, 100}, {1, 10, 100}, {1, 11, 100}, {1, 12, 100}, {2, 1, 200}, {2, 7, 200}, {2, 12, 200}, {3, 1, 200}, {3, 2, 200}, {3, 4, 100}, {3, 5, 100}, {3, 6, 100}, {3, 8, 200}, {3, 9, 200}, {3, 10, 200}, {3, 12, 200}, {4, 2, 200}, {4, 4, 100}, {4, 10, 200}, {4, 12, 200}, {5, 2, 200}, {5, 4, 100}, {5, 9, 200}, {5, 10, 200}, {5, 12, 200}, {6, 2, 200}, {6, 4, 100}, {6, 5, 100}, {6, 9, 200}, {6, 10, 200}, {6, 12, 200}, {7, 10, 200}, {7, 12, 200}, {8, 2, 200}, {8, 3, 200}, {8, 4, 100}, {8, 5, 200}, {8, 6, 100}, {8, 12, 200}, {9, 2, 200}, {9, 9, 100}, {9, 10, 100}, {9, 11, 100}, {9, 12, 100}, {10, 2, 200}, {11, 10, 300}, {11, 11, 300}, {11, 12, 300}, {12, 2, 300}, {12, 3, 300}, {12, 4, 300}, {12, 5, 300}, {12, 6, 300}};
            keypos = new int[][]{{5, 5, 200}, {6, 1, 100}, {7, 9, 100}, {10, 1, 300}, {10, 4, 200}, {10, 9, 200}, {11, 2, 100}};
            playerposx = 12;
            playerposy = 10;
        }
        if (getLevel()==2){
            Key.resetKey();
            barricadepos = new int[][]{{1, 8, 100}, {1, 9, 100}, {1, 10, 100}, {1, 12, 100}, {2, 7, 100}, {2, 8, 100}, {2, 12, 100}, {3, 1, 300}, {3, 2, 300}, {3, 7, 100}, {3, 12, 100}, {4, 1, 300}, {4, 7, 100}, {4, 9, 100}, {4, 10, 100}, {4, 12, 100}, {5, 1, 300}, {5, 2, 300}, {5, 3, 300}, {5, 9, 100}, {5, 12, 100}, {6, 9, 100}, {6, 10, 100}, {6, 12, 100}, {7, 2, 300}, {7, 4, 300}, {7, 7, 300}, {8, 2, 300}, {8, 3, 300}, {8, 4, 300}, {8, 7, 100}, {8, 8, 300}, {9, 9, 100}, {9, 11, 100}, {9, 12, 300}, {10, 2, 200}, {10, 3, 200}, {10, 4, 200}, {10, 5, 200}, {10, 6, 200}, {10, 7, 200}, {10, 8, 200}, {11, 12, 300}, {12, 2, 100}, {12, 3, 100}, {12, 4, 100}, {12, 5, 100}, {12, 6, 100}, {12, 7, 100}, {12, 8, 100}, {12, 9, 100}};
            keypos = new int[][]{{1, 6, 300}, {1, 11, 200}, {3, 3, 100}, {3, 10, 300}, {5, 4, 200}, {7, 1, 100}, {7, 12, 300}, {9, 8, 200}, {10, 1, 100}, {10, 12, 200}, {12, 1, 300}};
            playerposx = 1;
            playerposy = 1;
        }
        if (getLevel()==3){
            Key.resetKey();
            barricadepos = new int[][] {{1, 6, 100}, {1, 7, 100}, {2, 5, 200}, {2, 7, 100}, {3, 5, 200}, {3, 7, 100}, {4, 1, 200}, {4, 2, 100}, {4, 3, 200}, {4, 5, 200}, {4, 7, 100}, {5, 1, 100}, {5, 3, 100}, {5, 5, 200}, {6, 1, 200}, {6, 3, 100}, {6, 4, 100}, {6, 5, 100}, {7, 2, 300}, {7, 7, 300}, {7, 8, 200}, {7, 9, 200}, {7, 10, 200}, {7, 11, 300}, {8, 2, 300}, {8, 7, 300}, {8, 12, 100}, {9, 1, 300}, {9, 2, 300}, {9, 7, 100}, {9, 8, 300}, {9, 9, 300}, {9, 10, 200}, {9, 12, 300}, {10, 1, 200}, {10, 10, 200}, {10, 12, 200}, {11, 1, 200}, {11, 9, 100}, {11, 10, 300}, {11, 12, 200}, {12, 1, 200}, {12, 2, 100}, {12, 3, 100}, {12, 4, 100}, {12, 5, 100}, {12, 6, 100}, {12, 10, 300}, {12, 11, 100}, {12, 12, 100}};
            keypos = new int[][] {{1, 9, 100}, {1, 10, 100}, {1, 11, 100}, {1, 1, 200}, {1, 2, 200}, {1, 3, 200}, {1, 4, 200}, {2, 1, 200}, {2, 2, 200}, {2, 3, 200}, {2, 9, 100}, {2, 10, 100}, {2, 11, 100}, {7, 1, 300}, {8, 4, 300}, {8, 5, 300}, {9, 4, 300}, {9, 5, 300}};
            playerposx = 5;
            playerposy = 12;
        }
    }
    public int getLevel(){
        return level;
    }
    public void initPlayer(){
        p = new Player(playerposx,playerposy);
    }
    public void initKey(){
        keys = new ArrayList<>();

        for (int[] p : keypos) {
            keys.add(new Key(p[0], p[1],p[2]));
        }
    }
    public void initBarricade(){

        barricades = new ArrayList<>();

        for (int[] p : barricadepos) {
            barricades.add(new Barricade(p[0], p[1], p[2]));
        }


    }


    public void actionPerformed(ActionEvent e){
        if(p!=null) {
            if (m.getMap(p.getTileX(), p.getTileY()).equals("f")) {
                p = null;
                Maze.close();
                new Endgame(this.level);


            }
        }


        for (Barricade barricade : barricades) {
            if(p!=null) {
                if ((p.getTileX() == barricade.getTileX()) && (p.getTileY() == barricade.getTileY())) {
                    barricade.changeBarricade();
                }
            }
        }

        for (Key key : keys) {
            if(p!=null) {
                if ((p.getTileX() == key.getTileX()) && (p.getTileY() == key.getTileY())) {
                    if (key.getValue() != 0) {
                        key.captureKey();
                        key.changeKey();
                    }
                }
            }
        }



        repaint();
    }

    private void drawObjects(Graphics g){

        //Draw Grass, Walls and Finish
        for(int y = 0; y < 14; y++){
            for(int x = 0; x < 14; x++){
                if(m.getMap(x, y).equals("g")){
                    g.drawImage(n.getGrass(),x * 32, y*32,null);
                }
                if(m.getMap(x, y).equals("f")){
                    g.drawImage(f.getFinish(),x * 32, y*32,null);
                }
                if(m.getMap(x, y).equals("w")){
                    g.drawImage(w.getWall(),x * 32, y*32,null);
                }

            }
        }
        //Draw Barricades
        for (Barricade barricade : barricades) {
            g.drawImage(barricade.getBarricade(), barricade.getTileX()*32, barricade.getTileY()*32, this);
        }

        //Draw Keys
        for (Key key : keys){
            g.drawImage(key.getKey(), key.getTileX()*32, key.getTileY()*32, this);
        }

        //Draw inventory
        g.drawString(i.invKey(),500,50);

        //Draw Player
        g.drawImage(p.getPlayer(),p.getTileX() * 32,p.getTileY()* 32,this);

        // PAUSE



    }



    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (win == true){

        }
        else {
            drawObjects(g);
        }

    }


    public class Al extends KeyAdapter{

        public void keyPressed(KeyEvent e){

            int keycode = e.getKeyCode();

            if(keycode == KeyEvent.VK_ESCAPE || keycode == KeyEvent.VK_P){
                Maze.pause();
                new Pause(level);
            }


            if(keycode == KeyEvent.VK_W || keycode == KeyEvent.VK_UP) {
                goUp = 1;
                p.getPlayerA();
                if(m.getMap(p.getTileX(),p.getTileY() - 1).equals("w")) {
                    goUp = 0;
                }
                for (Barricade barricade : barricades) {
                    if (barricade.getValue()!=0&&((p.getTileX()==barricade.getTileX()&&(p.getTileY() == (barricade.getTileY() + 1))) &&(Key.getAmountKey() != barricade.getValue()))) {
                        goUp = 0;
                    }
                }
                if (goUp == 0){
                    p.move(0,0);
                }
                else{
                    p.move(0,-1);
                }
            }

            if(keycode == KeyEvent.VK_S || keycode == KeyEvent.VK_DOWN){
                goDown = 1;
                p.getPlayerS();
                if(m.getMap(p.getTileX(),p.getTileY() + 1).equals("w")) {
                    goDown = 0;
                }
                for (Barricade barricade : barricades) {
                    if (barricade.getValue()!=0&&(p.getTileX()==barricade.getTileX()&&(p.getTileY() == (barricade.getTileY() - 1))) && (Key.getAmountKey() != barricade.getValue())) {
                        goDown = 0;
                    }
                }
                if (goDown == 0){
                    p.move(0,0);
                }
                else{
                    p.move(0,+1);
                }

            }
            if(keycode == KeyEvent.VK_A || keycode == KeyEvent.VK_LEFT){
                goLeft = 1;
                p.getPlayerL();
                if(m.getMap(p.getTileX()-1,p.getTileY()).equals("w")) {
                    goLeft = 0;
                }
                for (Barricade barricade : barricades) {
                    if (barricade.getValue()!=0&&(p.getTileX()-1==barricade.getTileX()&&(p.getTileY() == (barricade.getTileY()))) && (Key.getAmountKey() != barricade.getValue())) {
                        goLeft = 0;
                    }
                }
                if (goLeft == 0){
                    p.move(0,0);
                }
                else{
                    p.move(-1,0);
                }


            }
            if(keycode == KeyEvent.VK_D || keycode == KeyEvent.VK_RIGHT){
                goRight = 1;
                p.getPlayerR();
                if(m.getMap(p.getTileX()+1,p.getTileY()).equals("w")) {
                    goRight = 0;
                }
                for (Barricade barricade : barricades) {
                    if (barricade.getValue()!=0&&(p.getTileX()+1==barricade.getTileX()&&(p.getTileY() == (barricade.getTileY()))) && (Key.getAmountKey() != barricade.getValue())) {
                        goRight = 0;
                    }
                }
                if (goRight == 0){
                    p.move(0,0);
                }
                else{
                    p.move(+1,0);
                }

            }
        }

        public void keyReleased(KeyEvent e){

        }

        public void keyTyped(KeyEvent e){

        }
    }
}
