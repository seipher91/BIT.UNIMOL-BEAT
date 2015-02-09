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
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            Instance.rectangle.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            Instance.rectangle.moveDown();
        }
    }
}
    
