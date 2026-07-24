package Vista;

import Controlador.controlador_pasajero;
import java.util.Scanner;

public class pasajero_vista {

    private controlador_pasajero obj_controlador;

    public pasajero_vista() {
        this.obj_controlador = new controlador_pasajero();
    }

    public pasajero_vista(controlador_pasajero controlador) {
        this.obj_controlador = controlador;
    }

    public void mostrarMenu(Scanner scanner) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- GESTIÓN DE PASAJEROS ---");
            System.out.println("1. Registrar Pasajero");
            System.out.println("2. Mostrar Todos los Pasajeros");
            System.out.println("3. Actualizar Pasajero");
            System.out.println("4. Eliminar Pasajero");
            System.out.println("5. Buscar por Cédula");
            System.out.println("6. Regresar al Menú Principal");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1":
                    System.out.print("Ingrese Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Ingrese Cédula: ");
                    String cedula = scanner.nextLine();
                    System.out.print("Ingrese Teléfono: ");
                    String telefono = scanner.nextLine();
                    System.out.println(obj_controlador.tomar_datos_pasajero(nombre, apellido, cedula, telefono));
                    break;
                case "2":
                    System.out.println("\n" + obj_controlador.enviar_datos());
                    break;
                case "3":
                    System.out.print("Ingrese Cédula del pasajero a actualizar: ");
                    String cedulaAct = scanner.nextLine();
                    if (!cedulaAct.isEmpty()) {
                        System.out.print("Ingrese Nuevo Nombre: ");
                        String nuevoNombre = scanner.nextLine();
                        System.out.print("Ingrese Nuevo Apellido: ");
                        String nuevoApellido = scanner.nextLine();
                        System.out.print("Ingrese Nuevo Teléfono: ");
                        String nuevoTelefono = scanner.nextLine();
                        System.out.println(obj_controlador.actualizar_pasajero(nuevoNombre, nuevoApellido, cedulaAct, nuevoTelefono));
                    } else {
                        System.out.println("Por favor, ingrese la cédula para actualizar.");
                    }
                    break;
                case "4":
                    System.out.print("Ingrese Cédula a eliminar: ");
                    String cedulaElim = scanner.nextLine();
                    if (!cedulaElim.isEmpty()) {
                        System.out.println(obj_controlador.eliminar_pasajero(cedulaElim));
                    } else {
                        System.out.println("Por favor, ingrese la cédula para eliminar.");
                    }
                    break;
                case "5":
                    System.out.print("Ingrese Cédula a buscar: ");
                    String cedulaBusc = scanner.nextLine();
                    if (!cedulaBusc.isEmpty()) {
                        System.out.println(obj_controlador.buscar_pasajero(cedulaBusc));
                    } else {
                        System.out.println("Por favor, ingrese la cédula para buscar.");
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
