package Sprint3_0;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class testAsignacionTurno {
    Tablero tablero;

    @Before
    public void initTablero()
    {
        tablero = new Tablero(4,4);
    }

    /*
    Criterio de aceptacion 5.1
     */
    @Test
    public void testAsignacionDeTurnoEnJuegoSimple()
    {
        tablero.setModo(Tablero.ModoDeJuego.SIMPLE);
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(1,2);
        //Como se realizo un movimiento entonces el turno cambia a rojo 'R'
        assertEquals("",tablero.getTurno(),'R');
    }
    /**
     * creiterio de aceptacion 12.1
     */
    @Test
    public void testAsignacionDeTurnoEnJuegoGeneral()
    {
        tablero.setModo(Tablero.ModoDeJuego.GENERAL);
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(1,2);
        assertEquals("", tablero.getTurno(), 'R');

    }

    /**
     * criterio de aceptacion 12.2
     */
    @Test
    public void testRepeticionDeTurnoEnJuegoGeneral()
    {
        tablero.setModo(Tablero.ModoDeJuego.GENERAL);
        //turno A
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(0,0);
        //turno R
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(2,3);
        //turno A
        tablero.setSeleccion('O');
        tablero.RealizarMovimiento(1,1);
        //turno R
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(3,2);
        //turno A
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(2,2);
        assertEquals("",tablero.getTurno(),'A');

        //se repite el turno de AZUL 'A'
        tablero.setSeleccion('O');
        tablero.RealizarMovimiento(1,0);
        assertEquals("", tablero.getContenidoCeldas(1,0), Tablero.ContenidoCeldas.AZUL_O);

        //Y como no se formo nigun SOS no se repite el turno del AZUL y pasa al turno de ROJO
        assertEquals("", tablero.getTurno(),'R');
    }
}
