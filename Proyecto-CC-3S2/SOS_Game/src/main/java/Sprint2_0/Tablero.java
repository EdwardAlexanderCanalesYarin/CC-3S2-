package Sprint2_0;

public class Tablero {
    public enum ContenidoDeLasCeldasDelTablero {VACIO, SIMBOLO_AZUL_O, SIMBOLO_AZUL_S, SIMBOLO_ROJO_S,SIMBOLO_ROJO_O};

    public enum EstadoDeJuego {EN_TURNO, COLOCANDO, AZUL_GANA, ROJO_GANA};
    public enum ModoDeJuego {SIMPLE, GENERAL};
    public ContenidoDeLasCeldasDelTablero celdas[][];
    private EstadoDeJuego estadoActualDeJuego;
    public char seleccion_azul;
    public char seleccion_rojo;
    private int NumFilas=3;

    private int NumColumnas=3;
    private char turno;

    public Tablero()
    {
        celdas = new ContenidoDeLasCeldasDelTablero[NumFilas][NumColumnas];
        initTablero();
    }

    public void initTablero()
    {
        for(int filas=0; filas<NumFilas;filas++)
            for (int columnas=0; columnas<NumColumnas;columnas++)
                celdas[filas][columnas]= ContenidoDeLasCeldasDelTablero.VACIO;
        estadoActualDeJuego=EstadoDeJuego.EN_TURNO;
        turno='A';
    }
    public ModoDeJuego SeleccionDeModoDeJuegoSimple()
    {
        return ModoDeJuego.SIMPLE;
    }
    public ModoDeJuego SeleccionDeModoDeJuegoGeneral()
    {
        return ModoDeJuego.GENERAL;
    }
    public void setNumFilas(int NumFilas){this.NumFilas=NumFilas;}
    public void setNumColumnas(int NumColumnas){this.NumColumnas=NumColumnas;}
    public int getNumFilas(){
        return NumFilas;
    }
    public int getNumColumnas(){
        return NumColumnas;
    }
    public ContenidoDeLasCeldasDelTablero getContenidoDeLasCeldasDelTablero(int filas, int columnas) {
        if(filas >= 0 && filas < NumFilas && columnas >= 0 && columnas < NumColumnas)
            return celdas[filas][columnas];
        else return null;
    }
    public void hacerMovimiento(int filas, int columnas) {
        if(filas>=0 && filas < NumFilas && columnas>=0 && columnas < NumColumnas && celdas[filas][columnas]==ContenidoDeLasCeldasDelTablero.VACIO)
        {

            if(turno=='A'){
                if(seleccion_azul=='S') {
                    celdas[filas][columnas] = ContenidoDeLasCeldasDelTablero.SIMBOLO_AZUL_S;
                    actualizarEstadoDeJuego(turno,filas,columnas);
                    turno='R';
                }else{
                    celdas[filas][columnas] = ContenidoDeLasCeldasDelTablero.SIMBOLO_AZUL_O;
                    actualizarEstadoDeJuego(turno,filas,columnas);
                    turno='R';
                }
            }else{
                if(seleccion_rojo =='S') {
                    celdas[filas][columnas] = ContenidoDeLasCeldasDelTablero.SIMBOLO_ROJO_S;
                    actualizarEstadoDeJuego(turno,filas,columnas);
                    turno='A';
                }else{
                    celdas[filas][columnas] = ContenidoDeLasCeldasDelTablero.SIMBOLO_ROJO_O;
                    actualizarEstadoDeJuego(turno,filas,columnas);
                    turno='A';
                }
            }
        }
    }
    private void actualizarEstadoDeJuego(char turno,int filas, int columnas)
    {
        if(GanadorSimple(turno,filas,columnas))
        {
            estadoActualDeJuego = (turno=='A')? EstadoDeJuego.AZUL_GANA:EstadoDeJuego.ROJO_GANA;
        }else if(ColocaSimbolo()){
            estadoActualDeJuego = EstadoDeJuego.COLOCANDO;
        }
    }
    private boolean ColocaSimbolo()
    {
        for (int filas = 0; filas < NumFilas; ++filas) {
            for (int col = 0; col < NumColumnas; ++col) {
                if (celdas[filas][col] == ContenidoDeLasCeldasDelTablero.VACIO) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean GanadorSimple(char turno, int filas, int numColumnas)
    {
        return false;
    }
    public char getTurno()
    {
        return turno;
    }
    public void setTurno(char turno)
    {
        this.turno=turno;
    }
    public char getSelccionRojo()
    {
        return seleccion_rojo;
    }
    public char getSeleccionAzul()
    {
        return seleccion_azul;
    }
    public void setSeleccionRojo(char seleccion_rojo)
    {
        this.seleccion_rojo=seleccion_rojo;
    }
    public void setSeleccionAzul(char seleccion_azul){
        this.seleccion_azul=seleccion_azul;
    }
    public EstadoDeJuego getEstadoDeJuego(){ return estadoActualDeJuego;}

}
