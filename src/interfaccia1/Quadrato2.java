package interfaccia1;

import javax.swing.ImageIcon;

/**
 *
 * @author VittorioBarile
 */
public class Quadrato2 extends Quadrato {
    
    private double ySpeed;

    public Quadrato2(double pSpeed) {
        super(pSpeed);
        this.square = new ImageIcon(getClass().getResource("/interfaccia1/quadrato3.png")).getImage();
        this.ySpeed = 6.00;
    }
    
    @Override
    public void update() {
        
        if(this.y <= 0 || this.y >= 600 - this.square.getHeight(null))
            this.ySpeed *= -1;
        this.y += this.ySpeed;
        
        if(this.x <= 0 || this.x >= 800)
            this.speed *= -1;
        this.x -= this.speed;
        
    }
    
    
}
