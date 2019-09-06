package PRUEBAS;

import analizadores.Nodo;
import java.awt.*;
import javax.swing.*;
import java.net.URL;
import java.util.LinkedList;

public class CrearMiVentana {

    JFrame ventana = new JFrame();
    JPanel panel = new JPanel();
    JLabel lblFondo = new JLabel();

    public CrearMiVentana() {

        ventana.setLayout(null);
        ventana.getContentPane().add(lblFondo, BorderLayout.CENTER);

        ventana.setBounds(0, 0, 591, 490);
        ventana.add(panel);
        ventana.repaint();

        lblFondo.setBounds(0, 0, 500, 490);
        lblFondo.setText("Universidad San Carlos");
        lblFondo.setFont(new Font("Consola", Font.PLAIN, 25));
        //  ((JLabel) lblFondo).setHorizontalAlignment(SwingConstants.CENTER);

        ventana.add(lblFondo);
    }

    public void mostrar() {
        ventana.show();
    }

}
