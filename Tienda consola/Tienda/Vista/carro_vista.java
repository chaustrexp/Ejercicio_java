package Vista;

import Controlador.controlador_carro;
import java.util.Scanner;

public class carro_vista {

    private controlador_carro obj_controlador;

    public carro_vista() {
        this.obj_controlador = new controlador_carro();
    }

    public carro_vista(controlador_carro controlador) {
        this.obj_controlador = controlador;
    }

    public void mostrarMenu(Scanner scanner) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- GESTIÓN DE CARROS ---");
            System.out.println("1. Registrar Carro");
            System.out.println("2. Mostrar Todos los Carros");
            System.out.println("3. Actualizar Carro");
            System.out.println("4. Eliminar Carro");
            System.out.println("5. Buscar por Placa");
            System.out.println("6. Regresar al Menú Principal");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1":
                    System.out.print("Ingrese Marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Ingrese Placa: ");
                    String placa = scanner.nextLine();
                    System.out.print("Ingrese Modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.println(obj_controlador.tomar_datos_carro(marca, placa, modelo));
                    break;
                case "2":
                    System.out.println("\n" + obj_controlador.enviar_datos());
                    break;
                case "3":
                    System.out.print("Ingrese Placa del carro a actualizar: ");
                    String placaAct = scanner.nextLine();
                    if (!placaAct.isEmpty()) {
                        System.out.print("Ingrese Nueva Marca: ");
                        String nuevaMarca = scanner.nextLine();
                        System.out.print("Ingrese Nuevo Modelo: ");
                        String nuevoModelo = scanner.nextLine();
                        System.out.println(obj_controlador.actualizar_carro(nuevaMarca, placaAct, nuevoModelo));
                    } else {
                        System.out.println("Por favor, ingrese la placa para actualizar.");
                    }
                    break;
                case "4":
                    System.out.print("Ingrese Placa del carro a eliminar: ");
                    String placaElim = scanner.nextLine();
                    if (!placaElim.isEmpty()) {
                        System.out.println(obj_controlador.eliminar_carro(placaElim));
                    } else {
                        System.out.println("Por favor, ingrese la placa para eliminar.");
                    }
                    break;
                case "5":
                    System.out.print("Ingrese Placa a buscar: ");
                    String placaBusc = scanner.nextLine();
                    if (!placaBusc.isEmpty()) {
                        System.out.println(obj_controlador.buscar_carro(placaBusc));
                    } else {
                        System.out.println("Por favor, ingrese la placa para buscar.");
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
