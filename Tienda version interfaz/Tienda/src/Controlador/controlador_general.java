package Controlador;

import Modelo.api_modelo;
import Modelo.carro_modelo;
import Modelo.chofer_modelo;
import Modelo.motor_modelo;
import Modelo.pasajero_modelo;
import Modelo.registro_viaje_modelo;

public class controlador_general {

    // ==========================================
    // Singleton
    // ==========================================
    private static controlador_general instance;

    // La api_modelo es la fuente central de datos
    private api_modelo api;

    private controlador_general() {}

    public static controlador_general getInstance() {
        if (instance == null) {
            instance = new controlador_general();
        }
        return instance;
    }

    // ==========================================
    // Inicializar la API (se llama desde Main)
    // ==========================================
    public void inicializar_api(String root, String contraseña, String host, String url) {
        this.api = new api_modelo(root, contraseña, host, url);
    }

    public api_modelo getApi() {
        return api;
    }

    private boolean api_disponible() {
        return api != null;
    }

    // ==========================================
    // CARROS  → delega a api_modelo (Matriz)
    // ==========================================
    public String tomar_datos_carro(String marca, String placa, String modelo) {
        if (!api_disponible()) return "Error: API no inicializada.";
        try {
            carro_modelo nuevo = new carro_modelo(marca, placa, modelo);
            return api.agregar_carro(nuevo);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String enviar_datos_carro() {
        if (!api_disponible()) return "Error: API no inicializada.";
        return api.listar_carros();
    }

    public String buscar_carro(String placa) {
        if (!api_disponible()) return "Error: API no inicializada.";
        return api.buscar_carro(placa);
    }

    public String eliminar_carro(String placa) {
        if (!api_disponible()) return "Error: API no inicializada.";
        return api.eliminar_carro(placa);
    }

    public String actualizar_carro(String marca, String placa, String modelo) {
        if (!api_disponible()) return "Error: API no inicializada.";
        return api.actualizar_carro(marca, placa, modelo);
    }

    // ==========================================
    // CHOFERES  → delega a api_modelo (Lista)
    // ==========================================
    public String tomar_datos_chofer(String nombre, String cedula, String licencia) {
        if (!api_disponible()) return "Error: API no inicializada.";
        chofer_modelo nuevo = new chofer_modelo(nombre, cedula, licencia);
        return api.agregar_chofer(nuevo);
    }

    public String enviar_datos_chofer() {
        if (!api_disponible()) return "Error: API no inicializada.";
        return api.listar_choferes();
    }

    public String buscar_chofer(String cedula) {
        if (!api_disponible()) return "Error: API no inicializada.";
        return api.buscar_chofer(cedula);
    }

    public String eliminar_chofer(String cedula) {
        if (!api_disponible()) return "Error: API no inicializada.";
        return api.eliminar_chofer(cedula);
    }

    public String actualizar_chofer(String nombre, String cedula, String licencia) {
        if (!api_disponible()) return "Error: API no inicializada.";
        return api.actualizar_chofer(nombre, cedula, licencia);
    }

    // ==========================================
    // MOTORES  → delega a api_modelo (Matriz)
    // ==========================================
    public String tomar_datos_motor(String tipo_motor, String numero_serie, String cilindraje, String extra) {
        if (!api_disponible()) return "Error: API no inicializada.";
        int cil;
        try {
            cil = Integer.parseInt(cilindraje.trim());
        } catch (NumberFormatException e) {
            return "Error: El cilindraje debe ser un número entero.";
        }
        try {
            motor_modelo nuevo = new motor_modelo(cil, tipo_motor, numero_serie);
            return api.agregar_motor(nuevo);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String enviar_datos_motor() {
        if (!api_disponible()) return "Error: API no inicializada.";
        return api.listar_motores();
    }

    public String buscar_motor(String numero_serie) {
        if (!api_disponible()) return "Error: API no inicializada.";
        return api.buscar_motor(numero_serie);
    }

    public String eliminar_motor(String numero_serie) {
        if (!api_disponible()) return "Error: API no inicializada.";
        return api.eliminar_motor(numero_serie);
    }

    public String actualizar_motor(String tipo_motor, String numero_serie, String cilindraje, String extra) {
        if (!api_disponible()) return "Error: API no inicializada.";
        int cil;
        try {
            cil = Integer.parseInt(cilindraje.trim());
        } catch (NumberFormatException e) {
            return "Error: El cilindraje debe ser un número entero.";
        }
        return api.actualizar_motor(tipo_motor, numero_serie, cil);
    }

    // ==========================================
    // PASAJEROS  → delega a api_modelo (Lista)
    // ==========================================
    public String tomar_datos_pasajero(String nombre, String apellido, String cedula, String telefono) {
        if (!api_disponible()) return "Error: API no inicializada.";
        pasajero_modelo nuevo = new pasajero_modelo(nombre, apellido, cedula, telefono);
        return api.agregar_pasajero(nuevo);
    }

    public String enviar_datos_pasajero() {
        if (!api_disponible()) return "Error: API no inicializada.";
        return api.listar_pasajeros();
    }

    public String buscar_pasajero(String cedula) {
        if (!api_disponible()) return "Error: API no inicializada.";
        return api.buscar_pasajero(cedula);
    }

    public String eliminar_pasajero(String cedula) {
        if (!api_disponible()) return "Error: API no inicializada.";
        return api.eliminar_pasajero(cedula);
    }

    public String actualizar_pasajero(String nombre, String apellido, String cedula, String telefono) {
        if (!api_disponible()) return "Error: API no inicializada.";
        return api.actualizar_pasajero(nombre, apellido, cedula, telefono);
    }

    // ==========================================
    // VIAJES  → delega a api_modelo (Lista)
    // ==========================================
    public String registrar_viaje(String placa, String numero_serie,
                                  String cedula_chofer, String cedula_pasajero) {
        if (!api_disponible()) return "Error: API no inicializada.";

        carro_modelo   carroEncontrado   = api.buscar_carro_objeto(placa);
        motor_modelo   motorEncontrado   = api.buscar_motor_objeto(numero_serie);
        chofer_modelo  choferEncontrado  = api.buscar_chofer_objeto(cedula_chofer);
        pasajero_modelo pasajeroEncontrado = api.buscar_pasajero_objeto(cedula_pasajero);

        if (carroEncontrado == null || motorEncontrado == null
                || choferEncontrado == null || pasajeroEncontrado == null) {
            return "Error: Uno o más componentes no existen. Verifique placa, serie y cédulas.";
        }

        registro_viaje_modelo nuevo = new registro_viaje_modelo(
                carroEncontrado, motorEncontrado, choferEncontrado, pasajeroEncontrado);
        return api.agregar_viaje(nuevo);
    }

    public String enviar_datos_viajes() {
        if (!api_disponible()) return "Error: API no inicializada.";
        return api.listar_viajes();
    }
}
