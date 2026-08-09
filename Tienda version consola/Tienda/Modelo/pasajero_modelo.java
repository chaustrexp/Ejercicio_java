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
        return validar_nombre(this.nombre_pasajero) && validar_apellido(this.apellido_pasajero) &&
               validar_cedula(this.cedula_pasajero) && validar_telefono(this.telefono_pasajero);
    }

    private boolean validar_nombre(String nombre) {
        if (nombre == null || !nombre.trim().matches("[A-Za-zÁÉÍÓÚáéíóúñÑ\\s]{2,20}")) {
            throw new IllegalArgumentException("Error: El nombre debe tener entre 2 y 20 caracteres y solo letras.");
        }
        return true;
    }

    private boolean validar_apellido(String apellido) {
        if (apellido == null || !apellido.trim().matches("[A-Za-zÁÉÍÓÚáéíóúñÑ\\s]{2,20}")) {
            throw new IllegalArgumentException("Error: El apellido debe tener entre 2 y 20 caracteres y solo letras.");
        }
        return true;
    }

    private boolean validar_cedula(String cedula) {
        if (cedula == null || !cedula.trim().matches("[0-9]{10}")) {
            throw new IllegalArgumentException("Error: La cedula es invalida (debe ser numérica de 10 dígitos).");
        }
        return true;
    }

    private boolean validar_telefono(String telefono) {
        if (telefono == null || !telefono.trim().matches("[0-9]{10}")) {
            throw new IllegalArgumentException("Error: El telefono es invalido (debe ser numérico de 10 dígitos).");
        }
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
        validar_nombre(nombre_pasajero);
        this.nombre_pasajero = nombre_pasajero;
    }

    public void setApellido_pasajero(String apellido_pasajero) {
        validar_apellido(apellido_pasajero);
        this.apellido_pasajero = apellido_pasajero;
    }

    public void setCedula_pasajero(String cedula_pasajero) {
        validar_cedula(cedula_pasajero);
        this.cedula_pasajero = cedula_pasajero;
    }

    public void setTelefono_pasajero(String telefono_pasajero) {
        validar_telefono(telefono_pasajero);
        this.telefono_pasajero = telefono_pasajero;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre_pasajero + " Apellido: " + apellido_pasajero + " Cedula: " + cedula_pasajero
                + " Telefono: " + telefono_pasajero;
    }
}
