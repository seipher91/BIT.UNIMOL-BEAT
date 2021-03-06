package part;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Vittorio
 */
public class Quadrato {
    
    double x, y;
    Image square;
    protected Rectangle Body;
    double width, heigth;
    double speed;
    protected Boolean path;
    
    int timer;
    
    public Quadrato(double pSpeed) {
        this.square = new ImageIcon(getClass().getResource("/immagini/square.png")).getImage();
        this.y = Math.random() * (600 - this.square.getHeight(null));
        this.x = 800;//- this.square.getWidth(null);
        this.width = this.square.getWidth(null);
        this.heigth = this.square.getHeight(null);
        this.speed = pSpeed;
        this.path = false;
        this.Body = new Rectangle((int)this.x, (int)this.y, (int)this.width, (int)this.heigth );
    
        this.timer = (int)(Math.random() * 250);
    }
    
    public void update() {
        if(this.ready_to_spawn()) {
            if(!path) //fa andare in un senso on in un altro il quadrato
                this.x -= this.speed;
            else 
                this.x += this.speed;

            if(this.x <= 0 - this.square.getWidth(null) || this.x >= 800){
                this.x = 800;
                this.y = (Math.random() * (600 - square.getHeight(null)));
                this.path = false;
                this.timer = (int)(Math.random() * 250);
            }
            this.Body = new Rectangle((int)this.x, (int)this.y, (int)this.width, (int)this.heigth );
        }
    }
    
    public boolean ready_to_spawn() {
        if(this.timer == 0)
            return true;
        else
            this.timer--;
        return false;
    }
    
    public Rectangle getBody() {
        return this.Body;
    }
    
    public void setReversePath(Boolean bool){
        this.path = bool;
    }
    
    public void draw(Graphics g) {
        g.drawImage(this.square, (int)this.x, (int)this.y, null);
    }
}
