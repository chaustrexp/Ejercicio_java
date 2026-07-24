package Controlador;

import Modelo.motor_modelo;
import java.util.ArrayList;

public class controlador_motor {

    private ArrayList<motor_modelo> lista_motores = new ArrayList<>();

    // Registra un motor en la lista temporal con validación
    public String tomar_datos_motor(String tipo_motor, String numero_serie, String cilindraje, String extra) {
        int cil = 0;
        try {
            cil = Integer.parseInt(cilindraje.trim());
        } catch (NumberFormatException e) {
            System.out.println("Error: El cilindraje debe ser numérico.");
            return "Error: No se pudo registrar el motor (cilindraje debe ser número entero).";
        }
        motor_modelo nuevo = new motor_modelo(cil, tipo_motor, numero_serie);
        if (!nuevo.validardatos()) {
            return "Error: No se pudo registrar el motor debido a datos inválidos.";
        }
        lista_motores.add(nuevo);
        return "Motor registrado exitosamente | Serie: " + numero_serie + " | Tipo: " + tipo_motor;
    }

    // Muestra todos los motores registrados en la lista
    public String enviar_datos() {
        if (lista_motores.isEmpty()) {
            return "No hay motores registrados.";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lista_motores.size(); i++) {
            motor_modelo m = lista_motores.get(i);
            sb.append("--- Motor ").append(i + 1).append(" ---\n");
            sb.append("Tipo       : ").append(m.getTipo_motor()).append("\n");
            sb.append("N° Serie   : ").append(m.getNumero_serie()).append("\n");
            sb.append("Cilindraje : ").append(m.getCilindraje()).append("\n");
        }
        return sb.toString().trim();
    }

    // Busca un motor por número de serie y retorna sus datos
    public String buscar_motor(String numero_serie) {
        for (motor_modelo m : lista_motores) {
            if (m.getNumero_serie().equalsIgnoreCase(numero_serie)) {
                return "Tipo       : " + m.getTipo_motor() + "\n"
                     + "N° Serie   : " + m.getNumero_serie() + "\n"
                     + "Cilindraje : " + m.getCilindraje();
            }
        }
        return "No se encontró un motor con serie: " + numero_serie;
    }

    // Elimina un motor por número de serie
    public String eliminar_motor(String numero_serie) {
        for (int i = 0; i < lista_motores.size(); i++) {
            if (lista_motores.get(i).getNumero_serie().equalsIgnoreCase(numero_serie)) {
                lista_motores.remove(i);
                return "Motor eliminado: " + numero_serie;
            }
        }
        return "No se encontró un motor con serie: " + numero_serie;
    }

    // Actualiza los datos de un motor buscándolo por número de serie
    public String actualizar_motor(String tipo_motor, String numero_serie, String cilindraje, String extra) {
        for (motor_modelo m : lista_motores) {
            if (m.getNumero_serie().equalsIgnoreCase(numero_serie)) {
                int cil = 0;
                try {
                    cil = Integer.parseInt(cilindraje.trim());
                } catch (NumberFormatException e) {
                    System.out.println("Error: El cilindraje debe ser numérico.");
                    return "Error: No se pudo actualizar el motor (cilindraje debe ser número entero).";
                }
                motor_modelo temp = new motor_modelo(cil, tipo_motor, numero_serie);
                if (!temp.validardatos()) {
                    return "Error: No se pudo actualizar el motor debido a datos inválidos.";
                }
                m.setTipo_motor(tipo_motor);
                m.setCilindraje(cil);
                return "Motor actualizado exitosamente: " + numero_serie + " | Tipo: " + tipo_motor;
            }
        }
        return "No se encontró un motor con serie: " + numero_serie;
    }
}
