package engine;

import java.util.ArrayList;
import part.Quadrato;
import part.Quadrato2;
import part.Rettangolo;

/**
 * Qui vengono messe le definizioni degli elementi peculiari di gioco a cui tutti posso afferire (peculiare per il game logic)
 * @author roberto
 */
public class Instance {
    
    public static Rettangolo rectangle;
    
    public static Rettangolo rectangle_opposite;
    
    public static ArrayList<Quadrato> quadrato;
    
    public static ArrayList<Quadrato2> quadrato2;
    
    public static int Punteggio = 0;
    
    public static boolean gameLogicEnabled = false;
    
}
