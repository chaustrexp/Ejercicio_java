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
        return validar_cilindraje() && validar_tipo_motor() && validar_numero_serie();
    }

    private boolean validar_cilindraje() {
        if (cilindraje < 500 || cilindraje > 20000) {
            System.out.println("Error: El cilindraje debe ser mayor a 500 y menor a 20000");
            return false;
        }
        System.out.println("El cilindraje es válido");
        return true;
    }

    private boolean validar_tipo_motor() {
        if (tipo_motor != null && (tipo_motor.equalsIgnoreCase("Diesel") ||
                tipo_motor.equalsIgnoreCase("Gasolina") ||
                tipo_motor.equalsIgnoreCase("Hibrido") ||
                tipo_motor.equalsIgnoreCase("Electrico"))) {
            System.out.println("El tipo de motor es válido");
            return true;
        }
        System.out.println("Error: El tipo de motor es inválido");
        return false;
    }

    private boolean validar_numero_serie() {
        if (numero_serie == null || numero_serie.trim().length() < 10 || numero_serie.trim().length() > 20) {
            System.out.println("Error: El número de serie debe tener entre 10 y 20 caracteres");
            return false;
        }
        System.out.println("El número de serie es válido");
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
        this.cilindraje = cilindraje;
    }

    public void setTipo_motor(String tipo_motor) {
        this.tipo_motor = tipo_motor;
    }

    public void setNumero_serie(String numero_serie) {
        this.numero_serie = numero_serie;
    }

    public void buscar_numero_serie(String numero_serie) {
        System.out.println("El numero de serie es: " + numero_serie);
    }

    public void buscar_tipo_motor(String tipo_motor) {
        System.out.println("El tipo de motor es: " + tipo_motor);
    }

    @Override
    public String toString() {
        return "Cilindraje: " + cilindraje + " tipo_motor: " + tipo_motor + "Numero_serie: " + numero_serie;
    }
}