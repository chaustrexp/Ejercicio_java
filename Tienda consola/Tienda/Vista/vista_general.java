package Vista;

import Controlador.controlador_carro;
import Controlador.controlador_chofer;
import Controlador.controlador_motor;
import Controlador.controlador_pasajero;
import java.util.Scanner;

public class vista_general {

    private controlador_carro ctrlCarro;
    private controlador_chofer ctrlChofer;
    private controlador_motor ctrlMotor;
    private controlador_pasajero ctrlPasajero;

    public vista_general() {
        this.ctrlCarro = new controlador_carro();
        this.ctrlChofer = new controlador_chofer();
        this.ctrlMotor = new controlador_motor();
        this.ctrlPasajero = new controlador_pasajero();
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
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1":
                    new carro_vista(ctrlCarro).mostrarMenu(scanner);
                    break;
                case "2":
                    new chofer_vista(ctrlChofer).mostrarMenu(scanner);
                    break;
                case "3":
                    new motor_vista(ctrlMotor).mostrarMenu(scanner);
                    break;
                case "4":
                    new pasajero_vista(ctrlPasajero).mostrarMenu(scanner);
                    break;
                case "5":
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