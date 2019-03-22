import javax.swing.*;
import java.awt.*;

public class Inventory{

<<<<<<< HEAD
    private String key = "Key: ";



    public String invKey(){
       return key + Key.getAmountKey();

=======
    public static String invKey(){
        String key = "Key: ";

        return key + Key.getAmountKey();

>>>>>>> c427d542e075c254058aad9e6b8f634827b0faf9
    }
}
