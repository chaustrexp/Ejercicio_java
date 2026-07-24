package Vista;

import Controlador.controlador_chofer;
import java.util.Scanner;

public class chofer_vista {

    private controlador_chofer obj_controlador;

    public chofer_vista() {
        this.obj_controlador = new controlador_chofer();
    }

    public chofer_vista(controlador_chofer controlador) {
        this.obj_controlador = controlador;
    }

    public void mostrarMenu(Scanner scanner) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- GESTIÓN DE CHOFERES ---");
            System.out.println("1. Registrar Chofer");
            System.out.println("2. Mostrar Todos los Choferes");
            System.out.println("3. Actualizar Chofer");
            System.out.println("4. Eliminar Chofer");
            System.out.println("5. Buscar por Cédula");
            System.out.println("6. Regresar al Menú Principal");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1":
                    System.out.print("Ingrese Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese Cédula: ");
                    String cedula = scanner.nextLine();
                    System.out.print("Ingrese Licencia: ");
                    String licencia = scanner.nextLine();
                    System.out.println(obj_controlador.tomar_datos_chofer(nombre, cedula, licencia));
                    break;
                case "2":
                    System.out.println("\n" + obj_controlador.enviar_datos());
                    break;
                case "3":
                    System.out.print("Ingrese Cédula del chofer a actualizar: ");
                    String cedulaAct = scanner.nextLine();
                    if (!cedulaAct.isEmpty()) {
                        System.out.print("Ingrese Nuevo Nombre: ");
                        String nuevoNombre = scanner.nextLine();
                        System.out.print("Ingrese Nueva Licencia: ");
                        String nuevaLicencia = scanner.nextLine();
                        System.out.println(obj_controlador.actualizar_chofer(nuevoNombre, cedulaAct, nuevaLicencia));
                    } else {
                        System.out.println("Por favor, ingrese la cédula para actualizar.");
                    }
                    break;
                case "4":
                    System.out.print("Ingrese Cédula del chofer a eliminar: ");
                    String cedulaElim = scanner.nextLine();
                    if (!cedulaElim.isEmpty()) {
                        System.out.println(obj_controlador.eliminar_chofer(cedulaElim));
                    } else {
                        System.out.println("Por favor, ingrese la cédula para eliminar.");
                    }
                    break;
                case "5":
                    System.out.print("Ingrese Cédula a buscar: ");
                    String cedulaBusc = scanner.nextLine();
                    if (!cedulaBusc.isEmpty()) {
                        System.out.println(obj_controlador.buscar_chofer(cedulaBusc));
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