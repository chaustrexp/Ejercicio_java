package Vista;

import Controlador.controlador_general;
import java.util.Scanner;

public class vista_general {

    private controlador_general ctrl;

    public vista_general() {
        this.ctrl = controlador_general.getInstance();
    }

    public void iniciarMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n==================================");
            System.out.println("     SISTEMA GESTIÓN DE VEHÍCULOS  ");
            System.out.println("==================================");
            System.out.println("1. Gestión de Carros");
            System.out.println("2. Gestión de Choferes");
            System.out.println("3. Gestión de Motores");
            System.out.println("4. Gestión de Pasajeros");
            System.out.println("5. Gestión de Viajes");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1":
                    new carro_vista().mostrarMenu(scanner);
                    break;
                case "2":
                    new chofer_vista().mostrarMenu(scanner);
                    break;
                case "3":
                    new motor_vista().mostrarMenu(scanner);
                    break;
                case "4":
                    new pasajero_vista().mostrarMenu(scanner);
                    break;
                case "5":
                    new registro_viaje_vista().mostrarMenu(scanner);
                    break;
                case "6":
                    System.out.println("¡Gracias por utilizar el sistema!");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new vista_general().iniciarMenu();
    }
}