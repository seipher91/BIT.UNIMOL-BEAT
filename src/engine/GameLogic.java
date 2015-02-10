package engine;


import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import part.Quadrato;
import part.Quadrato2;
import part.QuadratoSpeciale;
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
        Instance.rectangle = new Rettangolo(8.00);
        
        if(Instance.gameLogicEnabled)
            Instance.rectangle_opposite = new Rettangolo(2.00);
        
        Instance.quadrato = new ArrayList<>();
        for(int i=0; i<10; i++){
            Instance.quadrato.add(new Quadrato(3.00));
        }
        
        Instance.quadrato2 = new ArrayList<>();
        for(int i=0; i<6; i++){
            Instance.quadrato2.add(new Quadrato2(3.00));
        }
        
        Instance.quadratoSpeciale = new ArrayList<>();
        for(int i=0; i<5; i++){
            Instance.quadratoSpeciale.add(new QuadratoSpeciale(3.00, 3.00));
        }
        
    }
    
    public void isIntersecato() {
        for(Quadrato q : Instance.quadrato){
            if(Instance.rectangle.getBody().intersects(q.getBody())
                || Instance.rectangle.getBody().contains(q.getBody())){
                q.setReversePath(true);
                Instance.Punteggio += 30;
            }
        }
        if(Instance.gameLogicEnabled) {
        for(Quadrato q : Instance.quadrato){
            if(Instance.rectangle_opposite.getBody().intersects(q.getBody())
                || Instance.rectangle_opposite.getBody().contains(q.getBody())){
                q.setReversePath(true);
                }
            }
        }
        
        for(Quadrato2 q : Instance.quadrato2){
            if(Instance.rectangle.getBody().intersects(q.getBody())
                || Instance.rectangle.getBody().contains(q.getBody())){
                q.setReversePath(true);
                Instance.Punteggio += 50;
            }
        }
        
        for(QuadratoSpeciale q : Instance.quadratoSpeciale){
            if(Instance.rectangle.getBody().intersects(q.getBody())
                || Instance.rectangle.getBody().contains(q.getBody())){
                q.setReversePath(true);
                Instance.Punteggio += 20;
            }
        }
    }

    /**
     * Cediamo a game logic la libertà di egstire l'aggiornamento degli elementi di gioco
     */
    public void update() {
        Instance.rectangle.update();
        
        if(Instance.gameLogicEnabled)
            Instance.rectangle_opposite.update();
        
        for(Quadrato q : Instance.quadrato)
            q.update();
        
        for(Quadrato2 q : Instance.quadrato2)
            q.update();
        
        for(QuadratoSpeciale q : Instance.quadratoSpeciale)
            q.update();
    }
    
    /**
     * Cediamo a game logic la libertà di disegnare gli oggetti su schermo
     * @param g 
     */
    public void Draw(Graphics g) {
        Instance.rectangle.draw(g);
        
        if(Instance.gameLogicEnabled)
            Instance.rectangle_opposite.draw(g);
        
        for(Quadrato q : Instance.quadrato)
            q.draw(g);
        
        for(Quadrato2 q : Instance.quadrato2)
            q.draw(g);
        
        for(QuadratoSpeciale q : Instance.quadratoSpeciale)
            q.draw(g);
    }
    
    @Override
    public void run() {
        while (true) {
            try { 
                Thread.sleep(100);
            } catch (InterruptedException ex) { }
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
