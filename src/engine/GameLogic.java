package engine;


import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import part.Quadrato;
import part.Rettangolo;
/**
 * Classe per la logica di gioco:
 * -Gestisce le collisioni degli elementi quadrato con rettangolo
 * -Gestisce il punteggio
 * -Gestisce la comparsa e la routine del boss
 * @author VittorioBarile
 */


public class GameLogic implements Runnable {
    
    private Thread thread;
    
    public GameLogic() {
        Istance.rectangle = new Rettangolo(2.00);
        Istance.square = new Quadrato(3.00);
    }
    
    public void isIntersecato() {
        if(Istance.rectangle.getBody().intersects(Istance.square.getBody())){
            System.out.println("Intersect!");
            Istance.square.setReversePath(true);
        }
    }

    /**
     * Cediamo a game logic la libertà di egstire l'aggiornamento degli elementi di gioco
     */
    public void update() {
        Istance.rectangle.update();
        Istance.square.update();
    }
    
    /**
     * Cediamo a game logic la libertà di disegnare gli oggetti su schermo
     * @param g 
     */
    public void Draw(Graphics g) {
        Istance.rectangle.draw(g);
        Istance.square.draw(g);
    }
    
    @Override
    public void run() {
        while (true) {
            isIntersecato();
        }
    }

    /**
     * Avvia il thread
     */
    public void start() {
        stop();
        thread = new Thread(this,"GameLogic Thread");
        thread.start();
    }

    /**
     * Ferma il thread
     */
    public void stop() {
        if (thread != null && thread.isAlive()) {
            thread.interrupt();
        }
    }
    
}
