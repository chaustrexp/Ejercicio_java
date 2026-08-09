package Vista;

import Controlador.controlador_general;
import java.util.Scanner;

public class registro_viaje_vista {

    private controlador_general ctrl;

    public registro_viaje_vista() {
        this.ctrl = controlador_general.getInstance();
    }

    public void mostrarMenu(Scanner scanner) {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- GESTIÓN DE VIAJES ---");
            System.out.println("1. Registrar nuevo viaje");
            System.out.println("2. Ver viajes registrados");
            System.out.println("3. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1":
                    registrarViaje(scanner);
                    break;
                case "2":
                    System.out.println("\n--- LISTA DE VIAJES ---");
                    System.out.println(ctrl.enviar_datos_viajes());
                    break;
                case "3":
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    private void registrarViaje(Scanner scanner) {
        System.out.println("\n--- REGISTRO DE VIAJE ---");
        
        System.out.print("Ingrese la placa del Carro: ");
        String placa = scanner.nextLine().trim();

        System.out.print("Ingrese el número de serie del Motor: ");
        String serieMotor = scanner.nextLine().trim();

        System.out.print("Ingrese la cédula del Chofer: ");
        String cedulaChofer = scanner.nextLine().trim();

        System.out.print("Ingrese la cédula del Pasajero: ");
        String cedulaPasajero = scanner.nextLine().trim();

        String resultado = ctrl.registrar_viaje(placa, serieMotor, cedulaChofer, cedulaPasajero);
        System.out.println(">>> " + resultado);
    }
}
