package Controlador;

import Modelo.chofer_modelo;
import java.util.ArrayList;

public class controlador_chofer {

    private ArrayList<chofer_modelo> lista_choferes = new ArrayList<>();

    // Registra un chofer en la lista temporal con validación
    public String tomar_datos_chofer(String nombre, String cedula, String licencia) {
        chofer_modelo nuevo = new chofer_modelo(nombre, cedula, licencia);
        if (!nuevo.validardatos()) {
            return "Error: No se pudo registrar el chofer debido a datos inválidos.";
        }
        lista_choferes.add(nuevo);
        return "Chofer registrado exitosamente: " + nombre + " | Cédula: " + cedula + " | Licencia: " + licencia;
    }

    // Muestra todos los choferes registrados en la lista
    public String enviar_datos() {
        if (lista_choferes.isEmpty()) {
            return "No hay choferes registrados.";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lista_choferes.size(); i++) {
            chofer_modelo ch = lista_choferes.get(i);
            sb.append("--- Chofer ").append(i + 1).append(" ---\n");
            sb.append("Nombre   : ").append(ch.getNombre_chofer()).append("\n");
            sb.append("Cédula   : ").append(ch.getCedula_chofer()).append("\n");
            sb.append("Licencia : ").append(ch.getLicencia()).append("\n");
        }
        return sb.toString().trim();
    }

    // Busca un chofer por cédula y retorna sus datos
    public String buscar_chofer(String cedula) {
        for (chofer_modelo ch : lista_choferes) {
            if (ch.getCedula_chofer().equals(cedula)) {
                return "Nombre   : " + ch.getNombre_chofer() + "\n"
                     + "Cédula   : " + ch.getCedula_chofer() + "\n"
                     + "Licencia : " + ch.getLicencia();
            }
        }
        return "No se encontró un chofer con cédula: " + cedula;
    }

    // Elimina un chofer por cédula
    public String eliminar_chofer(String cedula) {
        for (int i = 0; i < lista_choferes.size(); i++) {
            if (lista_choferes.get(i).getCedula_chofer().equals(cedula)) {
                String nombre = lista_choferes.get(i).getNombre_chofer();
                lista_choferes.remove(i);
                return "Chofer eliminado: " + nombre + " | Cédula: " + cedula;
            }
        }
        return "No se encontró un chofer con cédula: " + cedula;
    }

    // Actualiza los datos de un chofer buscándolo por cédula
    public String actualizar_chofer(String nombre, String cedula, String licencia) {
        for (chofer_modelo ch : lista_choferes) {
            if (ch.getCedula_chofer().equals(cedula)) {
                chofer_modelo temp = new chofer_modelo(nombre, cedula, licencia);
                if (!temp.validardatos()) {
                    return "Error: No se pudo actualizar el chofer debido a datos inválidos.";
                }
                ch.setNombre_chofer(nombre);
                ch.setLicencia(licencia);
                return "Chofer actualizado exitosamente: " + nombre + " | Cédula: " + cedula + " | Licencia: " + licencia;
            }
        }
        return "No se encontró un chofer con cédula: " + cedula;
    }
}
