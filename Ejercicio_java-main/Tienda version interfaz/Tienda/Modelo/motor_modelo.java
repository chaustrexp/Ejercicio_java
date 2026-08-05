package Modelo;

public class motor_modelo {

    private int cilindraje = 0;
    private String tipo_motor = "";
    private String numero_serie = "";

    // Constructor
    public motor_modelo(int cilindraje, String tipo_motor, String numero_serie) {
        this.cilindraje = cilindraje;
        this.tipo_motor = tipo_motor;
        this.numero_serie = numero_serie;
    }

    // Validación de datos generales

    public boolean validardatos() {
        return validar_cilindraje(this.cilindraje) && validar_tipo_motor(this.tipo_motor) && validar_numero_serie(this.numero_serie);
    }

    private boolean validar_cilindraje(int cilindraje) {
        if (cilindraje < 500 || cilindraje > 20000) {
            throw new IllegalArgumentException("Error: El cilindraje debe ser mayor a 500 y menor a 20000.");
        }
        return true;
    }

    private boolean validar_tipo_motor(String tipo_motor) {
        if (tipo_motor == null || (!tipo_motor.equalsIgnoreCase("Diesel") &&
                !tipo_motor.equalsIgnoreCase("Gasolina") &&
                !tipo_motor.equalsIgnoreCase("Hibrido") &&
                !tipo_motor.equalsIgnoreCase("Electrico"))) {
            throw new IllegalArgumentException("Error: El tipo de motor es inválido (Diesel, Gasolina, Hibrido, Electrico).");
        }
        return true;
    }

    private boolean validar_numero_serie(String numero_serie) {
        if (numero_serie == null || numero_serie.trim().length() < 10 || numero_serie.trim().length() > 20) {
            throw new IllegalArgumentException("Error: El número de serie debe tener entre 10 y 20 caracteres.");
        }
        return true;
    }

    // Getters

    public int getCilindraje() {
        return cilindraje;
    }

    public String getTipo_motor() {
        return tipo_motor;
    }

    public String getNumero_serie() {
        return numero_serie;
    }

    // Setters

    public void setCilindraje(int cilindraje) {
        validar_cilindraje(cilindraje);
        this.cilindraje = cilindraje;
    }

    public void setTipo_motor(String tipo_motor) {
        validar_tipo_motor(tipo_motor);
        this.tipo_motor = tipo_motor;
    }

    public void setNumero_serie(String numero_serie) {
        validar_numero_serie(numero_serie);
        this.numero_serie = numero_serie;
    }

    @Override
    public String toString() {
        return "Cilindraje: " + cilindraje + " tipo_motor: " + tipo_motor + "Numero_serie: " + numero_serie;
    }
}