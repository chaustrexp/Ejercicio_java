package Modelo;

public class pasajero_modelo {

    private String nombre_pasajero = "";
    private String apellido_pasajero = "";
    private String cedula_pasajero = "";
    private String telefono_pasajero = "";

    // Constructor
    public pasajero_modelo(String nombre_pasajero, String apellido_pasajero, String cedula_pasajero,
            String telefono_pasajero) {
        this.nombre_pasajero = nombre_pasajero;
        this.apellido_pasajero = apellido_pasajero;
        this.cedula_pasajero = cedula_pasajero;
        this.telefono_pasajero = telefono_pasajero;
    }

    // Validacion de datos
    public boolean validardatos() {
        return validar_nombre() && validar_apellido() && validar_cedula() && validar_telefono();
    }

    private boolean validar_nombre() {
        if (nombre_pasajero == null || nombre_pasajero.trim().length() < 2 || nombre_pasajero.trim().length() > 20) {
            System.out.println("Error: El nombre debe tener entre 2 y 20 caracteres");
            return false;
        }
        System.out.println("El nombre es valido");
        return true;
    }

    private boolean validar_apellido() {
        if (apellido_pasajero == null || apellido_pasajero.trim().length() < 2 || apellido_pasajero.trim().length() > 20) {
            System.out.println("Error: El apellido debe tener entre 2 y 20 caracteres");
            return false;
        }
        System.out.println("El apellido es valido");
        return true;
    }

    private boolean validar_cedula() {
        if (cedula_pasajero == null || !cedula_pasajero.trim().matches("[0-9]{10}")) {
            System.out.println("Error: La cedula es invalida (debe ser numérica de 10 dígitos)");
            return false;
        }
        System.out.println("La cedula es valida");
        return true;
    }

    private boolean validar_telefono() {
        if (telefono_pasajero == null || !telefono_pasajero.trim().matches("[0-9]{10}")) {
            System.out.println("Error: El telefono es invalido (debe ser numérico de 10 dígitos)");
            return false;
        }
        System.out.println("El telefono es valido");
        return true;
    }

    // Getters
    public String getNombre_pasajero() {
        return nombre_pasajero;
    }

    public String getApellido_pasajero() {
        return apellido_pasajero;
    }

    public String getCedula_pasajero() {
        return cedula_pasajero;
    }

    public String getTelefono_pasajero() {
        return telefono_pasajero;
    }

    // Setters
    public void setNombre_pasajero(String nombre_pasajero) {
        if (nombre_pasajero == null || !nombre_pasajero.trim().matches("[A-Za-zÁÉÍÓÚáéíóúñÑ\\s]{2,20}")) {
            System.out.println("Error: El nombre debe tener entre 2 y 20 caracteres y solo letras.");
            return;
        }
        this.nombre_pasajero = nombre_pasajero;
    }

    public void setApellido_pasajero(String apellido_pasajero) {
        if (apellido_pasajero == null || !apellido_pasajero.trim().matches("[A-Za-zÁÉÍÓÚáéíóúñÑ\\s]{2,20}")) {
            System.out.println("Error: El apellido debe tener entre 2 y 20 caracteres y solo letras.");
            return;
        }
        this.apellido_pasajero = apellido_pasajero;
    }

    public void setCedula_pasajero(String cedula_pasajero) {
        if (cedula_pasajero == null || !cedula_pasajero.trim().matches("[0-9]{10}")) {
            System.out.println("Error: La cedula es invalida (debe ser numérica de 10 dígitos).");
            return;
        }
        this.cedula_pasajero = cedula_pasajero;
    }

    public void setTelefono_pasajero(String telefono_pasajero) {
        if (telefono_pasajero == null || !telefono_pasajero.trim().matches("09[0-9]{8}")) {
            System.out.println("Error: El telefono es invalido (debe empezar con 09 y tener 10 dígitos).");
            return;
        }
        this.telefono_pasajero = telefono_pasajero;
    }

    public void buscar_nombre(String nombre_pasajero) {
        System.out.println("El nombre del pasajero es: " + nombre_pasajero);
    }

    public void buscar_apellido(String apellido_pasajero) {
        System.out.println("El apellido del pasajero es: " + apellido_pasajero);
    }

    public void buscar_cedula(String cedula_pasajero) {
        System.out.println("La cedula del pasajero es: " + cedula_pasajero);
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre_pasajero + " Apellido: " + apellido_pasajero + " Cedula: " + cedula_pasajero
                + " Telefono: " + telefono_pasajero;
    }
}
