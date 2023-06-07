package Sprint3_0;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testTableroVacio {
    private Tablero tablero= new Tablero(3,3);
    /*
    AC 3.1 3.2
     */
    @Test
    public void testTableroVacio(){
        for(int filas = 0; filas<tablero.getNumFilas(); filas++)
            for (int columnas = 0; columnas<tablero.getNumColumnas(); columnas++)
                assertEquals("EL TABLERO ESTA VACIO", tablero.getContenidoCeldas(filas,columnas), Tablero.ContenidoCeldas.VACIO);
    }

}
