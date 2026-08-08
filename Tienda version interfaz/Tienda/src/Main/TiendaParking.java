package Main;

import Controlador.controlador_general;
import Vista.vista_general;
import javax.swing.SwingUtilities;

public class TiendaParking {

    public static void main(String[] args) {

        // Inicializar el controlador con los datos de conexión
        controlador_general ctrl = controlador_general.getInstance();
        ctrl.inicializar_api("root", "1234567890", "localhost", "http://localhost:8080/api");

        // Lanzar la interfaz gráfica en el hilo de Swing
        SwingUtilities.invokeLater(() -> {
            vista_general ventana = new vista_general();
            ventana.setVisible(true);
        });
    }
}
