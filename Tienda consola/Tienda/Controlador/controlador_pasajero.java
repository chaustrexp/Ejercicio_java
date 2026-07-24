package Controlador;

import Modelo.pasajero_modelo;
import java.util.ArrayList;

public class controlador_pasajero {

    private ArrayList<pasajero_modelo> lista_pasajeros = new ArrayList<>();

    // Registra un pasajero en la lista temporal con validación
    public String tomar_datos_pasajero(String nombre, String apellido, String cedula, String telefono) {
        pasajero_modelo nuevo = new pasajero_modelo(nombre, apellido, cedula, telefono);
        if (!nuevo.validardatos()) {
            return "Error: No se pudo registrar el pasajero debido a datos inválidos.";
        }
        lista_pasajeros.add(nuevo);
        return "Pasajero registrado exitosamente: " + nombre + " " + apellido + " | Cédula: " + cedula;
    }

    // Muestra todos los pasajeros registrados en la lista
    public String enviar_datos() {
        if (lista_pasajeros.isEmpty()) {
            return "No hay pasajeros registrados.";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lista_pasajeros.size(); i++) {
            pasajero_modelo p = lista_pasajeros.get(i);
            sb.append("--- Pasajero ").append(i + 1).append(" ---\n");
            sb.append("Nombre   : ").append(p.getNombre_pasajero()).append("\n");
            sb.append("Apellido : ").append(p.getApellido_pasajero()).append("\n");
            sb.append("Cédula   : ").append(p.getCedula_pasajero()).append("\n");
            sb.append("Teléfono : ").append(p.getTelefono_pasajero()).append("\n");
        }
        return sb.toString().trim();
    }

    // Busca un pasajero por cédula y retorna sus datos
    public String buscar_pasajero(String cedula) {
        for (pasajero_modelo p : lista_pasajeros) {
            if (p.getCedula_pasajero().equals(cedula)) {
                return "Nombre   : " + p.getNombre_pasajero() + "\n"
                     + "Apellido : " + p.getApellido_pasajero() + "\n"
                     + "Cédula   : " + p.getCedula_pasajero() + "\n"
                     + "Teléfono : " + p.getTelefono_pasajero();
            }
        }
        return "No se encontró un pasajero con cédula: " + cedula;
    }

    // Elimina un pasajero por cédula
    public String eliminar_pasajero(String cedula) {
        for (int i = 0; i < lista_pasajeros.size(); i++) {
            if (lista_pasajeros.get(i).getCedula_pasajero().equals(cedula)) {
                String nombre = lista_pasajeros.get(i).getNombre_pasajero();
                lista_pasajeros.remove(i);
                return "Pasajero eliminado: " + nombre + " | Cédula: " + cedula;
            }
        }
        return "No se encontró un pasajero con cédula: " + cedula;
    }

    // Actualiza los datos de un pasajero buscándolo por cédula
    public String actualizar_pasajero(String nombre, String apellido, String cedula, String telefono) {
        for (pasajero_modelo p : lista_pasajeros) {
            if (p.getCedula_pasajero().equals(cedula)) {
                pasajero_modelo temp = new pasajero_modelo(nombre, apellido, cedula, telefono);
                if (!temp.validardatos()) {
                    return "Error: No se pudo actualizar el pasajero debido a datos inválidos.";
                }
                p.setNombre_pasajero(nombre);
                p.setApellido_pasajero(apellido);
                p.setTelefono_pasajero(telefono);
                return "Pasajero actualizado exitosamente: " + nombre + " " + apellido + " | Cédula: " + cedula;
            }
        }
        return "No se encontró un pasajero con cédula: " + cedula;
    }
}
