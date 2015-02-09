package interfaccia1;

import part.Wallpaper;
import part.QuadratoSpeciale;
import part.Quadrato2;
import part.Rettangolo;
import part.Quadrato;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author VittorioBarile
 */
public class GestionePanel extends JPanel {

    private Timer gameTimer;
    private Quadrato square;
    private Quadrato square2;
    private QuadratoSpeciale squareSpecial;
    private Quadrato2 squareNew;
    private Rettangolo rectangle;
    private Wallpaper sfondo;
    private KeyHandler gestorePulsanti;

    private LinkedList<QuadratoSpeciale> QSList;
    private int contatore;

    public GestionePanel() {

        this.sfondo = new Wallpaper();
        this.square = new Quadrato(3.00);
        this.square2 = new Quadrato(1.50);
        this.squareNew = new Quadrato2(6);
        this.rectangle = new Rettangolo(2.00);
        //this.squareSpecial = new QuadratoSpeciale(5.00);
        //lista
        this.QSList = new LinkedList<QuadratoSpeciale>();
        this.contatore = 0;

        this.gameTimer = new Timer(10, new GameListner());
        this.gestorePulsanti = new KeyHandler();
        this.addKeyListener(this.gestorePulsanti);
        this.gameTimer.start();

    }

    public void update() {

        this.square.update();
        this.square2.update();
        this.squareNew.update();
        //this.squareSpecial.update();
        this.rectangle.update();

        this.contatore++;
        if (this.contatore >= 25) {
            QSList.add(new QuadratoSpeciale(3.00,430));
            this.contatore = 0;
            //this.usciti++;
        }

        Iterator<QuadratoSpeciale> iterator = QSList.iterator();
        while (iterator.hasNext()) {
            QuadratoSpeciale q = iterator.next();
            q.update();
            if(q.isDistruttibile()== true){
                iterator.remove();
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        this.sfondo.draw(g);
        this.square.draw(g);
        this.square2.draw(g);
        this.squareNew.draw(g);
        //this.squareSpecial.draw(g);
        this.rectangle.draw(g);
        
        Iterator<QuadratoSpeciale> iterator = QSList.iterator();
        while (iterator.hasNext()) {
            QuadratoSpeciale q = iterator.next();
            q.draw(g);
        }

        g.dispose();
    }

    public class GameListner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            update();
            repaint();
        }
    }

    public class KeyHandler extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            if ((e.getKeyCode() == KeyEvent.VK_UP) || (e.getKeyCode() == KeyEvent.VK_DOWN)) {
                rectangle.stop();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                rectangle.moveUp();
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                rectangle.moveDown();
            }
        }
    }
    
}
