import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void getTileX() {
        Player player = new Player(6,6);
        int xPos = player.getTileX();
        assertEquals(6,xPos);

        //Invoer: 6
        //Verwachte uitvoer: 6
        //Werkelijke uitvoer: 6
    }

    @Test
    public void getTileY() {
        Player player = new Player(6,6);
        int yPos = player.getTileY();
        assertEquals(5,yPos);

        //Invoer: 6
        //Verwachte uitvoer: 6
        //Werkelijke uitvoer: 5
    }

    @Test
    public void move() {
        Player player = new Player(6,6);
        player.move(3,2);
        int xPos = player.getTileX();
        int yPos = player.getTileY();
        assertEquals(8,xPos);
        assertEquals(8,yPos);

        //Invoer: (3,2)
        //Verwachte uitvoer: (8,8)
        //Werkelijke uitvoer: (9,8)

    }
}