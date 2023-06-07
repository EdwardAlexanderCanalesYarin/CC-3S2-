package Sprint2_0;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testTableroVacio {
    //instanciamos un objeto Tablero con parametros de entrada permitidos.
    private Tablero tablero = new Tablero();


    /*
    AC 3.1 3.2
    Como se menciona en los criterios de aceptacion, se debe crear un tablero logico vacio con el correspondiente modo de juego
    seleccionado.
    este test verifica si es que la matriz (el tablero logico) contiene los enum VACIO.
     */
    @Test
    public void testTableroLogicoVacio() {
        for(int filas=0; filas<tablero.getNumFilas();filas++)
        {
            for (int columnas=0; columnas<tablero.getNumColumnas();columnas++)
            {
                assertEquals("", tablero.getContenidoDeLasCeldasDelTablero(filas,columnas), Tablero.ContenidoDeLasCeldasDelTablero.VACIO);
            }
        }
    }
}
