import javax.swing.*;
import java.awt.*;

public class Inventory{

    private String key = "Key: ";



    public String invKey(){
       return key + Key.getAmountKey();

    public static String invKey(){
        String key = "Key: ";

        return key + Key.getAmountKey();

    }
}
