
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author subha
 */
public class Util {
    public static String capitalizeFirstLetter(String original) {
        if (original == null || original.length() == 0) {
            return original;
        }
        return original.substring(0, 1).toUpperCase() + original.substring(1);
    }
    
    public static void customizeFrame(Frame frame){
        Image icon = Toolkit.getDefaultToolkit().getImage(frame.getClass().getResource("./icons/256x256.png"));
        //ImageIcon icon = new ImageIcon("./icons/256x256.png");
        frame.setIconImage(icon);
        frame.setLocationRelativeTo(null);
    }
}
