package Sprint3_0;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testVictoria {
    Tablero tablero;

    @Before
    public void initTablero()
    {
        tablero = new Tablero(3,3);
    }

    /**
     * CRITERIO DE ACEPTACION 6.1
     */
    @Test
    public void testVictoriaJuegoSimpleRojo(){
        tablero.setModo(Tablero.ModoDeJuego.SIMPLE);
        //turno A
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(0,2);
        //turno R
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(0,0);
        //turno A
        tablero.setSeleccion('O');
        tablero.RealizarMovimiento(0,1);
        //turno R
        tablero.setSeleccion('O');
        tablero.RealizarMovimiento(1,0);
        //turno A
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(2,2);
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(2,0);

        assertEquals(tablero.getEstadoActual(), Tablero.EstadoDeJuego.ROJO_GANA);
    }
    @Test
    public void testVictoriaJuegoSimpleAzul(){
        tablero.setModo(Tablero.ModoDeJuego.SIMPLE);
        //turno A
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(0,2);
        //turno R
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(0,0);
        //turno A
        tablero.setSeleccion('O');
        tablero.RealizarMovimiento(0,1);
        //turno R
        tablero.setSeleccion('O');
        tablero.RealizarMovimiento(1,0);
        //turno A
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(2,2);
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(2,0);

        assertEquals(tablero.getEstadoActual(), Tablero.EstadoDeJuego.ROJO_GANA);
    }

    /**
     * CRITERIO DE ACEPTACION 6.2
     */
    @Test
    public void testEmpateJuegoSimple()
    {
        tablero.setModo(Tablero.ModoDeJuego.SIMPLE);
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(0,0);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(0,1);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(0,2);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(1,0);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(1,1);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(1,2);

        tablero.RealizarMovimiento(2,0);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(2,1);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(2,2);

        //SI EL ESTADO SIGUE EN DRAW ENTONCES ES UN EMPATE EN UN JUEGO SIMPLE
        assertEquals("", tablero.getEstadoActual(), Tablero.EstadoDeJuego.DRAW);

    }

    @Test
    public void testEmpateJuegoGeneral()
    {
        tablero.setModo(Tablero.ModoDeJuego.GENERAL);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(0,0);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(0,1);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(0,2);

        tablero.setSeleccion('O');
        tablero.RealizarMovimiento(1,1);

        tablero.setSeleccion('O');
        tablero.RealizarMovimiento(1,0);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(2,1);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(2,0);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(1,2);

        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(2,2);

        assertEquals("",tablero.getTurno(),'R');
        assertEquals("",tablero.getEstadoActual(), Tablero.EstadoDeJuego.EMPATE);
    }
    @Test
    public void testVictoriaJuegoGeneral()
    {
        //A
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(0,0);

        //R
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(0,1);

        //A
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(0,2);

        //R
        tablero.setSeleccion('O');
        tablero.RealizarMovimiento(1,1);

        //A
        tablero.setSeleccion('O');
        tablero.RealizarMovimiento(1,0);

        //R
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(2,1);

        //A
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(2,0);

        //R
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(1,2);

        //A
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(2,2);
    }

    public static void main(String[] args) {
        Tablero tablero = new Tablero(4,4);
        tablero.setModo(Tablero.ModoDeJuego.SIMPLE);
        //turno A
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(0,2);
        //turno R
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(0,0);
        //turno A
        tablero.setSeleccion('O');
        tablero.RealizarMovimiento(1,1);
        //turno R
        tablero.setSeleccion('O');
        tablero.RealizarMovimiento(1,0);
        //turno A
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(2,0);

        Tableroconsola tableroconsola = new Tableroconsola(tablero);
        tableroconsola.MostrarConsola();
    }
}
