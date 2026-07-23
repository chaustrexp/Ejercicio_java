package Vista;

import Controlador.controlador_chofer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class chofer_vista extends JFrame {

    // Componentes de la interfaz
    private JTextField txtNombre, txtCedula, txtLicencia;
    private JTextArea txtResultado;
    private JButton btnRegistrar, btnMostrar, btnEliminar, btnActualizar, btnBuscar, btnRegresar;
    private controlador_chofer obj_controlador;

    public chofer_vista() {
        // Inicializar controlador
        obj_controlador = new controlador_chofer();

        // Configuración de la ventana (JFrame)
        setTitle("Gestión de Choferes");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana
        setLayout(new BorderLayout(10, 10));

        // --- Panel de Formulario (Arriba) ---
        JPanel panelFormulario = new JPanel(new GridLayout(3, 2, 5, 5));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Datos del Chofer"));

        panelFormulario.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);

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

        panelFormulario.add(new JLabel("Licencia:"));
        txtLicencia = new JTextField();
        panelFormulario.add(txtLicencia);

        // --- Panel de Botones (Centro) ---
        JPanel panelBotones = new JPanel(new FlowLayout());
        btnRegistrar = new JButton("Registrar");
        btnMostrar = new JButton("Mostrar Todos");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnBuscar     = new JButton("Buscar por Cédula");
        btnRegresar   = new JButton("Regresar");

        panelBotones.add(btnRegistrar);
        panelBotones.add(btnMostrar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnBuscar);
        panelBotones.add(btnRegresar);

        // --- Panel de Resultados (Abajo) ---
        JPanel panelResultado = new JPanel(new BorderLayout());
        panelResultado.setBorder(BorderFactory.createTitledBorder("Consola de Salida / Resultados"));
        txtResultado = new JTextArea();
        txtResultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtResultado);
        panelResultado.add(scroll, BorderLayout.CENTER);

        // Agregar paneles principales a la ventana
        add(panelFormulario, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
        add(panelResultado, BorderLayout.SOUTH);
        
        // Ajustar el tamaño del panel de resultados preferido
        panelResultado.setPreferredSize(new Dimension(580, 200));

        // Asignar eventos a los botones
        configurarEventos();
        boton_regreso();
    }

    private void configurarEventos() {
        
        // Evento Registrar
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String cedula = txtCedula.getText();
                String licencia = txtLicencia.getText();

                String info = obj_controlador.tomar_datos_chofer(nombre, cedula, licencia);
                txtResultado.setText(info);
                limpiarCampos();
            }
        });

        // Evento Mostrar
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String info = obj_controlador.enviar_datos();
                txtResultado.setText(info);
            }
        });

        // Evento Eliminar
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedula = txtCedula.getText();
                if(!cedula.isEmpty()) {
                    String info = obj_controlador.eliminar_chofer(cedula);
                    txtResultado.setText(info);
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese la cédula para eliminar.");
                }
            }
        });

        // Evento Actualizar
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String cedula = txtCedula.getText();
                String licencia = txtLicencia.getText();
                
                String info = obj_controlador.actualizar_chofer(nombre, cedula, licencia);
                txtResultado.setText(info);
                limpiarCampos();
            }
        });

        // Evento Buscar
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedula = txtCedula.getText();
                if(!cedula.isEmpty()) {
                    String info = obj_controlador.buscar_chofer(cedula);
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

    private void limpiarCampos() {
        txtNombre.setText("");
        txtCedula.setText("");
        txtLicencia.setText("");
    }

    // Método Main para iniciar la interfaz gráfica
    public static void main(String[] args) {
        // Asegura que la interfaz se ejecute en el hilo de eventos de Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new chofer_vista().setVisible(true);
            }
        });
    }

    
}