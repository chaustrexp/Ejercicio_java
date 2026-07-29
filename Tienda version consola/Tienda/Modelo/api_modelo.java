package Modelo;

import java.util.List;
import java.util.ArrayList;

public class api_modelo {
    private String root = "";
    private String contraseña = "";
    private String host = "";
    private String url = "";

    // Constructor
    public api_modelo(String dato_root, String dato_contraseña, String dato_host, String dato_url) {
        this.root = dato_root;
        this.contraseña = dato_contraseña;
        this.host = dato_host;
        this.url = dato_url;
        
        // Inicialización de estructuras
        this.listaChoferes = new ArrayList<>();
        this.listaPasajeros = new ArrayList<>();
        this.matrizCarros = new carro_modelo[3][3];
        this.matrizMotores = new motor_modelo[3][3];
    }

    // Getters
    public String getRoot() {
        return root;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getHost() {
        return host;
    }

    public String getUrl() {
        return url;
    }

    // Setters
    public void setRoot(String root) {
        this.root = root;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean validar_conexion() {
        if (this.contraseña.equals("1234567890")) {
            return true;
        } else {
            return false;
        }
    }

    public String desconexion() {
        return "Desconexion fallida...";
    }

    public String buscar_chofer(String info_cedula) {
        return "El cliente si existe...";
    }

    public String conexion() {
        try {
            return "Conectando a: " + url;
        } catch (Exception e) {
            return "Error de conexion: " + e.toString();
        }
    }

    public String obtener_datos_api() {
        return "Datos de la Api\n" +
               "Root: " + root + "\n" +
               "Contraseña: " + contraseña + "\n" +
               "Host: " + host + "\n" +
               "Url: " + url;
    }

    
    // Estructura dinamicas
    private List<chofer_modelo> listaChoferes;
    private List<pasajero_modelo> listaPasajeros;

    // Estructura estaticas
    private carro_modelo [][] matrizCarros;
    private motor_modelo [][] matrizMotores;

    public  void recorrerChoferes() {
        System.out.println("--- Recorrido Lista de choferes ---");

        for(int i = 0; i< listaChoferes.size(); i++) {
            chofer_modelo choferTemporal = listaChoferes.get(i);
            System.out.println("chofer en indice: " + i + ": " + choferTemporal.toString());
        }
    }


    public void recorrerPasajeros() {
        System.out.println("--- Recorrido Lista de Pasajeros ---");
        for(int i=0 ; i < listaPasajeros.size() ; i++) {
            pasajero_modelo pasajeroTemporal = listaPasajeros.get(i);
            System.out.println("Pasajero en indice: " + i + ": " +pasajeroTemporal.toString());
        }
    }

    

    public void recorreMatrizCarros() {
        System.out.println("--- Recorriendo Matriz de Carros (3x3) ---");
        for(int i = 0; i < 3 ; i++) {
            for(int j = 0; j < 3 ; j++) {
                carro_modelo carroTemporal = matrizCarros[i][j];
                if (carroTemporal != null) {
                    System.out.println("Posición [" + i + "][" + j + "]: " + carroTemporal.toString());
                } else {
                    System.out.println("Posición [" + i + "][" + j + "]: (Vacío)");
                }
            }
        }
    }

    public void recorreMatrizMotores() {
        System.out.println("--- Recorriendo Matriz de Motores (3x3) ---");
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                motor_modelo motorTemporal = matrizMotores[i][j];
                if (motorTemporal != null) {
                    System.out.println("Posición [" + i + "][" + j + "]: " + motorTemporal.toString());
                }else {
                    System.out.println("Posición [" + i + "][" + j + "]: (Vacío)");
                }
            }
        }
    }




    @Override
    public String toString() {
        return "Root: " + root + " | Contraseña: " + contraseña + " | Host: " + host + " | Url: " + url;
    }
}
