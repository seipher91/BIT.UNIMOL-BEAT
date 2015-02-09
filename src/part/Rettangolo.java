package part;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author VittorioBarile
 */
public class Rettangolo {
    
    private int x;
    private int y;
    private Image rectangle;
    private Rectangle Body; //figura geometrica per la gestione delle collisioni
    double width, heigth;
    private double speed;
    
    private double actualSpeed;
    
    
    public Rettangolo(double pSpeed) {
        this.rectangle = new ImageIcon(getClass().getResource("/immagini/rectangle.png")).getImage();
        this.x = 15;
        this.y = 600 - this.rectangle.getHeight(null);
        this.speed = pSpeed;
        this.actualSpeed = 0;
        this.width = this.rectangle.getWidth(null);
        this.heigth = this.rectangle.getHeight(null);
        this.Body = new Rectangle((int)this.x, (int)this.y, (int)this.width, (int)this.heigth );
    }
    
    public void update() {
        this.y += this.actualSpeed;
        this.Body = new Rectangle((int)this.x, (int)this.y, (int)this.width, (int)this.heigth );
    }
    
    public void draw(Graphics g) {
        g.drawImage(this.rectangle, (int)this.x, (int)this.y, null);
    }
    
    public void moveUp(){
        if(this.y>0)
            this.actualSpeed = this.speed * -1;
    }
    
    public void moveDown(){
        if(this.y+this.heigth<600)
            this.actualSpeed = this.speed;
    }
    
    public void stop(){
        this.actualSpeed = 0;
    }
    
    public Rectangle getBody() {
        return this.Body;
    }

}
