package Vista;

import Controlador.controlador_carro;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//clase que implementa la vista de carro, hereda de JFrame
public class carro_vista extends JFrame {

    private JTextField txtMarca, txtPlaca, txtModelo;
    private JTextArea txtResultado;
    private JButton btnRegistrar, btnMostrar, btnEliminar, btnActualizar, btnBuscar, btnRegresar;

    //objeto controlador
    private controlador_carro obj_controlador;

    public carro_vista() {
        obj_controlador = new controlador_carro();

        setTitle("Gestión de Carros");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panel de formulario
        JPanel panelFormulario = new JPanel(new GridLayout(3, 2, 5, 5));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Datos del Carro"));

        panelFormulario.add(new JLabel("Marca:"));
        txtMarca = new JTextField();
        panelFormulario.add(txtMarca);


        panelFormulario.add(new JLabel("Placa:"));
        txtPlaca = new JTextField();
        panelFormulario.add(txtPlaca);

        panelFormulario.add(new JLabel("Modelo:"));
        txtModelo = new JTextField();
        panelFormulario.add(txtModelo);



        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        btnRegistrar = new JButton("Registrar");
        btnMostrar   = new JButton("Mostrar Todos");
        btnActualizar = new JButton("Actualizar");
        btnEliminar  = new JButton("Eliminar");
        btnBuscar    = new JButton("Buscar por Placa");
        btnRegresar  = new JButton("Regresar");

        panelBotones.add(btnRegistrar);
        panelBotones.add(btnMostrar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnBuscar);
        panelBotones.add(btnRegresar);

        // Panel de resultados
        JPanel panelResultado = new JPanel(new BorderLayout());
        panelResultado.setBorder(BorderFactory.createTitledBorder("Consola de Salida / Resultados"));
        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtResultado);
        panelResultado.add(scroll, BorderLayout.CENTER);
        panelResultado.setPreferredSize(new Dimension(580, 200));

        add(panelFormulario, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
        add(panelResultado, BorderLayout.SOUTH);

        configurarEventos();
        boton_regreso();
    }

    //metodo que configura los eventos de los botones
    private void configurarEventos() {

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String marca      = txtMarca.getText();
                String placa      = txtPlaca.getText();
                String modelo     = txtModelo.getText();
                String info = obj_controlador.tomar_datos_carro(marca, placa, modelo);
                txtResultado.setText(info);
                limpiarCampos();
            }
        });

        //evento mostrar
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String info = obj_controlador.enviar_datos();
                txtResultado.setText(info);
            }
        });

        //evento eliminar
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String placa = txtPlaca.getText();
                if (!placa.isEmpty()) {
                    String info = obj_controlador.eliminar_carro(placa);
                    txtResultado.setText(info);
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese la placa para eliminar.");
                }
            }
        });

        //evento actualizar
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String marca      = txtMarca.getText();
                String placa      = txtPlaca.getText();
                String modelo     = txtModelo.getText();
                String info = obj_controlador.actualizar_carro(marca, placa, modelo);
                txtResultado.setText(info);
                limpiarCampos();
            }
        });

        //evento buscar
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String placa = txtPlaca.getText();
                if (!placa.isEmpty()) {
                    String info = obj_controlador.buscar_carro(placa);
                    txtResultado.setText(info);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese la placa para buscar.");
                }
            }
        });
    }

    //boton de regreso

    private void boton_regreso(){
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // cierra la ventana actual
                // abre la ventana principal
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new Vista.vista_general().setVisible(true);
                    }
                });
            }
        });
    }

    //metodo que limpia los campos del formulario
    private void limpiarCampos() {
        txtMarca.setText("");
        txtPlaca.setText("");
        txtModelo.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new carro_vista().setVisible(true);
            }
        });
    }

    
}
