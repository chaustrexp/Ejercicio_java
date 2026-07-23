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
        return validar_marca(this.marca) && validar_placa(this.placa) && validar_modelo(this.modelo);
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
            System.out.println("Error: La marca debe tener entre 2 y 30 caracteres.");
            return;
        }
        this.marca = marca;
    }

    public void setPlaca(String placa) {
        if (placa == null || !placa.trim().matches("[A-Za-z0-9]{6,7}")) {
            System.out.println("Error: La placa debe ser alfanumérica de 6 o 7 caracteres.");
            return;
        }
        this.placa = placa;
    }

    public void setModelo(String modelo) {
        if (modelo == null || modelo.trim().length() < 2 || modelo.trim().length() > 25) {
            System.out.println("Error: El modelo debe tener entre 2 y 25 caracteres.");
            return;
        }
        this.modelo = modelo;
    }

    public void buscar_placa(String chofer_asignado) {
        // buscar consulta
        System.out.println("Ingrese la placa que desea buscar: ");
    }

    public void buscar_modelo(String dato_modelo) {
        System.out.println("El modelo del carro es: " + dato_modelo);
    }

    public void buscar_marca(String dato_marca) {
        System.out.println("La marca del carro es: " + dato_marca);
    }

    @Override
    public String toString() {
        return "marca: " +  marca  + "Placa: " + placa + "Modelo: "
                + modelo;
    }

}