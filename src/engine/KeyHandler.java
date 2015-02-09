package engine;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Gestisce l'ancoraggio tra i bottoni e i movimenti del Rettangolo defiito in Istance
 * @author roberto
 */
public class KeyHandler extends KeyAdapter {

    @Override
    public void keyReleased(KeyEvent e) {
        if ((e.getKeyCode() == KeyEvent.VK_UP) || (e.getKeyCode() == KeyEvent.VK_DOWN)) {
            Instance.rectangle.stop();
        }
        if ((e.getKeyCode() == KeyEvent.VK_W) || (e.getKeyCode() == KeyEvent.VK_S)) {
            Instance.rectangle_opposite.stop();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
                Instance.rectangle.moveUp();
                break;
            case KeyEvent.VK_DOWN:
                Instance.rectangle.moveDown();
                break;
        }
        
        if(Instance.gameLogicEnabled) {
            switch(e.getKeyCode()){
                case KeyEvent.VK_W:
                    Instance.rectangle_opposite.moveUp();
                    break;
                case KeyEvent.VK_S:
                    Instance.rectangle_opposite.moveDown();
                    break;
            }
        }
    }
}
    
