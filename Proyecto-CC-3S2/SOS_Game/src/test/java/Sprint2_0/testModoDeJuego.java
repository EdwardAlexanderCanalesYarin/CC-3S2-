package Sprint2_0;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testModoDeJuego {
    private Tablero tablero =
            new Tablero();
    @Test
    public void testModoDeJuegoSimple()
    {

        assertEquals("",tablero.SeleccionDeModoDeJuegoSimple(), Tablero.ModoDeJuego.SIMPLE);
    }
    @Test
    public void testModoDeJuegoGeneral()
    {

        assertEquals("",tablero.SeleccionDeModoDeJuegoGeneral(), Tablero.ModoDeJuego.GENERAL);
    }
}
