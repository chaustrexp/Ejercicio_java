package Controlador;

import Modelo.carro_modelo;
import java.util.ArrayList;

public class controlador_carro {

    private ArrayList<carro_modelo> lista_carros = new ArrayList<>();

    // Registra un carro en la lista temporal con validación
    public String tomar_datos_carro(String marca, String placa, String modelo) {
        carro_modelo nuevo = new carro_modelo(marca, placa, modelo);
        if (!nuevo.validardatos()) {
            return "Error: No se pudo registrar el carro debido a datos inválidos.";
        }
        lista_carros.add(nuevo);
        return "Carro registrado exitosamente: " + marca + " | Placa: " + placa + " | Modelo: " + modelo;
    }

    // Muestra todos los carros registrados en la lista
    public String enviar_datos() {
        if (lista_carros.isEmpty()) {
            return "No hay carros registrados.";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lista_carros.size(); i++) {
            carro_modelo c = lista_carros.get(i);
            sb.append("--- Carro ").append(i + 1).append(" ---\n");
            sb.append("Marca     : ").append(c.getMarca()).append("\n");
            sb.append("Placa     : ").append(c.getPlaca()).append("\n");
            sb.append("Modelo    : ").append(c.getModelo()).append("\n");
        }
        return sb.toString().trim();
    }

    // Busca un carro por placa y retorna sus datos
    public String buscar_carro(String placa) {
        for (carro_modelo c : lista_carros) {
            if (c.getPlaca().equalsIgnoreCase(placa)) {
                return "Marca     : " + c.getMarca() + "\n"
                     + "Placa     : " + c.getPlaca() + "\n"
                     + "Modelo    : " + c.getModelo();
            }
        }
        return "No se encontró un carro con placa: " + placa;
    }

    // Elimina un carro por placa
    public String eliminar_carro(String placa) {
        for (int i = 0; i < lista_carros.size(); i++) {
            if (lista_carros.get(i).getPlaca().equalsIgnoreCase(placa)) {
                String marca = lista_carros.get(i).getMarca();
                lista_carros.remove(i);
                return "Carro eliminado: " + marca + " | Placa: " + placa;
            }
        }
        return "No se encontró un carro con placa: " + placa;
    }

    // Actualiza los datos de un carro buscándolo por placa
    public String actualizar_carro(String marca, String placa, String modelo) {
        for (carro_modelo c : lista_carros) {
            if (c.getPlaca().equalsIgnoreCase(placa)) {
                carro_modelo temp = new carro_modelo(marca, placa, modelo);
                if (!temp.validardatos()) {
                    return "Error: No se pudo actualizar el carro debido a datos inválidos.";
                }
                c.setMarca(marca);
                c.setModelo(modelo);
                return "Carro actualizado exitosamente: " + marca + " | Placa: " + placa;
            }
        }
        return "No se encontró un carro con placa: " + placa;
    }
}
