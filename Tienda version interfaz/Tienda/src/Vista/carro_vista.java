package Vista;

import Controlador.controlador_general;
import javax.swing.*;
import java.awt.*;

public class carro_vista extends JFrame {

    private controlador_general ctrl;

    private JPanel    jPanel1;
    private JLabel    jLabel1, jLabel2, jLabel3, jLabel4;
    private JTextField jTextField1, jTextField2, jTextField3;
    private JButton   jButton1, jButton2, jButton3, jButton4, jButton5;
    private JTextArea jTextArea1;

    public carro_vista() {
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
        setTitle("Gestión de Carros");
        setResizable(false);

        // ── Fondo azul ──
        jPanel1.setBackground(new Color(70, 130, 180));

        // ── Título ──
        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 22));
        jLabel1.setForeground(Color.WHITE);
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Gestión de Carros");

        // ── Etiquetas ──
        Font fuenteLabels = new Font("Segoe UI", Font.PLAIN, 14);
        jLabel2.setFont(fuenteLabels); jLabel2.setForeground(Color.WHITE); jLabel2.setText("Marca");
        jLabel3.setFont(fuenteLabels); jLabel3.setForeground(Color.WHITE); jLabel3.setText("Placa");
        jLabel4.setFont(fuenteLabels); jLabel4.setForeground(Color.WHITE); jLabel4.setText("Modelo");

        // ── Bordes modernos para campos ──
        javax.swing.border.Border bordePlano   = BorderFactory.createLineBorder(new Color(200, 200, 200), 1);
        javax.swing.border.Border margenInterno = BorderFactory.createEmptyBorder(5, 7, 5, 7);
        javax.swing.border.Border bordeFinal   = BorderFactory.createCompoundBorder(bordePlano, margenInterno);

        jTextField1.setBorder(bordeFinal);
        jTextField2.setBorder(bordeFinal);
        jTextField3.setBorder(bordeFinal);

        // ── Botones ──
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

        // ── Área de resultado ──
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(jTextArea1);

        // ── Acciones ──
        jButton1.addActionListener(e ->
            jTextArea1.setText(ctrl.tomar_datos_carro(jTextField1.getText(), jTextField2.getText(), jTextField3.getText())));
        jButton2.addActionListener(e ->
            jTextArea1.setText(ctrl.enviar_datos_carro()));
        jButton3.addActionListener(e -> {
            String p = jTextField2.getText().trim();
            jTextArea1.setText(p.isEmpty() ? "Ingrese la placa para buscar." : ctrl.buscar_carro(p));
        });
        jButton4.addActionListener(e -> {
            String p = jTextField2.getText().trim();
            jTextArea1.setText(p.isEmpty() ? "Ingrese la placa para actualizar." :
                ctrl.actualizar_carro(jTextField1.getText(), p, jTextField3.getText()));
        });
        jButton5.addActionListener(e -> {
            String p = jTextField2.getText().trim();
            jTextArea1.setText(p.isEmpty() ? "Ingrese la placa para eliminar." : ctrl.eliminar_carro(p));
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
                            .addComponent(jLabel2, 140, 140, 140)
                            .addComponent(jLabel3, 140, 140, 140)
                            .addComponent(jLabel4, 140, 140, 140))
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
                    .addComponent(scroll, 460, 460, 460))
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
