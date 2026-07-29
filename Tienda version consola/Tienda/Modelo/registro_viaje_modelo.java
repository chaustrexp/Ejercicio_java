package Modelo;

public class registro_viaje_modelo {
    private carro_modelo carro;
    private motor_modelo motor;
    private chofer_modelo chofer;
    private pasajero_modelo pasajero;

    public registro_viaje_modelo(carro_modelo carro, motor_modelo motor, chofer_modelo chofer, pasajero_modelo pasajero) {
        this.carro = carro;
        this.motor = motor;
        this.chofer = chofer;
        this.pasajero = pasajero;
    }

    public boolean validardatos() {
        if (carro == null || motor == null || chofer == null || pasajero == null) {
            throw new IllegalArgumentException("Error: Faltan datos para completar el registro del viaje.");
        }
        
        carro.validardatos();
        motor.validardatos();
        chofer.validardatos();
        pasajero.validardatos();
        
        return true;
    }

    public carro_modelo getCarro() {
        return carro;
    }

    public void setCarro(carro_modelo carro) {
        this.carro = carro;
    }

    public motor_modelo getMotor() {
        return motor;
    }

    public void setMotor(motor_modelo motor) {
        this.motor = motor;
    }

    public chofer_modelo getChofer() {
        return chofer;
    }

    public void setChofer(chofer_modelo chofer) {
        this.chofer = chofer;
    }

    public pasajero_modelo getPasajero() {
        return pasajero;
    }

    public void setPasajero(pasajero_modelo pasajero) {
        this.pasajero = pasajero;
    }
}
