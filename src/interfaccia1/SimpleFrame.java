package interfaccia1;

import java.awt.*;
import javax.swing.JFrame;

/**
 *
 * @author VittorioBarile
 */
public class SimpleFrame extends JFrame {
    
    
    public SimpleFrame() {
        
        setTitle("BIT.TRIP BEAT UNIMOL");
        setSize(800 , 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
        setVisible(true);
        
        
        SimplePanel panel = new SimplePanel();
        Container contentPane = getContentPane();
       
        contentPane.add(panel);
        panel.requestFocus();
       
    }
    
    
}
