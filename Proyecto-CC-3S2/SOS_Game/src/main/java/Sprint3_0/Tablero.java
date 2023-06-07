package Sprint3_0;

public class Tablero {
    public enum ContenidoCeldas {VACIO, AZUL_O,AZUL_S,ROJO_O,ROJO_S};
    public enum EstadoDeJuego {PLAYING, DRAW, AZUL_GANA, ROJO_GANA, EMPATE}
    public enum ModoDeJuego {SIMPLE,GENERAL};
    private ContenidoCeldas celdas[][];
    private EstadoDeJuego EstadoActual;
    private ModoDeJuego modo;
    private int NumFilas;
    private int NumColumnas;
    private char turno;
    private char seleccion;
    private int puntosAzul=0;
    private int puntosRojo=0;


    public Tablero(int NumFilas, int NumColumnas)
    {
        this.NumFilas=NumFilas;
        this.NumColumnas=NumColumnas;

        celdas = new ContenidoCeldas[NumFilas][NumColumnas];
        initTablero();
    }
    /*
    *El metodo initTablero instancia las condiciones predefinidas del tablero
    * primero crea un tablero logico vacio
    * coloca el estado actual de juego en turno
    * y predefine el turno del jugador, por defencto empieza el jugador Azul
     */

    private void initTablero() {
        for(int filas = 0; filas< NumFilas; filas++)
            for(int columnas = 0; columnas< NumColumnas; columnas++)
                celdas[filas][columnas]= ContenidoCeldas.VACIO;

        EstadoActual= EstadoDeJuego.PLAYING;
        turno='A';

    }

    public void RealizarMovimiento(int filas, int columnas)
    {
        if(CeldaValida(filas,columnas))
        {
            if(turno=='A')
            {
                celdas[filas][columnas] = (seleccion=='S')? ContenidoCeldas.AZUL_S:ContenidoCeldas.AZUL_O;
            }else {
                celdas[filas][columnas]= (seleccion=='S')? ContenidoCeldas.ROJO_S: ContenidoCeldas.ROJO_O;
            }

            ActualizarEstadoDeJuego(filas, columnas);
            turno = (turno=='A')? 'R':'A';

        }
    }
    public void ActualizarEstadoDeJuego(int filas, int columnas)
    {
        if(Gana(filas, columnas))
        {
            if(modo==ModoDeJuego.SIMPLE) EstadoActual = (turno=='A')? EstadoDeJuego.AZUL_GANA:EstadoDeJuego.ROJO_GANA;
            else{
                if(puntosAzul>puntosRojo)
                {
                    EstadoActual=EstadoDeJuego.AZUL_GANA;
                }else
                {
                    if(puntosAzul==puntosRojo)
                        EstadoActual = EstadoDeJuego.EMPATE;
                    else EstadoActual = EstadoDeJuego.ROJO_GANA;
                }
            }
        }else if(isDraw())
        {
            EstadoActual = EstadoDeJuego.DRAW;
        }
    }

