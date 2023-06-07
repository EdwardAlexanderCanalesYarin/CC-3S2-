package Sprint3_0;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame{
    private JPanel panel1;
    private JPanel BackGround;
    private JRadioButton juegoSimpleRadioButton;
    private JRadioButton juegoGeneralRadioButton;
    private JTextField txtSize;
    private JButton empezarButton;

    public Menu()
    {
        setTitle("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(300,300));

        add(BackGround,BorderLayout.CENTER);
        setVisible(true);
        pack();
        txtSize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tam=Integer.parseInt(txtSize.getText());
                Tablero tablero = new Tablero(tam, tam);
                if(juegoSimpleRadioButton.isSelected()==true) tablero.setModo(Tablero.ModoDeJuego.SIMPLE);
                if(juegoGeneralRadioButton.isSelected()==true) tablero.setModo(Tablero.ModoDeJuego.GENERAL);
                new GUI_2(tablero);
                setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        new Menu();
    }
}
