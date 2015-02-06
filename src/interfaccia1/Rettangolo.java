package interfaccia1;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author VittorioBarile
 */
public class Rettangolo {
    
    private int x;
    private int y;
    private Image rectangle;
    private double speed;
    
    private double actualSpeed;
    
    
    public Rettangolo(double pSpeed) {
        this.rectangle = new ImageIcon(getClass().getResource("/interfaccia1/rectangle.png")).getImage();
        this.x = 15;
        this.y = 600 - this.rectangle.getHeight(null);
        this.speed = pSpeed;
        this.actualSpeed = 0;
    }
    
    public void update() {
        this.y += this.actualSpeed;
        
    }
    
    public void draw(Graphics g) {
        g.drawImage(this.rectangle, (int)this.x, (int)this.y, null);
    }
    
    public void moveUp(){
        this.actualSpeed =  this.speed * -1;
    }
    
    public void moveDown(){
        this.actualSpeed =  this.speed;
    }
    
    public void stop(){
        this.actualSpeed = 0;
    }
    
}
