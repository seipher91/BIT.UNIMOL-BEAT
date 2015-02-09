package part;

import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author VittorioBarile
 */
public class Quadrato2 extends Quadrato {
    
    private double ySpeed;

    public Quadrato2(double pSpeed) {
        super(pSpeed);
        this.square = new ImageIcon(getClass().getResource("/immagini/quadrato3.png")).getImage();
        this.ySpeed = 2.00;
        this.Body = new Rectangle((int)this.x, (int)this.y, (int)this.width, (int)this.heigth);
    }
    
    @Override
    public void update() {
        
        if(this.ready_to_spawn()){
           
            if(!path) //fa andare in un senso on in un altro il quadrato
                this.x -= this.speed;
            else 
                this.x += this.speed;
           
            if(this.y <= 0 || this.y >= 600 - this.square.getHeight(null))
                this.ySpeed *= -1;
            this.y += this.ySpeed;
            
            if(this.x <= 0 - this.square.getWidth(null) || this.x >= 800){
                this.x = 800;
                this.y = (Math.random() * (600 - square.getHeight(null)));
                this.path = false;
                this.timer = (int)(Math.random() * 250);
            }

//            if(this.x <= 0 || this.x >= 800)
//                this.speed *= -1;
//            this.x -= this.speed;

            this.Body = new Rectangle((int)this.x, (int)this.y, (int)this.width, (int)this.heigth);

        }
    }
    
    
}
