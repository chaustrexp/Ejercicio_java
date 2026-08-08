package Vista;

import Controlador.controlador_general;
import javax.swing.*;
import java.awt.*;

public class registro_viaje_vista extends JFrame {

    private controlador_general ctrl;

    private JPanel     jPanel1;
    private JLabel     jLabel1, jLabel2, jLabel3, jLabel4, jLabel5;
    private JTextField jTextField1, jTextField2, jTextField3, jTextField4;
    private JButton    jButton1, jButton2, jButton3;
    private JTextArea  jTextArea1;

    public registro_viaje_vista() {
        this.ctrl = controlador_general.getInstance();
        initComponents();
    }

    private void initComponents() {
        jPanel1     = new JPanel();
        jLabel1     = new JLabel();
        jLabel2     = new JLabel();
        jLabel3     = new JLabel();
        jLabel4     = new JLabel();
        jLabel5     = new JLabel();
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();
        jButton1    = new JButton();
        jButton2    = new JButton();
        jButton3    = new JButton();
        jTextArea1  = new JTextArea(6, 30);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de Viajes");
        setResizable(false);

        jPanel1.setBackground(new Color(70, 130, 180));

        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 22));
        jLabel1.setForeground(Color.WHITE);
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Registro de Viajes");

        Font fuenteLabels = new Font("Segoe UI", Font.PLAIN, 14);
        jLabel2.setFont(fuenteLabels); jLabel2.setForeground(Color.WHITE); jLabel2.setText("Placa del Carro");
        jLabel3.setFont(fuenteLabels); jLabel3.setForeground(Color.WHITE); jLabel3.setText("Serie del Motor");
        jLabel4.setFont(fuenteLabels); jLabel4.setForeground(Color.WHITE); jLabel4.setText("Cédula del Chofer");
        jLabel5.setFont(fuenteLabels); jLabel5.setForeground(Color.WHITE); jLabel5.setText("Cédula del Pasajero");

        javax.swing.border.Border bordePlano    = BorderFactory.createLineBorder(new Color(200, 200, 200), 1);
        javax.swing.border.Border margenInterno = BorderFactory.createEmptyBorder(5, 7, 5, 7);
        javax.swing.border.Border bordeFinal    = BorderFactory.createCompoundBorder(bordePlano, margenInterno);

        jTextField1.setBorder(bordeFinal);
        jTextField2.setBorder(bordeFinal);
        jTextField3.setBorder(bordeFinal);
        jTextField4.setBorder(bordeFinal);

        jButton1.setText("Registrar Viaje");
        jButton2.setText("Ver Viajes");
        jButton3.setText("Limpiar");

        JButton[] bots = {jButton1, jButton2, jButton3};
        for (JButton b : bots) {
            b.setBackground(Color.WHITE);
            b.setCursor(new Cursor(Cursor.HAND_CURSOR));
            b.setFont(new Font("Segoe UI", Font.BOLD, 14));
            b.setFocusPainted(false);
            b.setBorder(bordePlano);
        }

        jTextArea1.setEditable(false);
        jTextArea1.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(jTextArea1);

        // ── Acciones ──
        jButton1.addActionListener(e -> {
            String placa = jTextField1.getText().trim();
            String serie = jTextField2.getText().trim();
            String cedCh = jTextField3.getText().trim();
            String cedPa = jTextField4.getText().trim();
            if (placa.isEmpty() || serie.isEmpty() || cedCh.isEmpty() || cedPa.isEmpty()) {
                jTextArea1.setText("Por favor complete todos los campos.");
            } else {
                jTextArea1.setText(ctrl.registrar_viaje(placa, serie, cedCh, cedPa));
            }
        });
        jButton2.addActionListener(e -> jTextArea1.setText(ctrl.enviar_datos_viajes()));
        jButton3.addActionListener(e -> {
            jTextField1.setText(""); jTextField2.setText("");
            jTextField3.setText(""); jTextField4.setText("");
            jTextArea1.setText("");
        });

        // ── Layout ──
        GroupLayout gl = new GroupLayout(jPanel1);
        jPanel1.setLayout(gl);

        gl.setHorizontalGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addGroup(gl.createSequentialGroup()
                .addGap(50)
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                    .addGroup(gl.createSequentialGroup()
                        .addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, 160, 160, 160)
                            .addComponent(jLabel3, 160, 160, 160)
                            .addComponent(jLabel4, 160, 160, 160)
                            .addComponent(jLabel5, 160, 160, 160))
                        .addGap(20)
                        .addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, 250, 250, 250)
                            .addComponent(jTextField2, 250, 250, 250)
                            .addComponent(jTextField3, 250, 250, 250)
                            .addComponent(jTextField4, 250, 250, 250)))
                    .addGroup(gl.createSequentialGroup()
                        .addComponent(jButton1, 150, 150, 150).addGap(20)
                        .addComponent(jButton2, 130, 130, 130).addGap(20)
                        .addComponent(jButton3, 110, 110, 110))
                    .addComponent(scroll, 480, 480, 480))
                .addGap(50))
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
            .addGap(30)
            .addComponent(jLabel1, 40, 40, 40)
            .addGap(25)
            .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2).addComponent(jTextField1, 35, 35, 35))
            .addGap(15)
            .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel3).addComponent(jTextField2, 35, 35, 35))
            .addGap(15)
            .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4).addComponent(jTextField3, 35, 35, 35))
            .addGap(15)
            .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel5).addComponent(jTextField4, 35, 35, 35))
            .addGap(20)
            .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1, 40, 40, 40)
                .addComponent(jButton2, 40, 40, 40)
                .addComponent(jButton3, 40, 40, 40))
            .addGap(15)
            .addComponent(scroll, 140, 140, 140)
            .addGap(25)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
        setLocationRelativeTo(null);
    }
}
