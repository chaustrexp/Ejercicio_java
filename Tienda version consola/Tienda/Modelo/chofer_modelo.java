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
            throw new IllegalArgumentException("Error: El nombre es inválido (debe contener solo letras entre 2 y 30 caracteres).");
        }
        return true;
    }

    private boolean validar_cedula(String dato_cedula) {
        if (dato_cedula == null || !dato_cedula.trim().matches("[0-9]{10}")) {
            throw new IllegalArgumentException("Error: La cédula es inválida (debe contener exactamente 10 dígitos numéricos).");
        }
        return true;
    }

    private boolean validar_licencia(String dato_licencia) {
        if (dato_licencia == null || !dato_licencia.trim().matches("[A-Za-z0-9]{6,12}")) {
            throw new IllegalArgumentException("Error: La licencia es inválida (debe ser alfanumérica de 6 a 12 caracteres).");
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
        validar_nombre(nombre_chofer);
        this.nombre_chofer = nombre_chofer;
    }

    public void setCedula_chofer(String cedula_chofer) {
        validar_cedula(cedula_chofer);
        this.cedula_chofer = cedula_chofer;
    }

    public void setLicencia(String licencia) {
        validar_licencia(licencia);
        this.licencia = licencia;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre_chofer + " Cedula: " + cedula_chofer + "Licencia: "
                + licencia;
    }
}
