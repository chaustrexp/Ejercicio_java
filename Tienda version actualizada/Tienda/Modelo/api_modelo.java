package Modelo;

import java.util.Scanner;

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

    public void desconexion() {
        System.out.println("Desconexion fallida...");
    }

    public void buscar_chofer(String info_cedula) {
        System.out.println("El cliente si existe...");
    }

    public void conexion() {
        try {
            System.out.println("Conectando a: " + url);
        } catch (Exception e) {
            System.out.println("Error de conexion: " + e.toString());
        }
    }

    public void mostrar_datos_api() {
        System.out.println("Datos de la Api");
        System.out.println("Root: " + root);
        System.out.println("Contraseña: " + contraseña);
        System.out.println("Host: " + host);
        System.out.println("Url: " + url);
    }

    public void menu_api() {
        Scanner obj_teclado = new Scanner(System.in);

        System.out.println("=================================================");
        System.out.println("              MENU API                           ");
        System.out.println("=================================================");
        System.out.println("1. Validar conexion");
        System.out.println("2. Desconexion");
        System.out.println("3. Buscar chofer");
        System.out.println("4. Mostrar datos");
        System.out.println("5. Salir");
        System.out.println("=================================================");
        System.out.print("Ingrese una opcion: ");

        int opcion = Integer.parseInt(obj_teclado.nextLine());

        switch (opcion) {
            case 1:
                validar_conexion();
                break;
            case 2:
                desconexion();
                break;
            case 3:
                System.out.print("Ingrese la cedula del chofer: ");
                String cedula = obj_teclado.nextLine();
                buscar_chofer(cedula);
                break;
            case 4:
                mostrar_datos_api();
                break;
            case 5:
                System.out.println("Saliendo...");
                System.exit(0);
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }

        obj_teclado.close();
    }

    @Override
    public String toString() {
        return "Root: " + root + " | Contraseña: " + contraseña + " | Host: " + host + " | Url: " + url;
    }

    public static void main(String[] args) {
        api_modelo obj_api = new api_modelo("root", "1234567890", "localhost", "http://localhost:8080");
        obj_api.menu_api();
    }
}
