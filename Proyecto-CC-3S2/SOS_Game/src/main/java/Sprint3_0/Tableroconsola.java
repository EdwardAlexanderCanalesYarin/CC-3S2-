package Sprint3_0;

public class Tableroconsola {
    private Tablero tablero;
    public Tableroconsola(Tablero tablero)
    {
        this.tablero=tablero;
    }

    public void MostrarConsola()
    {
        for(int filas=0; filas<tablero.getNumFilas(); filas++)
        {
            System.out.println("--------------------------------------");
            for(int columnas=0; columnas<tablero.getNumColumnas(); columnas++)
            {

                System.out.print("|"+tablero.getContenidoCeldas(filas,columnas));
                System.out.print("| ");
            }
            System.out.print("\n");
        }
        System.out.println("--------------------------------------");
    }

    public static void main(String[] args) {
        new Tableroconsola(new Tablero(3,3)).MostrarConsola();
    }
}
