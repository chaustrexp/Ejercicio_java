package Modelo;

import java.util.List;
import java.util.ArrayList;

public class api_modelo {

    // ==========================================
    // Atributos de conexión
    // ==========================================
    private String root       = "";
    private String contraseña = "";
    private String host       = "";
    private String url        = "";

    // ==========================================
    // Estructuras de datos centrales
    // ==========================================
    // Listas dinámicas
    private List<chofer_modelo>   listaChoferes;
    private List<pasajero_modelo> listaPasajeros;
    private List<registro_viaje_modelo> listaViajes;

    // Matrices estáticas
    private carro_modelo[][]  matrizCarros;
    private motor_modelo [][] matrizMotores;

    // ==========================================
    // Constructor
    // ==========================================
    public api_modelo(String dato_root, String dato_contraseña, String dato_host, String dato_url) {
        this.root       = dato_root;
        this.contraseña = dato_contraseña;
        this.host       = dato_host;
        this.url        = dato_url;

        this.listaChoferes   = new ArrayList<>();
        this.listaPasajeros  = new ArrayList<>();
        this.listaViajes     = new ArrayList<>();
        this.matrizCarros    = new carro_modelo[3][3];
        this.matrizMotores   = new motor_modelo[3][3];
    }

    // ==========================================
    // Getters / Setters de conexión
    // ==========================================
    public String getRoot()       { return root; }
    public String getContraseña() { return contraseña; }
    public String getHost()       { return host; }
    public String getUrl()        { return url; }

    public void setRoot(String root)             { this.root = root; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }
    public void setHost(String host)             { this.host = host; }
    public void setUrl(String url)               { this.url = url; }

    // ==========================================
    // Getters de estructuras (para el controlador)
    // ==========================================
    public List<chofer_modelo>   getListaChoferes()  { return listaChoferes; }
    public List<pasajero_modelo> getListaPasajeros() { return listaPasajeros; }
    public List<registro_viaje_modelo> getListaViajes() { return listaViajes; }
    public carro_modelo[][]  getMatrizCarros()  { return matrizCarros; }
    public motor_modelo [][] getMatrizMotores() { return matrizMotores; }

    // ==========================================
    // Conexión / Validación
    // ==========================================
    public boolean validar_conexion() {
        return this.contraseña.equals("1234567890");
    }

    public String conexion() {
        try {
            return "Conectando a: " + url;
        } catch (Exception e) {
            return "Error de conexion: " + e.toString();
        }
    }

    public String desconexion() {
        return "Desconexion fallida...";
    }

    public String obtener_datos_api() {
        return "Datos de la Api\n" +
               "Root: "      + root      + "\n" +
               "Contraseña: "+ contraseña + "\n" +
               "Host: "      + host      + "\n" +
               "Url: "       + url;
    }

