import javax.swing.*;
import java.awt.*;

public class Inventory extends JPanel{

    private Key k;
    private String key = "Key: ";


    public String invKey(){


        return key + Key.getAmountKey();
    }
}
