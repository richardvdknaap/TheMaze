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
    private Key k;
    private Wall w;
    private Grass n;
    private Finish f;
    private Inventory i;
    private final int[][] barricadepos = {{3, 11}, {2, 2}, {2, 3}};
    private final int[][] keypos = {{4,6},{9,4}};


    public Board(){
        i = new Inventory();
        m = new Map();
        p = new Player(1,1);
        k = new Key(4,4);
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
            keys.add(new Key(p[0], p[1]));
        }
    }
    public void initBarricade(){

        barricades = new ArrayList<>();

        for (int[] p : barricadepos) {
            barricades.add(new Barricade(p[0], p[1]));
        }


    }
    public void actionPerformed(ActionEvent e){
        if(m.getMap(p.getTileX(), p.getTileY()).equals("f")){
            Message = "Winner";

        }


        if(m.getMap(p.getTileX(), p.getTileY()).equals("b")) {
            if(k.getAmountKey() >= 1 ){

            }

        }

        if(m.getMap(p.getTileX(), p.getTileY()).equals("s")) {
            k.captureKey();
            k.changeKey();
            System.out.println("key captured");
            System.out.println(k.getAmountKey());

        }
        /*if(m.getMap(p.getTileX(),p.getTileY()) == m.getMap(b.getX(),b.getY())){
            b.changeBarricade();
            }*/




        repaint();
    }
    private void drawObjects(Graphics g){
        for (Barricade barricade : barricades) {
            g.drawImage(barricade.getBarricade(), barricade.getTileX()*32, barricade.getTileY()*32, this);
        }
        for (Key key : keys){
            g.drawImage(key.getKey(), key.getTileX()*32, key.getTileY()*32, this);
        }
        g.drawImage(p.getPlayer(),p.getTileX() * 32,p.getTileY()* 32,null);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        for(int y = 0; y < 14; y++){
            for(int x = 0; x < 14; x++){
                if(m.getMap(x, y).equals("g")){
                    g.drawImage(n.getGrass(),x * 32, y*32,this);
                }
                if(m.getMap(x, y).equals("f")){
                    g.drawImage(f.getFinish(),x * 32, y*32,this);
                }
                if(m.getMap(x, y).equals("w")){
                    g.drawImage(w.getWall(),x * 32, y*32,this);
                }
                if(m.getMap(x, y).equals("s")){
                    g.drawImage(k.getKey(),x * 32, y*32,this);
                }
                if(m.getMap(x, y).equals("b")){
                    //g.drawImage(b.getBarricade(),x * 32, y*32,this);
                }

            }
        }
        g.drawString(i.invKey(),500,50);
        g.drawString(Message,50,50);
        drawObjects(g);
       // g.drawImage(k.getKey(),k.getTileX() * 32, k.getTileY()*32,null);


    }

    public class Al extends KeyAdapter{

        public void keyPressed(KeyEvent e){

            int keycode = e.getKeyCode();

            if(keycode == KeyEvent.VK_ESCAPE){
                System.exit(0);
            }

            if (keycode == KeyEvent.VK_R) {

                new Maze();
            }


            if(keycode == KeyEvent.VK_W){
                if(m.getMap(p.getTileX(),p.getTileY() - 1).equals("w")){
                    p.move(0,0);}

                /*else if(b.getcollision(p.getTileX(),p.getTileY())==true){
                    p.move(0, -1);
                    b.changeBarricade();
                }*/

                else if(m.getMap(p.getTileX(),p.getTileY() -1).equals("b")&&k.getAmountKey()!=1){
                    p.move(0, 0);
                }
                else{
                    p.move(0,-1);
                }



            }
            if(keycode == KeyEvent.VK_S){
                if(m.getMap(p.getTileX(),p.getTileY() + 1).equals("w")){
                    p.move(0,0);}

                else if(m.getMap(p.getTileX(),p.getTileY() +1).equals("b")&&k.getAmountKey()==1){
                    p.move(0, 1);
                }

                else if(m.getMap(p.getTileX(),p.getTileY() +1).equals("b")&&k.getAmountKey()!=1){
                    p.move(0, 0);
                }
                else{
                    p.move(0,1);
                }

            }
            if(keycode == KeyEvent.VK_A){
                if(m.getMap(p.getTileX() - 1,p.getTileY()).equals("w")){
                    p.move(0,0);}

                else if(m.getMap(p.getTileX() -1 ,p.getTileY()).equals("b")&&k.getAmountKey()==1){
                    p.move(-1, 0);
                }
                else if(m.getMap(p.getTileX() -1 ,p.getTileY()).equals("b")&&k.getAmountKey()!=1){
                    p.move(0, 0);
                }
                else{
                    p.move(-1,0);
                }


            }
            if(keycode == KeyEvent.VK_D){
                if(m.getMap(p.getTileX() + 1,p.getTileY()).equals("w")){
                    p.move(0,0);}

                else if(m.getMap(p.getTileX() + 1,p.getTileY()).equals("b")&&k.getAmountKey()==1){
                    p.move(1, 0);
                }

                else if(m.getMap(p.getTileX() + 1,p.getTileY()).equals("b")&&k.getAmountKey()!=1){
                    p.move(0, 0);
                }
                else{
                    p.move(1,0);
                }


            }

        }

        public void keyReleased(KeyEvent e){

        }

        public void keyTyped(KeyEvent e){

        }
    }
}
