package Vista;

import Controlador.controlador_motor;
import java.util.Scanner;

public class motor_vista {

    private controlador_motor obj_controlador;

    public motor_vista() {
        this.obj_controlador = new controlador_motor();
    }

    public motor_vista(controlador_motor controlador) {
        this.obj_controlador = controlador;
    }

    public void mostrarMenu(Scanner scanner) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- GESTIÓN DE MOTORES ---");
            System.out.println("1. Registrar Motor");
            System.out.println("2. Mostrar Todos los Motores");
            System.out.println("3. Actualizar Motor");
            System.out.println("4. Eliminar Motor");
            System.out.println("5. Buscar por Número de Serie");
            System.out.println("6. Regresar al Menú Principal");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1":
                    System.out.print("Ingrese Tipo de Motor: ");
                    String tipo = scanner.nextLine();
                    System.out.print("Ingrese Número de Serie: ");
                    String serie = scanner.nextLine();
                    System.out.print("Ingrese Cilindraje: ");
                    String cilindraje = scanner.nextLine();
                    System.out.println(obj_controlador.tomar_datos_motor(tipo, serie, cilindraje, ""));
                    break;
                case "2":
                    System.out.println("\n" + obj_controlador.enviar_datos());
                    break;
                case "3":
                    System.out.print("Ingrese Número de Serie del motor a actualizar: ");
                    String serieAct = scanner.nextLine();
                    if (!serieAct.isEmpty()) {
                        System.out.print("Ingrese Nuevo Tipo de Motor: ");
                        String nuevoTipo = scanner.nextLine();
                        System.out.print("Ingrese Nuevo Cilindraje: ");
                        String nuevoCilindraje = scanner.nextLine();
                        System.out.println(obj_controlador.actualizar_motor(nuevoTipo, serieAct, nuevoCilindraje, ""));
                    } else {
                        System.out.println("Por favor, ingrese el número de serie para actualizar.");
                    }
                    break;
                case "4":
                    System.out.print("Ingrese Número de Serie a eliminar: ");
                    String serieElim = scanner.nextLine();
                    if (!serieElim.isEmpty()) {
                        System.out.println(obj_controlador.eliminar_motor(serieElim));
                    } else {
                        System.out.println("Por favor, ingrese el número de serie para eliminar.");
                    }
                    break;
                case "5":
                    System.out.print("Ingrese Número de Serie a buscar: ");
                    String serieBusc = scanner.nextLine();
                    if (!serieBusc.isEmpty()) {
                        System.out.println(obj_controlador.buscar_motor(serieBusc));
                    } else {
                        System.out.println("Por favor, ingrese el número de serie para buscar.");
                    }
                    break;
                case "6":
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }
        }
    }
}
