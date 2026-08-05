package Main;

import Controlador.controlador_general;
import Vista.vista_general;

public class TiendaParking {

    public static void main(String[] args) {
        System.out.println("Iniciando la aplicación en consola...");

        // Inicializar la API con los datos de conexión
        controlador_general ctrl = controlador_general.getInstance();
        ctrl.inicializar_api("root", "1234567890", "localhost", "http://localhost:8080/api");

        System.out.println(ctrl.getApi().conexion());

        vista_general vista = new vista_general();
        vista.iniciarMenu();
    }
}
