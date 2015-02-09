package interfaccia1;

import java.awt.*;
import javax.swing.JFrame;

/**
 *
 * @author VittorioBarile
 */
public class GestioneFrame extends JFrame {
    
    
    public GestioneFrame() {
        
        setTitle("BIT.UNIMOL BEAT");
        setSize(800 , 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
        setVisible(true);
        
        
        GestionePanel panel = new GestionePanel();
        Container contentPane = getContentPane();
       
        contentPane.add(panel);
        panel.requestFocus();
       
    }
    
    
}
