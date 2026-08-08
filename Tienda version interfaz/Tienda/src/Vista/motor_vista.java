package Vista;

import Controlador.controlador_general;
import javax.swing.*;
import java.awt.*;

public class motor_vista extends JFrame {

    private controlador_general ctrl;

    private JPanel     jPanel1;
    private JLabel     jLabel1, jLabel2, jLabel3, jLabel4;
    private JTextField jTextField1, jTextField2, jTextField3;
    private JButton    jButton1, jButton2, jButton3, jButton4, jButton5;
    private JTextArea  jTextArea1;

    public motor_vista() {
        this.ctrl = controlador_general.getInstance();
        initComponents();
    }

    private void initComponents() {
        jPanel1     = new JPanel();
        jLabel1     = new JLabel();
        jLabel2     = new JLabel();
        jLabel3     = new JLabel();
        jLabel4     = new JLabel();
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        jButton1    = new JButton();
        jButton2    = new JButton();
        jButton3    = new JButton();
        jButton4    = new JButton();
        jButton5    = new JButton();
        jTextArea1  = new JTextArea(6, 30);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de Motores");
        setResizable(false);

        jPanel1.setBackground(new Color(70, 130, 180));

        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 22));
        jLabel1.setForeground(Color.WHITE);
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Gestión de Motores");

        Font fuenteLabels = new Font("Segoe UI", Font.PLAIN, 14);
        jLabel2.setFont(fuenteLabels); jLabel2.setForeground(Color.WHITE); jLabel2.setText("Tipo (Diesel/Gasolina/Hibrido/Electrico)");
        jLabel3.setFont(fuenteLabels); jLabel3.setForeground(Color.WHITE); jLabel3.setText("Número de Serie (10-20 chars)");
        jLabel4.setFont(fuenteLabels); jLabel4.setForeground(Color.WHITE); jLabel4.setText("Cilindraje (500-20000)");

        javax.swing.border.Border bordePlano    = BorderFactory.createLineBorder(new Color(200, 200, 200), 1);
        javax.swing.border.Border margenInterno = BorderFactory.createEmptyBorder(5, 7, 5, 7);
        javax.swing.border.Border bordeFinal    = BorderFactory.createCompoundBorder(bordePlano, margenInterno);

        jTextField1.setBorder(bordeFinal);
        jTextField2.setBorder(bordeFinal);
        jTextField3.setBorder(bordeFinal);

        String[] textos = {"Registrar", "Mostrar Todos", "Buscar", "Actualizar", "Eliminar"};
        JButton[] bots  = {jButton1, jButton2, jButton3, jButton4, jButton5};
        for (int i = 0; i < bots.length; i++) {
            bots[i].setText(textos[i]);
            bots[i].setBackground(Color.WHITE);
            bots[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            bots[i].setFont(new Font("Segoe UI", Font.BOLD, 13));
            bots[i].setFocusPainted(false);
            bots[i].setBorder(bordePlano);
        }

        jTextArea1.setEditable(false);
        jTextArea1.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(jTextArea1);

        // ── Acciones ──
        jButton1.addActionListener(e ->
            jTextArea1.setText(ctrl.tomar_datos_motor(jTextField1.getText(), jTextField2.getText(), jTextField3.getText(), "")));
        jButton2.addActionListener(e ->
            jTextArea1.setText(ctrl.enviar_datos_motor()));
        jButton3.addActionListener(e -> {
            String s = jTextField2.getText().trim();
            jTextArea1.setText(s.isEmpty() ? "Ingrese el número de serie para buscar." : ctrl.buscar_motor(s));
        });
        jButton4.addActionListener(e -> {
            String s = jTextField2.getText().trim();
            jTextArea1.setText(s.isEmpty() ? "Ingrese el número de serie para actualizar." :
                ctrl.actualizar_motor(jTextField1.getText(), s, jTextField3.getText(), ""));
        });
        jButton5.addActionListener(e -> {
            String s = jTextField2.getText().trim();
            jTextArea1.setText(s.isEmpty() ? "Ingrese el número de serie para eliminar." : ctrl.eliminar_motor(s));
        });

        // ── Layout ──
        GroupLayout gl = new GroupLayout(jPanel1);
        jPanel1.setLayout(gl);

        gl.setHorizontalGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addGroup(gl.createSequentialGroup()
                .addGap(50)
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
                    .addGroup(gl.createSequentialGroup()
                        .addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, 200, 200, 200)
                            .addComponent(jLabel3, 200, 200, 200)
                            .addComponent(jLabel4, 200, 200, 200))
                        .addGap(20)
                        .addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, 250, 250, 250)
                            .addComponent(jTextField2, 250, 250, 250)
                            .addComponent(jTextField3, 250, 250, 250)))
                    .addGroup(gl.createSequentialGroup()
                        .addComponent(jButton1, 120, 120, 120).addGap(10)
                        .addComponent(jButton2, 120, 120, 120).addGap(10)
                        .addComponent(jButton3, 100, 100, 100).addGap(10)
                        .addComponent(jButton4, 110, 110, 110).addGap(10)
                        .addComponent(jButton5, 100, 100, 100))
                    .addComponent(scroll, 470, 470, 470))
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
            .addGap(20)
            .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(jButton1, 38, 38, 38)
                .addComponent(jButton2, 38, 38, 38)
                .addComponent(jButton3, 38, 38, 38)
                .addComponent(jButton4, 38, 38, 38)
                .addComponent(jButton5, 38, 38, 38))
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
