package interfaccia1;

import javax.swing.ImageIcon;

/**
 *
 * @author VittorioBarile
 */
public class QuadratoSpeciale extends Quadrato {

    private double ySpeed;
    private int maxY,minY;
    private boolean distruttibile;
    
    public QuadratoSpeciale(double pSpeed, double pY) {
        
        super(pSpeed);
        //this.y = 70 + (Math.random() * 430);
        this.y = pY;
        this.square = new ImageIcon(getClass().getResource("/interfaccia1/square2.png")).getImage();
        
        this.ySpeed = 4.00;
        
        this.maxY = (int)(this.y + 70);
        this.minY = (int)(this.y - 70);
        
        this.distruttibile = false;
        
    }
    
    @Override
    public void update() {
        
        this.x -= this.speed;
        
        
        if(this.y <= this.minY || this.y >= this.maxY - this.square.getHeight(null))
            this.ySpeed *= -1;
        this.y += this.ySpeed;
        
        
        if(this.x <= 0 - this.square.getWidth(null)) {
            this.distruttibile = true;
        }
        
//        if(this.y <=)
//            this.ySpeed *= -1;
//        this.y -= this.ySpeed;
        
        /*
        if(this.x <= 0 - this.square.getWidth(null)) {
            this.x = 800;
            this.y = 70 + (Math.random() * 430);
            this.maxY = (int)(this.y + 70);
            this.minY = (int)(this.y - 70);
        }
                */
    }   

    public boolean isDistruttibile() {
        return distruttibile;
    }
    
    
}