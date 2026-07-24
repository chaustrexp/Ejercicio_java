package Modelo;

public class chofer_modelo {
    String nombre_chofer = "";
    String cedula_chofer = "";
    String licencia = "";

    // Constructor
    public chofer_modelo(String nombre_chofer, String cedula_chofer, String licencia) {
        this.nombre_chofer = nombre_chofer;
        this.cedula_chofer = cedula_chofer;
        this.licencia = licencia;

    }

    // Validación de datos generales
    public boolean validardatos() {
        return validar_nombre(this.nombre_chofer) && validar_cedula(this.cedula_chofer)
                && validar_licencia(this.licencia);
    }

    private boolean validar_nombre(String dato_nombre) {
        if (dato_nombre == null || !dato_nombre.trim().matches("[A-Za-zÁÉÍÓÚáéíóúñÑ\\s]{2,30}")) {
            System.out.println("Error: El nombre es inválido (debe contener solo letras entre 2 y 30 caracteres).");
            return false;
        }
        return true;
    }

    private boolean validar_cedula(String dato_cedula) {
        if (dato_cedula == null || !dato_cedula.trim().matches("[0-9]{10}")) {
            System.out.println("Error: La cédula es inválida (debe contener exactamente 10 dígitos numéricos).");
            return false;
        }
        return true;
    }

    private boolean validar_licencia(String dato_licencia) {
        if (dato_licencia == null || !dato_licencia.trim().matches("[A-Za-z0-9]{6,12}")) {
            System.out.println("Error: La licencia es inválida (debe ser alfanumérica de 6 a 12 caracteres).");
            return false;
        }
        return true;
    }

    // Getters
    public String getNombre_chofer() {
        return nombre_chofer;
    }

    public String getCedula_chofer() {
        return cedula_chofer;
    }

    public String getLicencia() {
        return licencia;
    }

    // Setters
    public void setNombre_chofer(String nombre_chofer) {
        if (nombre_chofer == null || !nombre_chofer.trim().matches("[A-Za-zÁÉÍÓÚáéíóúñÑ\\s]{2,30}")) {
            System.out.println("Error: El nombre es inválido (debe contener solo letras entre 2 y 30 caracteres).");
            return;
        }
        this.nombre_chofer = nombre_chofer;
    }

    public void setCedula_chofer(String cedula_chofer) {
        if (cedula_chofer == null || !cedula_chofer.trim().matches("[0-9]{10}")) {
            System.out.println("Error: La cédula es inválida (debe contener exactamente 10 dígitos numéricos).");
            return;
        }
        this.cedula_chofer = cedula_chofer;
    }

    public void setLicencia(String licencia) {
        if (licencia == null || !licencia.trim().matches("[A-Za-z0-9]{6,12}")) {
            System.out.println("Error: La licencia es inválida (debe ser alfanumérica de 6 a 12 caracteres).");
            return;
        }
        this.licencia = licencia;
    }

    public void buscar_licencia(String licencia) {
        System.out.println("La licencia es: " + licencia);
    }

    public void buscar_nombre(String nombre_chofer) {
        System.out.println("El nombre del chofer es: " + nombre_chofer);
    }

    public void buscar_cedula(String cedula_chofer) {
        System.out.println("La cedula del chofer es: " + cedula_chofer);
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre_chofer + " Cedula: " + cedula_chofer + "Licencia: "
                + licencia;
    }
}
