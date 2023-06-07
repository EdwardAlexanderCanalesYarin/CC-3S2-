package Sprint4_0;

import java.util.Random;

public class AutoGame extends Tablero {
    private char autoPlayer;

    public AutoGame() {
        this('R');
    }

    public AutoGame(char player) {
        this.autoPlayer = player;
        if (autoPlayer == 'A') {
            hacerPrimerMovimiento();
        }
    }

    private void hacerPrimerMovimiento() {
        Random rand = new Random();
        int position = rand.nextInt(9);
        super.RealizarMovimiento(position/3,position%3);
    }

    @Override
    public void RealizarMovimiento(int filas, int columnas)
    {
        if(super.CeldaValida(filas,columnas))
        {
            super.RealizarMovimiento(filas,columnas);
            if(turno == autoPlayer && EstadoActual==EstadoDeJuego.PLAYING)
            {
                autoMoverse();
            }
        }
    }

    private void autoMoverse()
    {
        if(!movimientoGanador())
        {
            if(!oponenteNoGana())
            {
                movimientoRandom();
            }
        }
    }
    private boolean movimientoGanador(){return false;}
    private boolean oponenteNoGana(){return false;}

    private void movimientoRandom()
    {
        int numeroDeCeldasVacias = getNumeroDeCeldasVacias();
        Random random = new Random();
        int casilla= random.nextInt(numeroDeCeldasVacias);
        int i=0;
        for (int filas = 0; filas < NumFilas; filas++) {
            for (int columnas = 0; columnas < NumColumnas; columnas++) {
                if(celdas[filas][columnas]==ContenidoCeldas.VACIO)
                {
                    if(casilla==i){
                        super.RealizarMovimiento(filas,columnas);
                        return;
                    }else i++;
                }
            }
        }
    }

    private int getNumeroDeCeldasVacias() {
        int numeroDeCeldasVacias = 0;
        for (int filas = 0; filas < NumFilas; filas++) {
            for (int columnas = 0; columnas < NumColumnas; columnas++) {
                if (celdas[filas][columnas] == ContenidoCeldas.VACIO) {
                    numeroDeCeldasVacias++;
                }
            }
        }
        return numeroDeCeldasVacias;
    }

    public static void main(String[] args) {
        AutoGame auto = new AutoGame('A');
        Tableroconsola tab = new Tableroconsola(auto);
        tab.MostrarConsola();
    }
}
