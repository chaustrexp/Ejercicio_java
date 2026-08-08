package Vista;

import Controlador.controlador_general;
import javax.swing.*;
import java.awt.*;

public class vista_general extends JFrame {

    private JPanel jPanel1;
    private JLabel jLabel1;
    private JButton btnCarros;
    private JButton btnChoferes;
    private JButton btnMotores;
    private JButton btnPasajeros;
    private JButton btnViajes;

    public vista_general() {
        controlador_general.getInstance();
        initComponents();
    }

    private void initComponents() {
        jPanel1  = new JPanel();
        jLabel1  = new JLabel();
        btnCarros    = new JButton();
        btnChoferes  = new JButton();
        btnMotores   = new JButton();
        btnPasajeros = new JButton();
        btnViajes    = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Gestión de Vehículos");
        setResizable(false);

        // ── Fondo azul del panel ──
        jPanel1.setBackground(new Color(70, 130, 180));

        // ── Título ──
        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 22));
        jLabel1.setForeground(Color.WHITE);
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Sistema de Gestión de Vehículos");

        // ── Estilo compartido de botones ──
        javax.swing.border.Border bordePlano = BorderFactory.createLineBorder(new Color(200, 200, 200), 1);

        JButton[] botones = {btnCarros, btnChoferes, btnMotores, btnPasajeros, btnViajes};
        String[]  textos  = {"Gestión de Carros", "Gestión de Choferes",
                             "Gestión de Motores", "Gestión de Pasajeros", "Gestión de Viajes"};

        for (int i = 0; i < botones.length; i++) {
            botones[i].setText(textos[i]);
            botones[i].setBackground(Color.WHITE);
            botones[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            botones[i].setFont(new Font("Segoe UI", Font.BOLD, 14));
            botones[i].setFocusPainted(false);
            botones[i].setBorder(bordePlano);
        }

        // ── Acciones ──
        btnCarros.addActionListener(e    -> new carro_vista().setVisible(true));
        btnChoferes.addActionListener(e  -> new chofer_vista().setVisible(true));
        btnMotores.addActionListener(e   -> new motor_vista().setVisible(true));
        btnPasajeros.addActionListener(e -> new pasajero_vista().setVisible(true));
        btnViajes.addActionListener(e    -> new registro_viaje_vista().setVisible(true));

        // ── Layout con GroupLayout ──
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);

        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap(60, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCarros,    GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnChoferes,  GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMotores,   GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPasajeros, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnViajes,    GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(60, Short.MAX_VALUE))
        );

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createSequentialGroup()
                .addGap(30)
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGap(30)
                .addComponent(btnCarros,    GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGap(15)
                .addComponent(btnChoferes,  GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGap(15)
                .addComponent(btnMotores,   GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGap(15)
                .addComponent(btnPasajeros, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGap(15)
                .addComponent(btnViajes,    GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGap(30)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }
}
