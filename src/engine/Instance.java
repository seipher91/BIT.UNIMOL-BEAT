package engine;

import java.util.ArrayList;
import part.Quadrato;
import part.Rettangolo;

/**
 * Qui vengono messe le definizioni degli elementi peculiari di gioco a cui tutti posso afferire (peculiare per il game logic)
 * @author roberto
 */
public class Instance {
    
    public static Rettangolo rectangle;
    
    public static Rettangolo rectangle_opposite;
    
    public static ArrayList<Quadrato> quadrato;
    
    public static boolean gameLogicEnabled = false;
    
}
