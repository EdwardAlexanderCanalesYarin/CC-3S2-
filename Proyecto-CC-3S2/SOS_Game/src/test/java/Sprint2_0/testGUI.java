package Sprint2_0;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testGUI {
    Tablero tablero;
    @Before
    public void setUp() throws Exception {
        tablero = new Tablero();
    }
    /*Implementamos un test que nos permite poder visualizar
    * el tablero sin ninguna lógica implementada
    * Tomado como referencia el juego de Tic Tac TOe*/
    @Test
    public void testTableroVacio()
    {
        new GUI(tablero);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
