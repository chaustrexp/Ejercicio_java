package Vista;

import Controlador.controlador_motor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//clase que implementa la vista de motor, hereda de JFrame
public class motor_vista extends JFrame {

    private JTextField txtTipo, txtSerie, txtCilindraje;
    private JTextArea txtResultado;
    private JButton btnRegistrar, btnMostrar, btnEliminar, btnActualizar, btnBuscar, btnRegresar;
    private controlador_motor obj_controlador;

    //constructor
    public motor_vista() {
        obj_controlador = new controlador_motor();

        setTitle("Gestión de Motores");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panel de formulario
        JPanel panelFormulario = new JPanel(new GridLayout(3, 2, 5, 5));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Datos del Motor"));


        panelFormulario.add(new JLabel("Tipo de Motor:"));
        txtTipo = new JTextField();
        panelFormulario.add(txtTipo);

        panelFormulario.add(new JLabel("Número de Serie:"));
        txtSerie = new JTextField();
        panelFormulario.add(txtSerie);

        panelFormulario.add(new JLabel("Cilindraje:"));
        txtCilindraje = new JTextField();
        txtCilindraje.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Bloquea cualquier tecla que no sea número
                }
            }
        });
        panelFormulario.add(txtCilindraje);

        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        btnRegistrar  = new JButton("Registrar");
        btnMostrar    = new JButton("Mostrar Todos");
        btnActualizar = new JButton("Actualizar");
        btnEliminar   = new JButton("Eliminar");
        btnBuscar     = new JButton("Buscar por Serie");
        btnRegresar   = new JButton("Regresar");

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
                String tipo       = txtTipo.getText();
                String serie      = txtSerie.getText();
                String cilindraje = txtCilindraje.getText();
                String info = obj_controlador.tomar_datos_motor(tipo, serie, cilindraje, "");
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
                String serie = txtSerie.getText();
                if (!serie.isEmpty()) {
                    String info = obj_controlador.eliminar_motor(serie);
                    txtResultado.setText(info);
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese el número de serie para eliminar.");
                }
            }
        });

        //evento actualizar
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipo       = txtTipo.getText();
                String serie      = txtSerie.getText();
                String cilindraje = txtCilindraje.getText();
                String info = obj_controlador.actualizar_motor(tipo, serie, cilindraje, "");
                txtResultado.setText(info);
                limpiarCampos();
            }
        });

        //evento buscar
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String serie = txtSerie.getText();
                if (!serie.isEmpty()) {
                    String info = obj_controlador.buscar_motor(serie);
                    txtResultado.setText(info);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese el número de serie para buscar.");
                }
            }
        });
    }

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
        txtTipo.setText("");
        txtSerie.setText("");
        txtCilindraje.setText("");
    }

    //metodo main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new motor_vista().setVisible(true);
            }
        });
    }

    //boton de regreso
   
}
