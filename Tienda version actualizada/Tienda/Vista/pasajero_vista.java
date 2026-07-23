package Vista;

import Controlador.controlador_pasajero;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//clase que implementa la vista de pasajero, hereda de JFrame
public class pasajero_vista extends JFrame {

    private JTextField txtNombre, txtApellido, txtCedula, txtTelefono;
    private JTextArea txtResultado;
    private JButton btnRegistrar, btnMostrar, btnEliminar, btnActualizar, btnBuscar, btnRegresar;
    private controlador_pasajero obj_controlador;

    //constructor
    public pasajero_vista() {
        obj_controlador = new controlador_pasajero();

        setTitle("Gestión de Pasajeros");
        setSize(600, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Panel de formulario
        JPanel panelFormulario = new JPanel(new GridLayout(4, 2, 5, 5));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Datos del Pasajero"));

        panelFormulario.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel("Apellido:"));
        txtApellido = new JTextField();
        panelFormulario.add(txtApellido);

        panelFormulario.add(new JLabel("Cédula:"));
        txtCedula = new JTextField();
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Bloquea cualquier tecla que no sea número
                }
            }
        });
        panelFormulario.add(txtCedula);

        panelFormulario.add(new JLabel("Teléfono:"));
        txtTelefono = new JTextField();
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Bloquea cualquier tecla que no sea número
                }
            }
        });
        panelFormulario.add(txtTelefono);

        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        btnRegistrar  = new JButton("Registrar");
        btnMostrar    = new JButton("Mostrar Todos");
        btnActualizar = new JButton("Actualizar");
        btnEliminar   = new JButton("Eliminar");
        btnBuscar     = new JButton("Buscar por Cédula");
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

        //evento registrar
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre    = txtNombre.getText();
                String apellido  = txtApellido.getText();
                String cedula    = txtCedula.getText();
                String telefono  = txtTelefono.getText();
                String info = obj_controlador.tomar_datos_pasajero(nombre, apellido, cedula, telefono);
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
                String cedula = txtCedula.getText();
                if (!cedula.isEmpty()) {
                    String info = obj_controlador.eliminar_pasajero(cedula);
                    txtResultado.setText(info);
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese la cédula para eliminar.");
                }
            }
        });

        //evento actualizar
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre   = txtNombre.getText();
                String apellido = txtApellido.getText();
                String cedula   = txtCedula.getText();
                String telefono = txtTelefono.getText();
                String info = obj_controlador.actualizar_pasajero(nombre, apellido, cedula, telefono);
                txtResultado.setText(info);
                limpiarCampos();
            }
        });

        //evento buscar

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedula = txtCedula.getText();
                if (!cedula.isEmpty()) {
                    String info = obj_controlador.buscar_pasajero(cedula);
                    txtResultado.setText(info);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese la cédula para buscar.");
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
        txtNombre.setText("");
        txtApellido.setText("");
        txtCedula.setText("");
        txtTelefono.setText("");
    }

    //metodo main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new pasajero_vista().setVisible(true);
            }
        });
    }

    
}