    public boolean Gana(int filas, int columnas)
    {
        if(modo==ModoDeJuego.SIMPLE)
        {
            if(turno=='A')
            {
                if(seleccion=='S')
                {
                    if( filas-1>= 0 && filas-1< NumFilas && columnas+1>= 0 && columnas+1< NumColumnas && filas-2>= 0 && filas-2< NumFilas && columnas+2>= 0 && columnas+2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.AZUL_S && celdas[filas-1][columnas+1]==ContenidoCeldas.AZUL_O && celdas[filas-2][columnas+2]==ContenidoCeldas.AZUL_S) return true;

                    if( filas>= 0 && filas< NumFilas && columnas+1>= 0 && columnas+1< NumColumnas && filas>= 0 && filas< NumFilas && columnas+2>= 0 && columnas+2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.AZUL_S && celdas[filas][columnas+1]==ContenidoCeldas.AZUL_O && celdas[filas][columnas+2]==ContenidoCeldas.AZUL_S) return true;

                    if( filas+1>= 0 && filas+1< NumFilas && columnas+1>= 0 && columnas+1< NumColumnas && filas+2>= 0 && filas+2< NumFilas && columnas+2>= 0 && columnas+2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.AZUL_S && celdas[filas+1][columnas+1]==ContenidoCeldas.AZUL_O && celdas[filas+2][columnas+2]==ContenidoCeldas.AZUL_S) return true;

                    if( filas+1>= 0 && filas+1< NumFilas && columnas>= 0 && columnas< NumColumnas && filas+2>= 0 && filas+2< NumFilas && columnas>= 0 && columnas< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.AZUL_S && celdas[filas+1][columnas]==ContenidoCeldas.AZUL_O && celdas[filas+2][columnas]==ContenidoCeldas.AZUL_S) return true;

                    if( filas+1>= 0 && filas+1< NumFilas && columnas-1>= 0 && columnas-1< NumColumnas && filas+2>= 0 && filas+2< NumFilas && columnas-2>= 0 && columnas-2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.AZUL_S && celdas[filas+1][columnas-1]==ContenidoCeldas.AZUL_O && celdas[filas+2][columnas-2]==ContenidoCeldas.AZUL_S) return true;

                    if( filas-1>= 0 && filas-1< NumFilas && columnas-1>= 0 && columnas-1< NumColumnas && filas-2>= 0 && filas-2< NumFilas && columnas-2>= 0 && columnas-2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.AZUL_S && celdas[filas-1][columnas-1]==ContenidoCeldas.AZUL_O && celdas[filas-2][columnas-2]==ContenidoCeldas.AZUL_S) return true;

                    if( filas>= 0 && filas< NumFilas && columnas-1>= 0 && columnas-1< NumColumnas && filas>= 0 && filas< NumFilas && columnas-2>= 0 && columnas-2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.AZUL_S && celdas[filas][columnas-1]==ContenidoCeldas.AZUL_O && celdas[filas][columnas-2]==ContenidoCeldas.AZUL_S) return true;

                    if((filas-1>=0 && filas-1<NumFilas && columnas>=0 && columnas<NumColumnas)&&(filas-2>=0 && filas-2<NumFilas && columnas>=0 && columnas<NumColumnas))
                        if (celdas[filas][columnas]==ContenidoCeldas.AZUL_S && celdas[filas-1][columnas]==ContenidoCeldas.AZUL_O && celdas[filas-2][columnas]==ContenidoCeldas.AZUL_S) return true;
                }

            }else
            {
                if(seleccion=='S')
                {
                    if( filas-1>= 0 && filas-1< NumFilas && columnas+1>= 0 && columnas+1< NumColumnas && filas-2>= 0 && filas-2< NumFilas && columnas+2>= 0 && columnas+2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.ROJO_S && celdas[filas-1][columnas+1]==ContenidoCeldas.ROJO_O && celdas[filas-2][columnas+2]==ContenidoCeldas.ROJO_S) return true;

                    if( filas>= 0 && filas< NumFilas && columnas+1>= 0 && columnas+1< NumColumnas && filas>= 0 && filas< NumFilas && columnas+2>= 0 && columnas+2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.ROJO_S && celdas[filas][columnas+1]==ContenidoCeldas.ROJO_O && celdas[filas][columnas+2]==ContenidoCeldas.ROJO_S) return true;

                    if( filas+1>= 0 && filas+1< NumFilas && columnas+1>= 0 && columnas+1< NumColumnas && filas+2>= 0 && filas+2< NumFilas && columnas+2>= 0 && columnas+2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.ROJO_S && celdas[filas+1][columnas+1]==ContenidoCeldas.ROJO_O && celdas[filas+2][columnas+2]==ContenidoCeldas.ROJO_S) return true;

                    if( filas+1>= 0 && filas+1< NumFilas && columnas>= 0 && columnas< NumColumnas && filas+2>= 0 && filas+2< NumFilas && columnas>= 0 && columnas< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.ROJO_S && celdas[filas+1][columnas]==ContenidoCeldas.ROJO_O && celdas[filas+2][columnas]==ContenidoCeldas.ROJO_S) return true;

                    if( filas+1>= 0 && filas+1< NumFilas && columnas-1>= 0 && columnas-1< NumColumnas && filas+2>= 0 && filas+2< NumFilas && columnas-2>= 0 && columnas-2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.ROJO_S && celdas[filas+1][columnas-1]==ContenidoCeldas.ROJO_O && celdas[filas+2][columnas-2]==ContenidoCeldas.ROJO_S) return true;

                    if( filas-1>= 0 && filas-1< NumFilas && columnas-1>= 0 && columnas-1< NumColumnas && filas-2>= 0 && filas-2< NumFilas && columnas-2>= 0 && columnas-2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.ROJO_S && celdas[filas-1][columnas-1]==ContenidoCeldas.ROJO_O && celdas[filas-2][columnas-2]==ContenidoCeldas.ROJO_S) return true;

                    if( filas>= 0 && filas< NumFilas && columnas-1>= 0 && columnas-1< NumColumnas && filas>= 0 && filas< NumFilas && columnas-2>= 0 && columnas-2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.ROJO_S && celdas[filas][columnas-1]==ContenidoCeldas.ROJO_O && celdas[filas][columnas-2]==ContenidoCeldas.ROJO_S) return true;

                    if((filas-1>=0 && filas-1<NumFilas && columnas>=0 && columnas<NumColumnas)&&(filas-2>=0 && filas-2<NumFilas && columnas>=0 && columnas<NumColumnas))
                        if (celdas[filas][columnas]==ContenidoCeldas.ROJO_S && celdas[filas-1][columnas]==ContenidoCeldas.ROJO_O && celdas[filas-2][columnas]==ContenidoCeldas.ROJO_S) return true;
                }
            }
        }
        if(modo==ModoDeJuego.GENERAL){
            if(turno=='A')
            {
                if(seleccion=='S')
                {
                    if( filas-1>= 0 && filas-1< NumFilas && columnas+1>= 0 && columnas+1< NumColumnas && filas-2>= 0 && filas-2< NumFilas && columnas+2>= 0 && columnas+2< NumColumnas)
                         if(celdas[filas][columnas]==ContenidoCeldas.AZUL_S && celdas[filas-1][columnas+1]==ContenidoCeldas.AZUL_O && celdas[filas-2][columnas+2]==ContenidoCeldas.AZUL_S) {
                             turno = 'R';
                             puntosAzul++;
                         }

                    if( filas>= 0 && filas< NumFilas && columnas+1>= 0 && columnas+1< NumColumnas && filas>= 0 && filas< NumFilas && columnas+2>= 0 && columnas+2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.AZUL_S && celdas[filas][columnas+1]==ContenidoCeldas.AZUL_O && celdas[filas][columnas+2]==ContenidoCeldas.AZUL_S) {
                            turno = 'R';
                            puntosAzul++;
                        }

                    if( filas+1>= 0 && filas+1< NumFilas && columnas+1>= 0 && columnas+1< NumColumnas && filas+2>= 0 && filas+2< NumFilas && columnas+2>= 0 && columnas+2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.AZUL_S && celdas[filas+1][columnas+1]==ContenidoCeldas.AZUL_O && celdas[filas+2][columnas+2]==ContenidoCeldas.AZUL_S) {
                            turno = 'R';
                            puntosAzul++;
                        }

                    if( filas+1>= 0 && filas+1< NumFilas && columnas>= 0 && columnas< NumColumnas && filas+2>= 0 && filas+2< NumFilas && columnas>= 0 && columnas< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.AZUL_S && celdas[filas+1][columnas]==ContenidoCeldas.AZUL_O && celdas[filas+2][columnas]==ContenidoCeldas.AZUL_S) {
                            turno = 'R';
                            puntosAzul++;
                        }

                    if( filas+1>= 0 && filas+1< NumFilas && columnas-1>= 0 && columnas-1< NumColumnas && filas+2>= 0 && filas+2< NumFilas && columnas-2>= 0 && columnas-2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.AZUL_S && celdas[filas+1][columnas-1]==ContenidoCeldas.AZUL_O && celdas[filas+2][columnas-2]==ContenidoCeldas.AZUL_S) {
                            turno = 'R';
                            puntosAzul++;
                        }

                    if( filas-1>= 0 && filas-1< NumFilas && columnas-1>= 0 && columnas-1< NumColumnas && filas-2>= 0 && filas-2< NumFilas && columnas-2>= 0 && columnas-2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.AZUL_S && celdas[filas-1][columnas-1]==ContenidoCeldas.AZUL_O && celdas[filas-2][columnas-2]==ContenidoCeldas.AZUL_S) {
                            turno = 'R';
                            puntosAzul++;
                        }

                    if( filas>= 0 && filas< NumFilas && columnas-1>= 0 && columnas-1< NumColumnas && filas>= 0 && filas< NumFilas && columnas-2>= 0 && columnas-2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.AZUL_S && celdas[filas][columnas-1]==ContenidoCeldas.AZUL_O && celdas[filas][columnas-2]==ContenidoCeldas.AZUL_S) {
                            turno = 'R';
                            puntosAzul++;
                        }

                    if( filas-1>= 0 && filas-1< NumFilas && columnas-1>= 0 && columnas-1< NumColumnas && filas-2>= 0 && filas-2< NumFilas && columnas-2>= 0 && columnas-2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.AZUL_S && celdas[filas-1][columnas]==ContenidoCeldas.AZUL_O && celdas[filas-2][columnas]==ContenidoCeldas.AZUL_S) {
                            turno = 'R';
                            puntosAzul++;
                        }
                }else
                {
                    if( filas-1>= 0 && filas-1< NumFilas && columnas+1>= 0 && columnas+1< NumColumnas && filas-2>= 0 && filas-2< NumFilas && columnas+2>= 0 && columnas+2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.AZUL_O && celdas[filas-1][columnas+1]==ContenidoCeldas.AZUL_S && celdas[filas-2][columnas+2]==ContenidoCeldas.AZUL_S) {
                            turno = 'R';
                            puntosAzul++;
                        }

                    if( filas>= 0 && filas< NumFilas && columnas+1>= 0 && columnas+1< NumColumnas && filas>= 0 && filas< NumFilas && columnas+2>= 0 && columnas+2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.AZUL_O && celdas[filas][columnas+1]==ContenidoCeldas.AZUL_S && celdas[filas][columnas+2]==ContenidoCeldas.AZUL_S){
                            turno = 'R';
                            puntosAzul++;
                        }

                    if( filas+1>= 0 && filas+1< NumFilas && columnas+1>= 0 && columnas+1< NumColumnas && filas+2>= 0 && filas+2< NumFilas && columnas+2>= 0 && columnas+2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.AZUL_O && celdas[filas+1][columnas+1]==ContenidoCeldas.AZUL_S && celdas[filas+2][columnas+2]==ContenidoCeldas.AZUL_S) {
                            turno = 'R';
                            puntosAzul++;
                        }

                    if( filas+1>= 0 && filas+1< NumFilas && columnas>= 0 && columnas< NumColumnas && filas+2>= 0 && filas+2< NumFilas && columnas>= 0 && columnas< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.AZUL_O && celdas[filas+1][columnas]==ContenidoCeldas.AZUL_S && celdas[filas+2][columnas]==ContenidoCeldas.AZUL_S) {
                            turno = 'R';
                            puntosAzul++;
                        }

                    if( filas+1>= 0 && filas+1< NumFilas && columnas-1>= 0 && columnas-1< NumColumnas && filas+2>= 0 && filas+2< NumFilas && columnas-2>= 0 && columnas-2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.AZUL_O && celdas[filas+1][columnas-1]==ContenidoCeldas.AZUL_S && celdas[filas+2][columnas-2]==ContenidoCeldas.AZUL_S) {
                            turno = 'R';
                            puntosAzul++;
                        }

                    if( filas-1>= 0 && filas-1< NumFilas && columnas-1>= 0 && columnas-1< NumColumnas && filas-2>= 0 && filas-2< NumFilas && columnas-2>= 0 && columnas-2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.AZUL_O && celdas[filas-1][columnas-1]==ContenidoCeldas.AZUL_S && celdas[filas-2][columnas-2]==ContenidoCeldas.AZUL_S) {
                            turno = 'R';
                            puntosAzul++;
                        }

                    if( filas>= 0 && filas< NumFilas && columnas-1>= 0 && columnas-1< NumColumnas && filas>= 0 && filas< NumFilas && columnas-2>= 0 && columnas-2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.AZUL_O && celdas[filas][columnas-1]==ContenidoCeldas.AZUL_S && celdas[filas][columnas-2]==ContenidoCeldas.AZUL_S) {
                            turno = 'R';
                            puntosAzul++;
                        }

                    if( filas-1>= 0 && filas-1< NumFilas && columnas-1>= 0 && columnas-1< NumColumnas && filas-2>= 0 && filas-2< NumFilas && columnas-2>= 0 && columnas-2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.AZUL_O && celdas[filas-1][columnas]==ContenidoCeldas.AZUL_S && celdas[filas-2][columnas]==ContenidoCeldas.AZUL_S) {
                            turno = 'R';
                            puntosAzul++;
                        }
                }

            }else {
                if(seleccion=='S')
                {
                    if( filas-1>= 0 && filas-1< NumFilas && columnas+1>= 0 && columnas+1< NumColumnas && filas-2>= 0 && filas-2< NumFilas && columnas+2>= 0 && columnas+2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.ROJO_S && celdas[filas-1][columnas+1]==ContenidoCeldas.ROJO_O && celdas[filas-2][columnas+2]==ContenidoCeldas.ROJO_S) {
                            turno='A';
                            puntosRojo++;
                        }

                    if( filas>= 0 && filas< NumFilas && columnas+1>= 0 && columnas+1< NumColumnas && filas>= 0 && filas< NumFilas && columnas+2>= 0 && columnas+2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.ROJO_S && celdas[filas][columnas+1]==ContenidoCeldas.ROJO_O && celdas[filas][columnas+2]==ContenidoCeldas.ROJO_S){
                            turno='A';
                            puntosRojo++;
                        }

                    if( filas+1>= 0 && filas+1< NumFilas && columnas+1>= 0 && columnas+1< NumColumnas && filas+2>= 0 && filas+2< NumFilas && columnas+2>= 0 && columnas+2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.ROJO_S && celdas[filas+1][columnas+1]==ContenidoCeldas.ROJO_O && celdas[filas+2][columnas+2]==ContenidoCeldas.ROJO_S) {
                            turno='A';
                            puntosRojo++;
                        }

                    if( filas+1>= 0 && filas+1< NumFilas && columnas>= 0 && columnas< NumColumnas && filas+2>= 0 && filas+2< NumFilas && columnas>= 0 && columnas< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.ROJO_S && celdas[filas+1][columnas]==ContenidoCeldas.ROJO_O && celdas[filas+2][columnas]==ContenidoCeldas.ROJO_S) {
                            turno='A';
                            puntosRojo++;
                        }

                    if( filas+1>= 0 && filas+1< NumFilas && columnas-1>= 0 && columnas-1< NumColumnas && filas+2>= 0 && filas+2< NumFilas && columnas-2>= 0 && columnas-2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.ROJO_S && celdas[filas+1][columnas-1]==ContenidoCeldas.ROJO_O && celdas[filas+2][columnas-2]==ContenidoCeldas.ROJO_S) {
                            turno='A';
                            puntosRojo++;
                        }

                    if( filas-1>= 0 && filas-1< NumFilas && columnas-1>= 0 && columnas-1< NumColumnas && filas-2>= 0 && filas-2< NumFilas && columnas-2>= 0 && columnas-2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.ROJO_S && celdas[filas-1][columnas-1]==ContenidoCeldas.ROJO_O && celdas[filas-2][columnas-2]==ContenidoCeldas.ROJO_S){
                            turno='A';
                            puntosRojo++;
                        }

                    if( filas>= 0 && filas< NumFilas && columnas-1>= 0 && columnas-1< NumColumnas && filas>= 0 && filas< NumFilas && columnas-2>= 0 && columnas-2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.ROJO_S && celdas[filas][columnas-1]==ContenidoCeldas.ROJO_O && celdas[filas][columnas-2]==ContenidoCeldas.ROJO_S){
                            turno='A';
                            puntosRojo++;
                        }

                    if( filas-1>= 0 && filas-1< NumFilas && columnas-1>= 0 && columnas-1< NumColumnas && filas-2>= 0 && filas-2< NumFilas && columnas-2>= 0 && columnas-2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.ROJO_S && celdas[filas-1][columnas]==ContenidoCeldas.ROJO_O && celdas[filas-2][columnas]==ContenidoCeldas.ROJO_S){
                            turno='A';
                            puntosRojo++;
                        }
                }else
                {
                    if( filas-1>= 0 && filas-1< NumFilas && columnas+1>= 0 && columnas+1< NumColumnas && filas-2>= 0 && filas-2< NumFilas && columnas+2>= 0 && columnas+2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.ROJO_O && celdas[filas-1][columnas+1]==ContenidoCeldas.ROJO_S && celdas[filas-2][columnas+2]==ContenidoCeldas.ROJO_S){
                            turno='A';
                            puntosRojo++;
                        }

                    if( filas>= 0 && filas< NumFilas && columnas+1>= 0 && columnas+1< NumColumnas && filas>= 0 && filas< NumFilas && columnas+2>= 0 && columnas+2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.ROJO_O && celdas[filas][columnas+1]==ContenidoCeldas.ROJO_S && celdas[filas][columnas+2]==ContenidoCeldas.ROJO_S){
                            turno='A';
                            puntosRojo++;
                        }

                    if( filas+1>= 0 && filas+1< NumFilas && columnas+1>= 0 && columnas+1< NumColumnas && filas+2>= 0 && filas+2< NumFilas && columnas+2>= 0 && columnas+2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.ROJO_O && celdas[filas+1][columnas+1]==ContenidoCeldas.ROJO_S && celdas[filas+2][columnas+2]==ContenidoCeldas.ROJO_S){
                            turno='A';
                            puntosRojo++;
                        }

                    if( filas+1>= 0 && filas+1< NumFilas && columnas>= 0 && columnas< NumColumnas && filas+2>= 0 && filas+2< NumFilas && columnas>= 0 && columnas< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.ROJO_O && celdas[filas+1][columnas]==ContenidoCeldas.ROJO_S && celdas[filas+2][columnas]==ContenidoCeldas.ROJO_S){
                            turno='A';
                            puntosRojo++;
                        }

                    if( filas+1>= 0 && filas+1< NumFilas && columnas-1>= 0 && columnas-1< NumColumnas && filas+2>= 0 && filas+2< NumFilas && columnas-2>= 0 && columnas-2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.ROJO_O && celdas[filas+1][columnas-1]==ContenidoCeldas.ROJO_S && celdas[filas+2][columnas-2]==ContenidoCeldas.ROJO_S){
                            turno='A';
                            puntosRojo++;
                        }

                    if( filas-1>= 0 && filas-1< NumFilas && columnas-1>= 0 && columnas-1< NumColumnas && filas-2>= 0 && filas-2< NumFilas && columnas-2>= 0 && columnas-2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.ROJO_O && celdas[filas-1][columnas-1]==ContenidoCeldas.ROJO_S && celdas[filas-2][columnas-2]==ContenidoCeldas.ROJO_S){
                            turno='A';
                            puntosRojo++;
                        }

                    if( filas>= 0 && filas< NumFilas && columnas-1>= 0 && columnas-1< NumColumnas && filas>= 0 && filas< NumFilas && columnas-2>= 0 && columnas-2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.ROJO_O && celdas[filas][columnas-1]==ContenidoCeldas.ROJO_S && celdas[filas][columnas-2]==ContenidoCeldas.ROJO_S){
                            turno='A';
                            puntosRojo++;
                        }

                    if( filas-1>= 0 && filas-1< NumFilas && columnas-1>= 0 && columnas-1< NumColumnas && filas-2>= 0 && filas-2< NumFilas && columnas-2>= 0 && columnas-2< NumColumnas)
                        if (celdas[filas][columnas]==ContenidoCeldas.ROJO_O && celdas[filas-1][columnas]==ContenidoCeldas.ROJO_S && celdas[filas-2][columnas]==ContenidoCeldas.ROJO_S){
                            turno='A';
                            puntosRojo++;
                        }

                }
            }
            int NumeroDeCeldasNoVacias=0;
            for(int i=0; i<NumFilas;i++)
            {
                for(int j=0; j<NumColumnas; j++)
                {
                    if(celdas[i][j]!=ContenidoCeldas.VACIO) NumeroDeCeldasNoVacias++;
                }
            }
            if(NumeroDeCeldasNoVacias==(NumFilas*NumColumnas))
            {
                return true;
            }

        }
        return false;
    }

