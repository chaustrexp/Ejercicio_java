package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {

    Connection conex;
    String url = "tu url";
    String usuario = "root";
    String clave = "";

    public Conexion() {
        this.conex = null;

        try {
            conex = DriverManager.getConnection(this.url, this.usuario, this.clave);
            System.out.println("Conexion exitosa...");
        } catch (SQLException e) {
            System.out.println("Error:: " + e);
        }
    }

    public void consultarInfo() throws SQLException {
        String textoSql = "SELECT * FROM estudiantes";
        PreparedStatement consulta = this.conex.prepareStatement(textoSql);

        ResultSet resultado = consulta.executeQuery();
        System.out.println(resultado.toString());
        System.out.println("Se ejecuto metodo de Consultar Informacion");
    }

}
