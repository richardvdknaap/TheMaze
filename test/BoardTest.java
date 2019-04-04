import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void collision(){
        boolean collision;
        Player p = new Player(2,2);
        Barricade barricade = new Barricade(3,3,100);
        p.move(1,1);
        if ((p.getTileX() == barricade.getTileX()) && (p.getTileY() == barricade.getTileY())) {
             collision = true;
        }
        else {
            collision = false;
        }
        assertEquals(true, collision);

        //Invoer: move (1,1)
        //Verwachte uitvoer: Collision = true
        //Werkelijke uitvoer: Collision = true
    }

    @Test
    public void getKey(){
        int keyValue;
        Player p = new Player(2,2);
        Key key = new Key(3,3,200);
        p.move(1,1);
        if ((p.getTileX() == key.getTileX()) && (p.getTileY() == key.getTileY())) {
           key.captureKey();
        }
        keyValue = key.getAmountKey();
        assertEquals(200, keyValue);

        //Invoer: move (1,1)
        //Verwachte uitvoer: Waarde key = 200
        //Werkelijke uitvoer: Waarde key = 200
    }
}

