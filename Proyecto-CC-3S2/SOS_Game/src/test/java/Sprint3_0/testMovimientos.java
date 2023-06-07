package Sprint3_0;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testMovimientos {
    /*
    * testMovimientos validos va a evaluar
    * las particiones de los movimientos permitidos y no permitidos en el tablero
    * caso 1: fila no permitida (fila > numFilas y fila < numFilas)
    * caso 2: columnas no permitida (columna > numColumnas y columnas < numColumnas)
    * caso 3: fila permitida
    * caso 4: columna permitada
    * caso 5: Se selecciona una celda vacia para la colocacion de una pieza
    * caso 6: Se selecciona una celda llena para la colocacion de una pieza
     */
    Tablero tablero;

    @Before
    public void initTablero()
    {
        tablero = new Tablero(4,4);
    }
    /*
    caso 1
     */
    @Test
    public void testMovimientoSimpleInValidoFila()
    {
        initTablero();
        tablero.setModo(Tablero.ModoDeJuego.SIMPLE);
        assertEquals("", tablero.CeldaValida(-1,3),false);
        assertEquals("", tablero.CeldaValida(7,3),false);

    }
    /*
    caso 2
     */
    @Test
    public void testMovimientoSimpleInValidoColumna()
    {
        initTablero();
        tablero.setModo(Tablero.ModoDeJuego.SIMPLE);
        assertEquals("", tablero.CeldaValida(3,-1),false);
        assertEquals("", tablero.CeldaValida(3, 9),false);
    }
    /*
    caso 3 y caso 4
     */
    @Test
    public void testMovimientoSimpleValidoFilaColumna()
    {
        initTablero();
        tablero.setModo(Tablero.ModoDeJuego.SIMPLE);
        assertEquals("", tablero.CeldaValida(0,0),true);
        assertEquals("", tablero.CeldaValida(2,3),true);

    }
    /*
    * caso 5 y 6
    * CRITERIO DE ACETACION 4.1 Y 4.2
     */
    @Test
    public void testMovimientoSimpleTableroLlenoVacio()
    {
        initTablero();
        tablero.setModo(Tablero.ModoDeJuego.SIMPLE);
        tablero.setSeleccion('O');
        tablero.RealizarMovimiento(2,3);
        // la celda 2,3 esta llena
        assertEquals("", tablero.CeldaValida(2,3), false);

        //la celda 1,1 esta vacio
        assertEquals("", tablero.CeldaValida(1,1), true);
    }

    /**
     * si seleciona una S o una O entonces se inserta en la celda del tablero
     * criterio de aceptacion 11.1
     */
    @Test
    public void testMovimientoGeneralValido()
    {
        initTablero();
        tablero.setModo(Tablero.ModoDeJuego.GENERAL);
        tablero.setSeleccion('O');
        tablero.RealizarMovimiento(2,3);
        assertEquals("", tablero.getContenidoCeldas(2,3), Tablero.ContenidoCeldas.AZUL_O);
    }
    /**
     * criterio de aceptacion 11.2
     */
    @Test
    public void testMovimientoGeneralInValido()
    {
        initTablero();
        tablero.setModo(Tablero.ModoDeJuego.GENERAL);
        tablero.setSeleccion('S');
        tablero.RealizarMovimiento(2,3);
        assertEquals("", tablero.getContenidoCeldas(2,3), Tablero.ContenidoCeldas.AZUL_S);
        assertEquals("movimiento invalido", tablero.CeldaValida(2,3), false);

    }
}
