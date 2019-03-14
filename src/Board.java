import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel implements ActionListener{

    private Timer timer;
    private Player p;

    private Map m;
    private String Message = "";
    private Barricade b;



    public Board(){

        m = new Map();
        p = new Player();
        b = new Barricade();
        timer = new Timer(25, this);
        addKeyListener(new Al());
        setFocusable(true);
        timer.start();

    }
    public void actionPerformed(ActionEvent e){
        if(m.getMap(p.getTileX(), p.getTileY()).equals("f")){
            Message = "Winner";
        }

        if(m.getMap(p.getTileX(), p.getTileY()).equals("b")) {


        }


        repaint();
    }


    public void paint(Graphics g){
        super.paint(g);

        for(int y = 0; y < 14; y++){
            for(int x = 0; x < 14; x++){
                if(m.getMap(x, y).equals("g")){
                    g.drawImage(m.getGrass(),x * 32, y*32,null);
                }
                if(m.getMap(x, y).equals("f")){
                    g.drawImage(m.getFinish(),x * 32, y*32,null);
                }
                if(m.getMap(x, y).equals("w")){
                    g.drawImage(m.getWall(),x * 32, y*32,null);
                }
                if(m.getMap(x, y).equals("s")){
                    g.drawImage(m.getSleutel(),x * 32, y*32,null);
                }
                if(m.getMap(x, y).equals("b")){
                    g.drawImage(b.getBarricade(),x * 32, y*32,null);
                }
            }
        }
        g.drawString(Message,50,50);

        g.drawImage(p.getPlayer(),p.getTileX() * 32,p.getTileY()* 32,null);

    }

    public class Al extends KeyAdapter{

        public void keyPressed(KeyEvent e){

            int keycode = e.getKeyCode();

            if(keycode == KeyEvent.VK_W){
                if(!m.getMap(p.getTileX(),p.getTileY() - 1).equals("w")){
                    p.move(0,-1);}


            }
            if(keycode == KeyEvent.VK_S){
                if(!m.getMap(p.getTileX(),p.getTileY() + 1).equals("w")){
                p.move(0,1);}


            }
            if(keycode == KeyEvent.VK_A){
                if(!m.getMap(p.getTileX() - 1,p.getTileY()).equals("w")){
                p.move(-1,0);}

            }
            if(keycode == KeyEvent.VK_D){
                if(!m.getMap(p.getTileX() + 1,p.getTileY()).equals("w")){
                p.move(1,0);}

            }

        }

        public void keyReleased(KeyEvent e){

        }

        public void keyTyped(KeyEvent e){

        }
    }
}
