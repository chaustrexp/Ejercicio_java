package Controlador;


import Controlador.controlador_carro;
import Controlador.controlador_chofer;
import Controlador.controlador_motor;
import Controlador.controlador_pasajero;


public class controlador_general {

    controlador_carro ctrl_carro;
    controlador_chofer ctrl_chofer;
    controlador_motor ctrl_motor;
    controlador_pasajero ctrl_pasajero;

    public controlador_general() {
        ctrl_carro = new controlador_carro();
        ctrl_chofer = new controlador_chofer();
        ctrl_motor = new controlador_motor();
        ctrl_pasajero = new controlador_pasajero();
    }

    public String mostrar_todo(){
        String mostrar = "";
        mostrar += "Carros: " + ctrl_carro.enviar_datos() + "\n";
        mostrar += "Choferes: " + ctrl_chofer.enviar_datos() + "\n";
        mostrar += "Motores: " + ctrl_motor.enviar_datos() + "\n";
        mostrar += "Pasajeros: " + ctrl_pasajero.enviar_datos() + "\n";
        return mostrar;
    }

    public String mostrar_carros() {
        String mostrar;
        mostrar = "Carros: " + ctrl_carro.enviar_datos();
        return mostrar;
    }

    public String mostrar_choferes() {
        String mostrar;
        mostrar = "Choferes: " + ctrl_chofer.enviar_datos();
        return mostrar;
    }

    public String mostrar_motores() {
        String mostrar;
        mostrar = "Motores: " + ctrl_motor.enviar_datos();
        return mostrar;
    }

    public String mostrar_pasajeros() {
        String mostrar;
        mostrar = "Pasajeros: " + ctrl_pasajero.enviar_datos();
        return mostrar;
    }


    public String enviar_carros(){
        return ctrl_carro.enviar_datos();
    }

    public String enviar_choferes(){
        return ctrl_chofer.enviar_datos();
    }

    public String enviar_motores(){
        return ctrl_motor.enviar_datos();
    }

    public String enviar_pasajeros(){
        return ctrl_pasajero.enviar_datos();
    }

}


