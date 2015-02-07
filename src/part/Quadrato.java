package part;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Vittorio
 */
public class Quadrato {
    
    protected double x, y;
    protected Image square;
    protected double speed;
    
    public Quadrato(double pSpeed) {
        this.square = new ImageIcon(getClass().getResource("/immagini/square.png")).getImage();
        this.y = Math.random() * (600 - this.square.getHeight(null));
        this.x = 800 - this.square.getWidth(null);
        this.speed = pSpeed;
    }
    
    public void update() {
        this.x -= this.speed;
        if(this.x <= 0 - this.square.getWidth(null)){
            this.x = 800;
            this.y = (Math.random() * (600 - square.getHeight(null)));
        }
    }
    
    public void draw(Graphics g) {
        g.drawImage(this.square, (int)this.x, (int)this.y, null);
    }
}
