package Vista;

import Vista.carro_vista;
import Vista.chofer_vista;
import Vista.motor_vista;
import Vista.pasajero_vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vista_general extends JFrame {

    private JButton btnCarros, btnChoferes, btnMotores, btnPasajeros;

    public vista_general() {
        setTitle("Gestión de Vehículos");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 2, 10, 10));

        btnCarros = new JButton("Carros");
        btnChoferes = new JButton("Choferes");
        btnMotores = new JButton("Motores");
        btnPasajeros = new JButton("Pasajeros");

        add(btnCarros);
        add(btnChoferes);
        add(btnMotores);
        add(btnPasajeros);

        configurarEventos();
    }

    private void configurarEventos() {
        btnCarros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new carro_vista().setVisible(true);
            }
        });

        btnChoferes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new chofer_vista().setVisible(true);
            }
        });

        btnMotores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new motor_vista().setVisible(true);
            }
        });

        btnPasajeros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new pasajero_vista().setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new vista_general().setVisible(true);
            }
        });
    }
}