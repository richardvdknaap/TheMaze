import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Board extends JPanel implements ActionListener{


    private Timer timer;
    private Player p;
    private Map m;
    private String Message = "";
    private List<Barricade> barricades;
    private List<Key> keys;
    private Wall w;
    private Grass n;
    private Finish f;
    private Inventory i;
    private final int[][] barricadepos = {{3, 11, 100}, {2, 2, 200}, {2, 3, 300}};
    private final int[][] keypos = {{4,6,100},{9,4,200},{5,2,300}};
    private boolean win = false;
    public int goUp;
    public int goRight;
    public int goDown;
    public int goLeft;


    public Board(){
        i = new Inventory();
        m = new Map();
        p = new Player(1,1);
        n = new Grass();
        f = new Finish();
        w = new Wall();

        timer = new Timer(25, this);
        addKeyListener(new Al());
        setFocusable(true);
        timer.start();
        initBarricade();
        initKey();

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
        if(m.getMap(p.getTileX(), p.getTileY()).equals("f")){
            Message = "Winner";
            win = true;

        }


        for (Barricade barricade : barricades) {
            if((p.getTileX()==barricade.getTileX()) && (p.getTileY()==barricade.getTileY())){
                barricade.changeBarricade();
            }
        }

        for (Key key : keys) {
            if((p.getTileX()==key.getTileX()) && (p.getTileY()==key.getTileY())){
                key.changeKey();
                key.captureKey();
                System.out.println(key.getAmountKey());
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


    }

    private void drawComponents(Graphics g){
        g.drawString(Message,50,50);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if (win == true){
            drawComponents(g);
        }
        else {
            drawObjects(g);
        }

    }

    public class Al extends KeyAdapter{

        public void keyPressed(KeyEvent e){

            int keycode = e.getKeyCode();

            if(keycode == KeyEvent.VK_ESCAPE){
                System.exit(0);
            }


            if(keycode == KeyEvent.VK_W) {
                goUp = 1;
                p.getPlayerA();
                if(m.getMap(p.getTileX(),p.getTileY() - 1).equals("w")) {
                    goUp = 0;
                }
                for (Barricade barricade : barricades) {
                    if ((p.getTileX()==barricade.getTileX()&&(p.getTileY() == (barricade.getTileY() + 1))) && (Key.getAmountKey() != barricade.getValue())) {
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

            if(keycode == KeyEvent.VK_S){
                goDown = 1;
                p.getPlayerS();
                if(m.getMap(p.getTileX(),p.getTileY() + 1).equals("w")) {
                    goDown = 0;
                }
                for (Barricade barricade : barricades) {
                    if ((p.getTileX()==barricade.getTileX()&&(p.getTileY() == (barricade.getTileY() - 1))) && (Key.getAmountKey() != barricade.getValue())) {
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
            if(keycode == KeyEvent.VK_A){
                goLeft = 1;
                p.getPlayerL();
                if(m.getMap(p.getTileX()-1,p.getTileY()).equals("w")) {
                    goLeft = 0;
                }
                for (Barricade barricade : barricades) {
                    if ((p.getTileX()-1==barricade.getTileX()&&(p.getTileY() == (barricade.getTileY()))) && (Key.getAmountKey() != barricade.getValue())) {
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
            if(keycode == KeyEvent.VK_D){
                goRight = 1;
                p.getPlayerR();
                if(m.getMap(p.getTileX()+1,p.getTileY()).equals("w")) {
                    goRight = 0;
                }
                for (Barricade barricade : barricades) {
                    if ((p.getTileX()+1==barricade.getTileX()&&(p.getTileY() == (barricade.getTileY()))) && (Key.getAmountKey() != barricade.getValue())) {
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
