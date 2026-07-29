package Controlador;

import Modelo.carro_modelo;
import Modelo.chofer_modelo;
import Modelo.motor_modelo;
import Modelo.pasajero_modelo;
import Modelo.registro_viaje_modelo;
import java.util.ArrayList;

public class controlador_general {
    
    private static controlador_general instance;
    
    private ArrayList<carro_modelo> lista_carros = new ArrayList<>();
    private ArrayList<chofer_modelo> lista_choferes = new ArrayList<>();
    private ArrayList<motor_modelo> lista_motores = new ArrayList<>();
    private ArrayList<pasajero_modelo> lista_pasajeros = new ArrayList<>();
    private ArrayList<registro_viaje_modelo> lista_viajes = new ArrayList<>();
    
    private controlador_general() {}
    
    public static controlador_general getInstance() {
        if(instance == null) {
            instance = new controlador_general();
        }
        return instance;
    }
    
    // ==========================================
    // CARROS
    // ==========================================
    public String tomar_datos_carro(String marca, String placa, String modelo) {
        try {
            carro_modelo nuevo = new carro_modelo(marca, placa, modelo);
            nuevo.validardatos();
            lista_carros.add(nuevo);
            return "Carro registrado exitosamente: " + marca + " | Placa: " + placa + " | Modelo: " + modelo;
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    public String enviar_datos_carro() {
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

    public String actualizar_carro(String marca, String placa, String modelo) {
        for (carro_modelo c : lista_carros) {
            if (c.getPlaca().equalsIgnoreCase(placa)) {
                try {
                    carro_modelo temp = new carro_modelo(marca, placa, modelo);
                    temp.validardatos();
                    c.setMarca(marca);
                    c.setModelo(modelo);
                    return "Carro actualizado exitosamente: " + marca + " | Placa: " + placa;
                } catch (IllegalArgumentException e) {
                    return e.getMessage();
                }
            }
        }
        return "No se encontró un carro con placa: " + placa;
    }

    // ==========================================
    // CHOFERES
    // ==========================================
    public String tomar_datos_chofer(String nombre, String cedula, String licencia) {
        try {
            chofer_modelo nuevo = new chofer_modelo(nombre, cedula, licencia);
            nuevo.validardatos();
            lista_choferes.add(nuevo);
            return "Chofer registrado exitosamente: " + nombre + " | Cédula: " + cedula + " | Licencia: " + licencia;
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    public String enviar_datos_chofer() {
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

    public String actualizar_chofer(String nombre, String cedula, String licencia) {
        for (chofer_modelo ch : lista_choferes) {
            if (ch.getCedula_chofer().equals(cedula)) {
                try {
                    chofer_modelo temp = new chofer_modelo(nombre, cedula, licencia);
                    temp.validardatos();
                    ch.setNombre_chofer(nombre);
                    ch.setLicencia(licencia);
                    return "Chofer actualizado exitosamente: " + nombre + " | Cédula: " + cedula + " | Licencia: " + licencia;
                } catch (IllegalArgumentException e) {
                    return e.getMessage();
                }
            }
        }
        return "No se encontró un chofer con cédula: " + cedula;
    }

    // ==========================================
    // MOTORES
    // ==========================================
    public String tomar_datos_motor(String tipo_motor, String numero_serie, String cilindraje, String extra) {
        int cil = 0;
        try {
            cil = Integer.parseInt(cilindraje.trim());
        } catch (NumberFormatException e) {
            return "Error: No se pudo registrar el motor (cilindraje debe ser número entero).";
        }
        try {
            motor_modelo nuevo = new motor_modelo(cil, tipo_motor, numero_serie);
            nuevo.validardatos();
            lista_motores.add(nuevo);
            return "Motor registrado exitosamente | Serie: " + numero_serie + " | Tipo: " + tipo_motor;
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    public String enviar_datos_motor() {
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

    public String eliminar_motor(String numero_serie) {
        for (int i = 0; i < lista_motores.size(); i++) {
            if (lista_motores.get(i).getNumero_serie().equalsIgnoreCase(numero_serie)) {
                lista_motores.remove(i);
                return "Motor eliminado: " + numero_serie;
            }
        }
        return "No se encontró un motor con serie: " + numero_serie;
    }

    public String actualizar_motor(String tipo_motor, String numero_serie, String cilindraje, String extra) {
        for (motor_modelo m : lista_motores) {
            if (m.getNumero_serie().equalsIgnoreCase(numero_serie)) {
                int cil = 0;
                try {
                    cil = Integer.parseInt(cilindraje.trim());
                } catch (NumberFormatException e) {
                    return "Error: No se pudo actualizar el motor (cilindraje debe ser número entero).";
                }
                try {
                    motor_modelo temp = new motor_modelo(cil, tipo_motor, numero_serie);
                    temp.validardatos();
                    m.setTipo_motor(tipo_motor);
                    m.setCilindraje(cil);
                    return "Motor actualizado exitosamente: " + numero_serie + " | Tipo: " + tipo_motor;
                } catch (IllegalArgumentException e) {
                    return e.getMessage();
                }
            }
        }
        return "No se encontró un motor con serie: " + numero_serie;
    }

    // ==========================================
    // PASAJEROS
    // ==========================================
    public String tomar_datos_pasajero(String nombre, String apellido, String cedula, String telefono) {
        try {
            pasajero_modelo nuevo = new pasajero_modelo(nombre, apellido, cedula, telefono);
            nuevo.validardatos();
            lista_pasajeros.add(nuevo);
            return "Pasajero registrado exitosamente: " + nombre + " " + apellido + " | Cédula: " + cedula;
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    public String enviar_datos_pasajero() {
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

    public String actualizar_pasajero(String nombre, String apellido, String cedula, String telefono) {
        for (pasajero_modelo p : lista_pasajeros) {
            if (p.getCedula_pasajero().equals(cedula)) {
                try {
                    pasajero_modelo temp = new pasajero_modelo(nombre, apellido, cedula, telefono);
                    temp.validardatos();
                    p.setNombre_pasajero(nombre);
                    p.setApellido_pasajero(apellido);
                    p.setTelefono_pasajero(telefono);
                    return "Pasajero actualizado exitosamente: " + nombre + " " + apellido + " | Cédula: " + cedula;
                } catch (IllegalArgumentException e) {
                    return e.getMessage();
                }
            }
        }
        return "No se encontró un pasajero con cédula: " + cedula;
    }

    // ==========================================
    // VIAJES
    // ==========================================
    
    public String registrar_viaje(String placa, String numero_serie, String cedula_chofer, String cedula_pasajero) {
        carro_modelo carroEncontrado = null;
        for (carro_modelo c : lista_carros) {
            if (c.getPlaca().equalsIgnoreCase(placa)) {
                carroEncontrado = c;
                break;
            }
        }
        
        motor_modelo motorEncontrado = null;
        for (motor_modelo m : lista_motores) {
            if (m.getNumero_serie().equalsIgnoreCase(numero_serie)) {
                motorEncontrado = m;
                break;
            }
        }
        
        chofer_modelo choferEncontrado = null;
        for (chofer_modelo ch : lista_choferes) {
            if (ch.getCedula_chofer().equalsIgnoreCase(cedula_chofer)) {
                choferEncontrado = ch;
                break;
            }
        }
        
        pasajero_modelo pasajeroEncontrado = null;
        for (pasajero_modelo p : lista_pasajeros) {
            if (p.getCedula_pasajero().equalsIgnoreCase(cedula_pasajero)) {
                pasajeroEncontrado = p;
                break;
            }
        }
        
        if (carroEncontrado == null || motorEncontrado == null || choferEncontrado == null || pasajeroEncontrado == null) {
            return "Error: Uno o más componentes no existen en el sistema. Asegúrese de que la placa, serie y cédulas estén registradas.";
        }
        
        try {
            registro_viaje_modelo nuevoViaje = new registro_viaje_modelo(carroEncontrado, motorEncontrado, choferEncontrado, pasajeroEncontrado);
            nuevoViaje.validardatos();
            lista_viajes.add(nuevoViaje);
            return "Viaje registrado exitosamente con la información proporcionada.";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    public String enviar_datos_viajes() {
        if (lista_viajes.isEmpty()) {
            return "No hay viajes registrados.";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lista_viajes.size(); i++) {
            registro_viaje_modelo v = lista_viajes.get(i);
            sb.append("--- Viaje ").append(i + 1).append(" ---\n");
            sb.append("Carro (Placa) : ").append(v.getCarro().getPlaca()).append("\n");
            sb.append("Motor (Serie) : ").append(v.getMotor().getNumero_serie()).append("\n");
            sb.append("Chofer (CI)   : ").append(v.getChofer().getCedula_chofer()).append(" - ").append(v.getChofer().getNombre_chofer()).append("\n");
            sb.append("Pasajero (CI) : ").append(v.getPasajero().getCedula_pasajero()).append(" - ").append(v.getPasajero().getNombre_pasajero()).append("\n");
        }
        return sb.toString().trim();
    }
}
