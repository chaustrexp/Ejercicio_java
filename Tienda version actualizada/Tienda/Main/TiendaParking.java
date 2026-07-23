package Main;

import Controlador.controlador_chofer;
import Controlador.controlador_carro;
import Controlador.controlador_motor;
import Controlador.controlador_pasajero;
import java.util.Scanner;

public class TiendaParking {

    public static void main(String[] args) {
        // Lanzar la interfaz gráfica principal
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("Iniciando la aplicación con interfaz gráfica...");
                Vista.vista_general vista = new Vista.vista_general();
                vista.setVisible(true);
            }
        });
    }
}
