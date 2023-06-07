package Sprint4_0;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI_4 extends JFrame{
    private JPanel panel1;
    private int TAM_CELDA=100;
    private int ANCHO;
    private int LARGO;
    private PanelBoard paneTablero;
    private JRadioButton AzulSRadioButton;
    private JRadioButton AzulORadioButton;
    private JPanel panelTablero;
    private JPanel BackGround;
    private JButton juegoNuevoButton;
    private Tablero tableroLogico;
    public GUI_4(Tablero tableroLogico){
        this.tableroLogico=tableroLogico;

        intiComponent();
        BotonesJugadorAzul();
    }
    public void intiComponent()
    {
        ANCHO=TAM_CELDA*tableroLogico.getNumFilas();
        LARGO = TAM_CELDA*tableroLogico.getNumColumnas();
        paneTablero = new PanelBoard(ANCHO,LARGO);

        setTitle("SOS GAMER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setPreferredSize(new Dimension(ANCHO,600));
        add(BackGround,BorderLayout.CENTER);


        add(paneTablero,BorderLayout.SOUTH);
        setVisible(true);
        pack();

    }
    public void BotonesJugadorAzul()
    {
        ButtonGroup GroupJugadorAzul=new ButtonGroup();
        GroupJugadorAzul.add(AzulORadioButton);
        GroupJugadorAzul.add(AzulSRadioButton);
    }

    public class PanelBoard extends JPanel{
        private int largo;
        private int ancho;
        private JLabel lblTurno;
        public PanelBoard(int ancho, int largo)
        {
            this.largo=largo;
            this.ancho=ancho;

            setPreferredSize(new Dimension(ancho,largo));
            setBackground(Color.WHITE);

            lblTurno = new JLabel(" ");
            lblTurno.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD,15));
            lblTurno.setBorder(BorderFactory.createEmptyBorder(2,5,4,51));
           addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                   super.mouseClicked(e);
                   if(AzulORadioButton.isSelected()==true) tableroLogico.setSeleccionRojo('O');
                   if(AzulSRadioButton.isSelected()==true) tableroLogico.setSeleccionRojo('S');
                   int filas = e.getY() / TAM_CELDA;
                   int columnas = e.getX() / TAM_CELDA;
                   tableroLogico.RealizarMovimiento(filas,columnas);
               }
           });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLACK);

            DibujarTablero(g);
            Dibujar(g);
            MostrarTurno();
            setVisible(false);
            setVisible(true);
        }

        public void DibujarTablero(Graphics g)
        {
            for( int filas=1; filas<tableroLogico.getNumFilas(); filas++)
            {
                g.fillRoundRect(0,filas*(largo)/tableroLogico.getNumFilas(),ANCHO,6, 6,6);
            }

            for( int colum=1; colum<tableroLogico.getNumColumnas(); colum++)
            {
                g.fillRoundRect(colum*ANCHO/tableroLogico.getNumColumnas(),0,6,ANCHO, 6,6);
            }
        }
        public void Dibujar(Graphics g)
        {
            Graphics2D g2d = (Graphics2D)g;
            g2d.setStroke(new BasicStroke(8, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            for (int row = 0; row < tableroLogico.getNumFilas(); ++row) {
                for (int col = 0; col < tableroLogico.getNumColumnas(); ++col) {
                    int x1 = col * TAM_CELDA +(TAM_CELDA/5);
                    int y1 = row * TAM_CELDA +(TAM_CELDA/5);
                    if (tableroLogico.getContenidoCeldas(row,col) == Tablero.ContenidoCeldas.AZUL_S) {
                        g2d.setColor(Color.BLUE);
                        g2d.drawArc(x1,y1,60,60,90,180);
                        g2d.drawArc(x1,y1,60,60,45,270);
                    }
                    if (tableroLogico.getContenidoCeldas(row,col) == Tablero.ContenidoCeldas.AZUL_O) {
                        g2d.setColor(Color.BLUE);
                        g2d.drawOval(x1, y1, 60, 60);
                    }
                    if (tableroLogico.getContenidoCeldas(row,col) == Tablero.ContenidoCeldas.ROJO_S) {
                        g2d.setColor(Color.RED);
                        g2d.drawArc(x1,y1,60,60,90,180);
                        g2d.drawArc(x1,y1,60,60,45,270);
                    }
                    if (tableroLogico.getContenidoCeldas(row,col) == Tablero.ContenidoCeldas.ROJO_O) {
                        g2d.setColor(Color.RED);
                        g2d.drawOval(x1, y1, 60, 60);
                    }
                }
            }
        }

        public void MostrarTurno()
        {
            if (tableroLogico.getEstadoActual() == Tablero.EstadoDeJuego.PLAYING) {
                if (tableroLogico.getTurno() == 'A') {

                } else {

                }
            } else if (tableroLogico.getEstadoActual() == Tablero.EstadoDeJuego.EMPATE) {
                JOptionPane.showMessageDialog(null,"EMPATE");
            } else if (tableroLogico.getEstadoActual() == Tablero.EstadoDeJuego.AZUL_GANA) {
                JOptionPane.showMessageDialog(null,"AZUL GANA");
            } else if (tableroLogico.getEstadoActual() == Tablero.EstadoDeJuego.ROJO_GANA) {
                JOptionPane.showMessageDialog(null,"ROJO GANA");
            }
        }

    }

    public static void main(String[] args) {
        AutoGame auto= new AutoGame('A');
        new GUI_4(auto);
    }
}
