package Modelo;

public class carro_modelo {

    private String marca = "";
    private String placa = "";
    private String modelo = "";

    // Constructor
    public carro_modelo(String dato_marca, String dato_placa,
            String dato_modelo) {
        this.marca = dato_marca;
        this.placa = dato_placa;
        this.modelo = dato_modelo;
    }

    // Validación de datos (Método público para verificar la validez del objeto)

    public boolean validardatos() {
        if (!validar_marca(this.marca)) {
            throw new IllegalArgumentException("Error: La marca debe tener entre 2 y 30 caracteres.");
        }
        if (!validar_placa(this.placa)) {
            throw new IllegalArgumentException("Error: La placa debe ser alfanumérica de 6 o 7 caracteres.");
        }
        if (!validar_modelo(this.modelo)) {
            throw new IllegalArgumentException("Error: El modelo debe tener entre 2 y 25 caracteres.");
        }
        return true;
    }

    // Métodos de validación privados (encapsulados, ocultos desde fuera de la clase)

    private boolean validar_marca(String dato_marca) {
        return dato_marca != null && dato_marca.trim().length() >= 2 && dato_marca.trim().length() <= 30;
    }

    private boolean validar_modelo(String dato_modelo) {
        return dato_modelo != null && dato_modelo.trim().length() >= 2 && dato_modelo.trim().length() <= 25;
    }

    private boolean validar_placa(String dato_placa) {
        return dato_placa != null && dato_placa.trim().matches("[A-Za-z0-9]{6,7}");
    }

    // Getters

    public String getMarca() {
        return marca;
    }



    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    // Setters

    public void setMarca(String marca) {
        if (marca == null || marca.trim().length() < 2 || marca.trim().length() > 30) {
            throw new IllegalArgumentException("Error: La marca debe tener entre 2 y 30 caracteres.");
        }
        this.marca = marca;
    }

    public void setPlaca(String placa) {
        if (placa == null || !placa.trim().matches("[A-Za-z0-9]{6,7}")) {
            throw new IllegalArgumentException("Error: La placa debe ser alfanumérica de 6 o 7 caracteres.");
        }
        this.placa = placa;
    }

    public void setModelo(String modelo) {
        if (modelo == null || modelo.trim().length() < 2 || modelo.trim().length() > 25) {
            throw new IllegalArgumentException("Error: El modelo debe tener entre 2 y 25 caracteres.");
        }
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "marca: " +  marca  + "Placa: " + placa + "Modelo: "
                + modelo;
    }

}