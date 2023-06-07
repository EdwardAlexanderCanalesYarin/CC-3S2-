package Sprint2_0;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class testMovimiento{
    private Tablero tablero =
            new Tablero();

    // Criterio de aceptación 4.1 y 11.1

    @Test
    public void testMovimientoValidoModoSimpleGeneral() {

        assertEquals("", tablero.getContenidoDeLasCeldasDelTablero(0, 0), Tablero.ContenidoDeLasCeldasDelTablero.VACIO);
        assertEquals("", tablero.getTurno(),'A');
    }
    //Criterio de aceptacion 4.2 y 11.2
    @Test
    public void testMovimientoInvalidoModoSimpleGeneral(){
        tablero.setSeleccionAzul('O');
        tablero.hacerMovimiento(0,0);
        assertEquals("", tablero.getContenidoDeLasCeldasDelTablero(0, 0), Tablero.ContenidoDeLasCeldasDelTablero.SIMBOLO_AZUL_O);
        assertEquals("", tablero.getTurno(),'R');
    }

    // Criterio de aceptación 5.1
    @Test
    public void testSiguienteTurnoModoSimpleGeneral(){
        tablero.setSeleccionAzul('O');
        tablero.hacerMovimiento(1,0);
        assertEquals("", tablero.getTurno(),'R');
    }

}