    public boolean isDraw()
    {
        for (int filas = 0; filas < NumFilas; ++filas) {
            for (int columnas = 0; columnas < NumColumnas; ++columnas) {
                if (celdas[filas][columnas] == ContenidoCeldas.VACIO) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean CeldaValida(int filas, int columnas){
        if(filas >= 0 && filas < NumFilas && columnas >= 0 && columnas < NumColumnas && celdas[filas][columnas]==ContenidoCeldas.VACIO)
            return true;
        else return false;
    }

    public ContenidoCeldas getContenidoCeldas(int filas, int columnas)
    {
        if(filas >= 0 && filas < NumFilas && columnas >= 0 && columnas < NumColumnas)
            return celdas[filas][columnas];
        else return null;
    }
    public char getTurno(){return turno;}
    public void setSeleccion(char seleccion){this.seleccion = seleccion;}
    public char getSeleccion(){return seleccion;}
    public void setNumFilas(int NumFilas){this.NumFilas =NumFilas;}
    public int getNumFilas(){return NumFilas;}
    public void setNumColumnas(int NumColumnas){this.NumColumnas =NumColumnas;}
    public int getNumColumnas(){return NumColumnas;}
    public void setModo(ModoDeJuego modo){this.modo=modo;}
    public ModoDeJuego getModo(){return modo;}

    public EstadoDeJuego getEstadoActual(){return EstadoActual;}
}