    // ==========================================
    // CRUD — CHOFERES (Lista dinámica)
    // ==========================================
    public String agregar_chofer(chofer_modelo nuevo) {
        try {
            nuevo.validardatos();
            listaChoferes.add(nuevo);
            return "Chofer registrado exitosamente: " + nuevo.getNombre_chofer()
                    + " | Cédula: " + nuevo.getCedula_chofer()
                    + " | Licencia: " + nuevo.getLicencia();
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    public String listar_choferes() {
        if (listaChoferes.isEmpty()) return "No hay choferes registrados.";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listaChoferes.size(); i++) {
            chofer_modelo ch = listaChoferes.get(i);
            sb.append("--- Chofer ").append(i + 1).append(" ---\n");
            sb.append("Nombre   : ").append(ch.getNombre_chofer()).append("\n");
            sb.append("Cédula   : ").append(ch.getCedula_chofer()).append("\n");
            sb.append("Licencia : ").append(ch.getLicencia()).append("\n");
        }
        return sb.toString().trim();
    }

    public String buscar_chofer(String cedula) {
        for (chofer_modelo ch : listaChoferes) {
            if (ch.getCedula_chofer().equals(cedula)) {
                return "Nombre   : " + ch.getNombre_chofer()  + "\n"
                     + "Cédula   : " + ch.getCedula_chofer()  + "\n"
                     + "Licencia : " + ch.getLicencia();
            }
        }
        return "No se encontró un chofer con cédula: " + cedula;
    }

    public chofer_modelo buscar_chofer_objeto(String cedula) {
        for (chofer_modelo ch : listaChoferes) {
            if (ch.getCedula_chofer().equals(cedula)) return ch;
        }
        return null;
    }

    public String eliminar_chofer(String cedula) {
        for (int i = 0; i < listaChoferes.size(); i++) {
            if (listaChoferes.get(i).getCedula_chofer().equals(cedula)) {
                String nombre = listaChoferes.get(i).getNombre_chofer();
                listaChoferes.remove(i);
                return "Chofer eliminado: " + nombre + " | Cédula: " + cedula;
            }
        }
        return "No se encontró un chofer con cédula: " + cedula;
    }

    public String actualizar_chofer(String nombre, String cedula, String licencia) {
        for (chofer_modelo ch : listaChoferes) {
            if (ch.getCedula_chofer().equals(cedula)) {
                try {
                    chofer_modelo temp = new chofer_modelo(nombre, cedula, licencia);
                    temp.validardatos();
                    ch.setNombre_chofer(nombre);
                    ch.setLicencia(licencia);
                    return "Chofer actualizado: " + nombre + " | Cédula: " + cedula;
                } catch (IllegalArgumentException e) {
                    return e.getMessage();
                }
            }
        }
        return "No se encontró un chofer con cédula: " + cedula;
    }

    // ==========================================
    // CRUD — PASAJEROS (Lista dinámica)
    // ==========================================
    public String agregar_pasajero(pasajero_modelo nuevo) {
        try {
            nuevo.validardatos();
            listaPasajeros.add(nuevo);
            return "Pasajero registrado exitosamente: " + nuevo.getNombre_pasajero()
                    + " " + nuevo.getApellido_pasajero()
                    + " | Cédula: " + nuevo.getCedula_pasajero();
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    public String listar_pasajeros() {
        if (listaPasajeros.isEmpty()) return "No hay pasajeros registrados.";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listaPasajeros.size(); i++) {
            pasajero_modelo p = listaPasajeros.get(i);
            sb.append("--- Pasajero ").append(i + 1).append(" ---\n");
            sb.append("Nombre   : ").append(p.getNombre_pasajero()).append("\n");
            sb.append("Apellido : ").append(p.getApellido_pasajero()).append("\n");
            sb.append("Cédula   : ").append(p.getCedula_pasajero()).append("\n");
            sb.append("Teléfono : ").append(p.getTelefono_pasajero()).append("\n");
        }
        return sb.toString().trim();
    }

    public String buscar_pasajero(String cedula) {
        for (pasajero_modelo p : listaPasajeros) {
            if (p.getCedula_pasajero().equals(cedula)) {
                return "Nombre   : " + p.getNombre_pasajero()   + "\n"
                     + "Apellido : " + p.getApellido_pasajero() + "\n"
                     + "Cédula   : " + p.getCedula_pasajero()   + "\n"
                     + "Teléfono : " + p.getTelefono_pasajero();
            }
        }
        return "No se encontró un pasajero con cédula: " + cedula;
    }

    public pasajero_modelo buscar_pasajero_objeto(String cedula) {
        for (pasajero_modelo p : listaPasajeros) {
            if (p.getCedula_pasajero().equals(cedula)) return p;
        }
        return null;
    }

    public String eliminar_pasajero(String cedula) {
        for (int i = 0; i < listaPasajeros.size(); i++) {
            if (listaPasajeros.get(i).getCedula_pasajero().equals(cedula)) {
                String nombre = listaPasajeros.get(i).getNombre_pasajero();
                listaPasajeros.remove(i);
                return "Pasajero eliminado: " + nombre + " | Cédula: " + cedula;
            }
        }
        return "No se encontró un pasajero con cédula: " + cedula;
    }

    public String actualizar_pasajero(String nombre, String apellido, String cedula, String telefono) {
        for (pasajero_modelo p : listaPasajeros) {
            if (p.getCedula_pasajero().equals(cedula)) {
                try {
                    pasajero_modelo temp = new pasajero_modelo(nombre, apellido, cedula, telefono);
                    temp.validardatos();
                    p.setNombre_pasajero(nombre);
                    p.setApellido_pasajero(apellido);
                    p.setTelefono_pasajero(telefono);
                    return "Pasajero actualizado: " + nombre + " " + apellido + " | Cédula: " + cedula;
                } catch (IllegalArgumentException e) {
                    return e.getMessage();
                }
            }
        }
        return "No se encontró un pasajero con cédula: " + cedula;
    }

    // ==========================================
    // CRUD — CARROS (Matriz estática 3x3)
    // ==========================================
    public String agregar_carro(carro_modelo nuevo, int fila, int columna) {
        if (fila < 0 || fila >= 3 || columna < 0 || columna >= 3) {
            return "Error: Posición fuera de rango (fila y columna deben ser 0-2).";
        }
        if (matrizCarros[fila][columna] != null) {
            return "Error: La posición [" + fila + "][" + columna + "] ya está ocupada.";
        }
        try {
            nuevo.validardatos();
            matrizCarros[fila][columna] = nuevo;
            return "Carro registrado en [" + fila + "][" + columna + "]: "
                    + nuevo.getMarca() + " | Placa: " + nuevo.getPlaca();
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    public String listar_carros() {
        StringBuilder sb = new StringBuilder("--- Matriz de Carros (3x3) ---\n");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                carro_modelo c = matrizCarros[i][j];
                if (c != null) {
                    sb.append("[").append(i).append("][").append(j).append("] ")
                      .append("Marca: ").append(c.getMarca())
                      .append(" | Placa: ").append(c.getPlaca())
                      .append(" | Modelo: ").append(c.getModelo()).append("\n");
                } else {
                    sb.append("[").append(i).append("][").append(j).append("] (Vacío)\n");
                }
            }
        }
        return sb.toString().trim();
    }

    public String buscar_carro(String placa) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrizCarros[i][j] != null
                        && matrizCarros[i][j].getPlaca().equalsIgnoreCase(placa)) {
                    carro_modelo c = matrizCarros[i][j];
                    return "Posición [" + i + "][" + j + "]\n"
                         + "Marca     : " + c.getMarca()  + "\n"
                         + "Placa     : " + c.getPlaca()  + "\n"
                         + "Modelo    : " + c.getModelo();
                }
            }
        }
        return "No se encontró un carro con placa: " + placa;
    }

    public carro_modelo buscar_carro_objeto(String placa) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrizCarros[i][j] != null
                        && matrizCarros[i][j].getPlaca().equalsIgnoreCase(placa)) {
                    return matrizCarros[i][j];
                }
            }
        }
        return null;
    }

    public String eliminar_carro(String placa) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrizCarros[i][j] != null
                        && matrizCarros[i][j].getPlaca().equalsIgnoreCase(placa)) {
                    String marca = matrizCarros[i][j].getMarca();
                    matrizCarros[i][j] = null;
                    return "Carro eliminado en [" + i + "][" + j + "]: " + marca + " | Placa: " + placa;
                }
            }
        }
        return "No se encontró un carro con placa: " + placa;
    }

    public String actualizar_carro(String marca, String placa, String modelo) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrizCarros[i][j] != null
                        && matrizCarros[i][j].getPlaca().equalsIgnoreCase(placa)) {
                    try {
                        carro_modelo temp = new carro_modelo(marca, placa, modelo);
                        temp.validardatos();
                        matrizCarros[i][j].setMarca(marca);
                        matrizCarros[i][j].setModelo(modelo);
                        return "Carro actualizado en [" + i + "][" + j + "]: " + marca + " | Placa: " + placa;
                    } catch (IllegalArgumentException e) {
                        return e.getMessage();
                    }
                }
            }
        }
        return "No se encontró un carro con placa: " + placa;
    }

    // ==========================================
    // CRUD — MOTORES (Matriz estática 3x3)
    // ==========================================
    public String agregar_motor(motor_modelo nuevo, int fila, int columna) {
        if (fila < 0 || fila >= 3 || columna < 0 || columna >= 3) {
            return "Error: Posición fuera de rango (fila y columna deben ser 0-2).";
        }
        if (matrizMotores[fila][columna] != null) {
            return "Error: La posición [" + fila + "][" + columna + "] ya está ocupada.";
        }
        try {
            nuevo.validardatos();
            matrizMotores[fila][columna] = nuevo;
            return "Motor registrado en [" + fila + "][" + columna + "]: "
                    + nuevo.getTipo_motor() + " | Serie: " + nuevo.getNumero_serie();
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    public String listar_motores() {
        StringBuilder sb = new StringBuilder("--- Matriz de Motores (3x3) ---\n");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                motor_modelo m = matrizMotores[i][j];
                if (m != null) {
                    sb.append("[").append(i).append("][").append(j).append("] ")
                      .append("Tipo: ").append(m.getTipo_motor())
                      .append(" | Serie: ").append(m.getNumero_serie())
                      .append(" | Cilindraje: ").append(m.getCilindraje()).append("\n");
                } else {
                    sb.append("[").append(i).append("][").append(j).append("] (Vacío)\n");
                }
            }
        }
        return sb.toString().trim();
    }

    public String buscar_motor(String numero_serie) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrizMotores[i][j] != null
                        && matrizMotores[i][j].getNumero_serie().equalsIgnoreCase(numero_serie)) {
                    motor_modelo m = matrizMotores[i][j];
                    return "Posición [" + i + "][" + j + "]\n"
                         + "Tipo       : " + m.getTipo_motor()    + "\n"
                         + "N° Serie   : " + m.getNumero_serie()  + "\n"
                         + "Cilindraje : " + m.getCilindraje();
                }
            }
        }
        return "No se encontró un motor con serie: " + numero_serie;
    }

    public motor_modelo buscar_motor_objeto(String numero_serie) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrizMotores[i][j] != null
                        && matrizMotores[i][j].getNumero_serie().equalsIgnoreCase(numero_serie)) {
                    return matrizMotores[i][j];
                }
            }
        }
        return null;
    }

    public String eliminar_motor(String numero_serie) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrizMotores[i][j] != null
                        && matrizMotores[i][j].getNumero_serie().equalsIgnoreCase(numero_serie)) {
                    matrizMotores[i][j] = null;
                    return "Motor eliminado en [" + i + "][" + j + "]: Serie: " + numero_serie;
                }
            }
        }
        return "No se encontró un motor con serie: " + numero_serie;
    }

    public String actualizar_motor(String tipo_motor, String numero_serie, int cilindraje) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrizMotores[i][j] != null
                        && matrizMotores[i][j].getNumero_serie().equalsIgnoreCase(numero_serie)) {
                    try {
                        motor_modelo temp = new motor_modelo(cilindraje, tipo_motor, numero_serie);
                        temp.validardatos();
                        matrizMotores[i][j].setTipo_motor(tipo_motor);
                        matrizMotores[i][j].setCilindraje(cilindraje);
                        return "Motor actualizado en [" + i + "][" + j + "]: " + tipo_motor + " | Serie: " + numero_serie;
                    } catch (IllegalArgumentException e) {
                        return e.getMessage();
                    }
                }
            }
        }
        return "No se encontró un motor con serie: " + numero_serie;
    }

    // ==========================================
    // CRUD — VIAJES (Lista dinámica)
    // ==========================================
    public String agregar_viaje(registro_viaje_modelo nuevo) {
        try {
            nuevo.validardatos();
            listaViajes.add(nuevo);
            return "Viaje registrado exitosamente.";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    public String listar_viajes() {
        if (listaViajes.isEmpty()) return "No hay viajes registrados.";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listaViajes.size(); i++) {
            registro_viaje_modelo v = listaViajes.get(i);
            sb.append("--- Viaje ").append(i + 1).append(" ---\n");
            sb.append("Carro (Placa) : ").append(v.getCarro().getPlaca()).append("\n");
            sb.append("Motor (Serie) : ").append(v.getMotor().getNumero_serie()).append("\n");
            sb.append("Chofer (CI)   : ").append(v.getChofer().getCedula_chofer())
              .append(" - ").append(v.getChofer().getNombre_chofer()).append("\n");
            sb.append("Pasajero (CI) : ").append(v.getPasajero().getCedula_pasajero())
              .append(" - ").append(v.getPasajero().getNombre_pasajero()).append("\n");
        }
        return sb.toString().trim();
    }

    // ==========================================
    // Recorridos de consola (debug)
    // ==========================================
    public void recorrerChoferes() {
        System.out.println("--- Recorrido Lista de Choferes ---");
        for (int i = 0; i < listaChoferes.size(); i++) {
            System.out.println("Chofer en índice " + i + ": " + listaChoferes.get(i).toString());
        }
    }

    public void recorrerPasajeros() {
        System.out.println("--- Recorrido Lista de Pasajeros ---");
        for (int i = 0; i < listaPasajeros.size(); i++) {
            System.out.println("Pasajero en índice " + i + ": " + listaPasajeros.get(i).toString());
        }
    }

    public void recorreMatrizCarros() {
        System.out.println("--- Recorriendo Matriz de Carros (3x3) ---");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                carro_modelo c = matrizCarros[i][j];
                System.out.println("Posición [" + i + "][" + j + "]: "
                        + (c != null ? c.toString() : "(Vacío)"));
            }
        }
    }

    public void recorreMatrizMotores() {
        System.out.println("--- Recorriendo Matriz de Motores (3x3) ---");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                motor_modelo m = matrizMotores[i][j];
                System.out.println("Posición [" + i + "][" + j + "]: "
                        + (m != null ? m.toString() : "(Vacío)"));
            }
        }
    }

    // ==========================================
    // toString
    // ==========================================
    @Override
    public String toString() {
        return "Root: " + root + " | Contraseña: " + contraseña
                + " | Host: " + host + " | Url: " + url;
    }
}
