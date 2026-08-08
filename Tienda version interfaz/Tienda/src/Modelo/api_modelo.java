package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class api_modelo {

    private String root       = "";
    private String contraseña = "";
    private String host       = "";
    private String url        = "";

    public api_modelo(String dato_root, String dato_contraseña, String dato_host, String dato_url) {
        this.root       = dato_root;
        this.contraseña = dato_contraseña;
        this.host       = dato_host;
        this.url        = dato_url;
    }

    public boolean validar_conexion() {
        return true; 
    }

    // ==========================================
    // CRUD — CHOFERES
    // ==========================================
    public String agregar_chofer(chofer_modelo nuevo) {
        try {
            nuevo.validardatos();
            Conexion_db db = new Conexion_db();
            Connection con = db.hacerConexion();
            String sql = "INSERT INTO chofer (cedula, nombre, licencia) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nuevo.getCedula_chofer());
            ps.setString(2, nuevo.getNombre_chofer());
            ps.setString(3, nuevo.getLicencia());
            ps.executeUpdate();
            db.cerrarConexion();
            return "Chofer registrado exitosamente: " + nuevo.getNombre_chofer() + " | Cédula: " + nuevo.getCedula_chofer();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String listar_choferes() {
        try {
            Conexion_db db = new Conexion_db();
            Connection con = db.hacerConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM chofer");
            ResultSet rs = ps.executeQuery();
            StringBuilder sb = new StringBuilder();
            int count = 1;
            while (rs.next()) {
                sb.append("--- Chofer ").append(count++).append(" ---\n");
                sb.append("Nombre   : ").append(rs.getString("nombre")).append("\n");
                sb.append("Cédula   : ").append(rs.getString("cedula")).append("\n");
                sb.append("Licencia : ").append(rs.getString("licencia")).append("\n");
            }
            db.cerrarConexion();
            if (sb.length() == 0) return "No hay choferes registrados en la base de datos.";
            return sb.toString().trim();
        } catch (Exception e) {
            return "Error al listar choferes: " + e.getMessage();
        }
    }

    public String buscar_chofer(String cedula) {
        try {
            Conexion_db db = new Conexion_db();
            Connection con = db.hacerConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM chofer WHERE cedula = ?");
            ps.setString(1, cedula);
            ResultSet rs = ps.executeQuery();
            String res = "No se encontró un chofer con cédula: " + cedula;
            if (rs.next()) {
                res = "Nombre   : " + rs.getString("nombre") + "\n"
                    + "Cédula   : " + rs.getString("cedula") + "\n"
                    + "Licencia : " + rs.getString("licencia");
            }
            db.cerrarConexion();
            return res;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public chofer_modelo buscar_chofer_objeto(String cedula) {
        try {
            Conexion_db db = new Conexion_db();
            Connection con = db.hacerConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM chofer WHERE cedula = ?");
            ps.setString(1, cedula);
            ResultSet rs = ps.executeQuery();
            chofer_modelo ch = null;
            if (rs.next()) {
                ch = new chofer_modelo(rs.getString("nombre"), rs.getString("cedula"), rs.getString("licencia"));
            }
            db.cerrarConexion();
            return ch;
        } catch (Exception e) {
            return null;
        }
    }

    public String eliminar_chofer(String cedula) {
        try {
            Conexion_db db = new Conexion_db();
            Connection con = db.hacerConexion();
            PreparedStatement ps = con.prepareStatement("DELETE FROM chofer WHERE cedula = ?");
            ps.setString(1, cedula);
            int filas = ps.executeUpdate();
            db.cerrarConexion();
            if (filas > 0) return "Chofer eliminado correctamente. Cédula: " + cedula;
            return "No se encontró un chofer con cédula: " + cedula;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String actualizar_chofer(String nombre, String cedula, String licencia) {
        try {
            chofer_modelo temp = new chofer_modelo(nombre, cedula, licencia);
            temp.validardatos();
            Conexion_db db = new Conexion_db();
            Connection con = db.hacerConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE chofer SET nombre=?, licencia=? WHERE cedula=?");
            ps.setString(1, nombre);
            ps.setString(2, licencia);
            ps.setString(3, cedula);
            int filas = ps.executeUpdate();
            db.cerrarConexion();
            if (filas > 0) return "Chofer actualizado correctamente. Cédula: " + cedula;
            return "No se encontró un chofer con cédula: " + cedula;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    // ==========================================
    // CRUD — PASAJEROS
    // ==========================================
    public String agregar_pasajero(pasajero_modelo nuevo) {
        try {
            nuevo.validardatos();
            Conexion_db db = new Conexion_db();
            Connection con = db.hacerConexion();
            String sql = "INSERT INTO pasajero (cedula, nombre, apellido, telefono) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nuevo.getCedula_pasajero());
            ps.setString(2, nuevo.getNombre_pasajero());
            ps.setString(3, nuevo.getApellido_pasajero());
            ps.setString(4, nuevo.getTelefono_pasajero());
            ps.executeUpdate();
            db.cerrarConexion();
            return "Pasajero registrado exitosamente.";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String listar_pasajeros() {
        try {
            Conexion_db db = new Conexion_db();
            Connection con = db.hacerConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM pasajero");
            ResultSet rs = ps.executeQuery();
            StringBuilder sb = new StringBuilder();
            int count = 1;
            while (rs.next()) {
                sb.append("--- Pasajero ").append(count++).append(" ---\n");
                sb.append("Nombre   : ").append(rs.getString("nombre")).append("\n");
                sb.append("Apellido : ").append(rs.getString("apellido")).append("\n");
                sb.append("Cédula   : ").append(rs.getString("cedula")).append("\n");
                sb.append("Teléfono : ").append(rs.getString("telefono")).append("\n");
            }
            db.cerrarConexion();
            if (sb.length() == 0) return "No hay pasajeros registrados en la base de datos.";
            return sb.toString().trim();
        } catch (Exception e) {
            return "Error al listar pasajeros: " + e.getMessage();
        }
    }

    public String buscar_pasajero(String cedula) {
        try {
            Conexion_db db = new Conexion_db();
            Connection con = db.hacerConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM pasajero WHERE cedula = ?");
            ps.setString(1, cedula);
            ResultSet rs = ps.executeQuery();
            String res = "No se encontró un pasajero con cédula: " + cedula;
            if (rs.next()) {
                res = "Nombre   : " + rs.getString("nombre") + "\n"
                    + "Apellido : " + rs.getString("apellido") + "\n"
                    + "Cédula   : " + rs.getString("cedula") + "\n"
                    + "Teléfono : " + rs.getString("telefono");
            }
            db.cerrarConexion();
            return res;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public pasajero_modelo buscar_pasajero_objeto(String cedula) {
        try {
            Conexion_db db = new Conexion_db();
            Connection con = db.hacerConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM pasajero WHERE cedula = ?");
            ps.setString(1, cedula);
            ResultSet rs = ps.executeQuery();
            pasajero_modelo p = null;
            if (rs.next()) {
                p = new pasajero_modelo(rs.getString("nombre"), rs.getString("apellido"), rs.getString("cedula"), rs.getString("telefono"));
            }
            db.cerrarConexion();
            return p;
        } catch (Exception e) {
            return null;
        }
    }

    public String eliminar_pasajero(String cedula) {
        try {
            Conexion_db db = new Conexion_db();
            Connection con = db.hacerConexion();
            PreparedStatement ps = con.prepareStatement("DELETE FROM pasajero WHERE cedula = ?");
            ps.setString(1, cedula);
            int filas = ps.executeUpdate();
            db.cerrarConexion();
            if (filas > 0) return "Pasajero eliminado correctamente. Cédula: " + cedula;
            return "No se encontró un pasajero con cédula: " + cedula;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String actualizar_pasajero(String nombre, String apellido, String cedula, String telefono) {
        try {
            pasajero_modelo temp = new pasajero_modelo(nombre, apellido, cedula, telefono);
            temp.validardatos();
            Conexion_db db = new Conexion_db();
            Connection con = db.hacerConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE pasajero SET nombre=?, apellido=?, telefono=? WHERE cedula=?");
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, telefono);
            ps.setString(4, cedula);
            int filas = ps.executeUpdate();
            db.cerrarConexion();
            if (filas > 0) return "Pasajero actualizado correctamente. Cédula: " + cedula;
            return "No se encontró un pasajero con cédula: " + cedula;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    // ==========================================
    // CRUD — CARROS (Base de datos sin límites)
    // ==========================================
    public String agregar_carro(carro_modelo nuevo) {
        try {
            nuevo.validardatos();
            Conexion_db db = new Conexion_db();
            Connection con = db.hacerConexion();
            String sql = "INSERT INTO carro (placa, marca, modelo) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nuevo.getPlaca());
            ps.setString(2, nuevo.getMarca());
            ps.setString(3, nuevo.getModelo());
            ps.executeUpdate();
            db.cerrarConexion();
            return "Carro registrado exitosamente: " + nuevo.getMarca() + " | Placa: " + nuevo.getPlaca();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String listar_carros() {
        try {
            Conexion_db db = new Conexion_db();
            Connection con = db.hacerConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM carro");
            ResultSet rs = ps.executeQuery();
            StringBuilder sb = new StringBuilder("--- Lista de Carros en Base de Datos ---\n");
            int count = 1;
            while (rs.next()) {
                sb.append(count++).append(". ")
                  .append("Marca: ").append(rs.getString("marca"))
                  .append(" | Placa: ").append(rs.getString("placa"))
                  .append(" | Modelo: ").append(rs.getString("modelo")).append("\n");
            }
            db.cerrarConexion();
            if (count == 1) return "No hay carros registrados.";
            return sb.toString().trim();
        } catch (Exception e) {
            return "Error al listar carros: " + e.getMessage();
        }
    }

    public String buscar_carro(String placa) {
        try {
            Conexion_db db = new Conexion_db();
            Connection con = db.hacerConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM carro WHERE placa = ?");
            ps.setString(1, placa);
            ResultSet rs = ps.executeQuery();
            String res = "No se encontró un carro con placa: " + placa;
            if (rs.next()) {
                res = "Marca     : " + rs.getString("marca")  + "\n"
                    + "Placa     : " + rs.getString("placa")  + "\n"
                    + "Modelo    : " + rs.getString("modelo");
            }
            db.cerrarConexion();
            return res;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public carro_modelo buscar_carro_objeto(String placa) {
        try {
            Conexion_db db = new Conexion_db();
            Connection con = db.hacerConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM carro WHERE placa = ?");
            ps.setString(1, placa);
            ResultSet rs = ps.executeQuery();
            carro_modelo c = null;
            if (rs.next()) {
                c = new carro_modelo(rs.getString("marca"), rs.getString("placa"), rs.getString("modelo"));
            }
            db.cerrarConexion();
            return c;
        } catch (Exception e) {
            return null;
        }
    }

    public String eliminar_carro(String placa) {
        try {
            Conexion_db db = new Conexion_db();
            Connection con = db.hacerConexion();
            PreparedStatement ps = con.prepareStatement("DELETE FROM carro WHERE placa = ?");
            ps.setString(1, placa);
            int filas = ps.executeUpdate();
            db.cerrarConexion();
            if (filas > 0) return "Carro eliminado correctamente. Placa: " + placa;
            return "No se encontró un carro con placa: " + placa;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String actualizar_carro(String marca, String placa, String modelo) {
        try {
            carro_modelo temp = new carro_modelo(marca, placa, modelo);
            temp.validardatos();
            Conexion_db db = new Conexion_db();
            Connection con = db.hacerConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE carro SET marca=?, modelo=? WHERE placa=?");
            ps.setString(1, marca);
            ps.setString(2, modelo);
            ps.setString(3, placa);
            int filas = ps.executeUpdate();
            db.cerrarConexion();
            if (filas > 0) return "Carro actualizado correctamente. Placa: " + placa;
            return "No se encontró un carro con placa: " + placa;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    // ==========================================
    // CRUD — MOTORES (Base de datos sin límites)
    // ==========================================
    public String agregar_motor(motor_modelo nuevo) {
        try {
            nuevo.validardatos();
            Conexion_db db = new Conexion_db();
            Connection con = db.hacerConexion();
            String sql = "INSERT INTO motor (numero_serie, tipo, cilindraje) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nuevo.getNumero_serie());
            ps.setString(2, nuevo.getTipo_motor());
            ps.setInt(3, nuevo.getCilindraje());
            ps.executeUpdate();
            db.cerrarConexion();
            return "Motor registrado exitosamente: " + nuevo.getTipo_motor() + " | Serie: " + nuevo.getNumero_serie();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String listar_motores() {
        try {
            Conexion_db db = new Conexion_db();
            Connection con = db.hacerConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM motor");
            ResultSet rs = ps.executeQuery();
            StringBuilder sb = new StringBuilder("--- Lista de Motores en Base de Datos ---\n");
            int count = 1;
            while (rs.next()) {
                sb.append(count++).append(". ")
                  .append("Tipo: ").append(rs.getString("tipo"))
                  .append(" | Serie: ").append(rs.getString("numero_serie"))
                  .append(" | Cilindraje: ").append(rs.getInt("cilindraje")).append("\n");
            }
            db.cerrarConexion();
            if (count == 1) return "No hay motores registrados.";
            return sb.toString().trim();
        } catch (Exception e) {
            return "Error al listar motores: " + e.getMessage();
        }
    }

    public String buscar_motor(String numero_serie) {
        try {
            Conexion_db db = new Conexion_db();
            Connection con = db.hacerConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM motor WHERE numero_serie = ?");
            ps.setString(1, numero_serie);
            ResultSet rs = ps.executeQuery();
            String res = "No se encontró un motor con serie: " + numero_serie;
            if (rs.next()) {
                res = "Tipo       : " + rs.getString("tipo")    + "\n"
                    + "N° Serie   : " + rs.getString("numero_serie")  + "\n"
                    + "Cilindraje : " + rs.getInt("cilindraje");
            }
            db.cerrarConexion();
            return res;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public motor_modelo buscar_motor_objeto(String numero_serie) {
        try {
            Conexion_db db = new Conexion_db();
            Connection con = db.hacerConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM motor WHERE numero_serie = ?");
            ps.setString(1, numero_serie);
            ResultSet rs = ps.executeQuery();
            motor_modelo m = null;
            if (rs.next()) {
                m = new motor_modelo(rs.getInt("cilindraje"), rs.getString("tipo"), rs.getString("numero_serie"));
            }
            db.cerrarConexion();
            return m;
        } catch (Exception e) {
            return null;
        }
    }

    public String eliminar_motor(String numero_serie) {
        try {
            Conexion_db db = new Conexion_db();
            Connection con = db.hacerConexion();
            PreparedStatement ps = con.prepareStatement("DELETE FROM motor WHERE numero_serie = ?");
            ps.setString(1, numero_serie);
            int filas = ps.executeUpdate();
            db.cerrarConexion();
            if (filas > 0) return "Motor eliminado correctamente. Serie: " + numero_serie;
            return "No se encontró un motor con serie: " + numero_serie;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public String actualizar_motor(String tipo_motor, String numero_serie, int cilindraje) {
        try {
            motor_modelo temp = new motor_modelo(cilindraje, tipo_motor, numero_serie);
            temp.validardatos();
            Conexion_db db = new Conexion_db();
            Connection con = db.hacerConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE motor SET tipo=?, cilindraje=? WHERE numero_serie=?");
            ps.setString(1, tipo_motor);
            ps.setInt(2, cilindraje);
            ps.setString(3, numero_serie);
            int filas = ps.executeUpdate();
            db.cerrarConexion();
            if (filas > 0) return "Motor actualizado correctamente. Serie: " + numero_serie;
            return "No se encontró un motor con serie: " + numero_serie;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    // ==========================================
    // CRUD — VIAJES 
    // ==========================================
    public String agregar_viaje(registro_viaje_modelo nuevo) {
        try {
            nuevo.validardatos();
            Conexion_db db = new Conexion_db();
            Connection con = db.hacerConexion();
            String sql = "INSERT INTO viaje (placa_carro, serie_motor, cedula_chofer, cedula_pasajero) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nuevo.getCarro().getPlaca());
            ps.setString(2, nuevo.getMotor().getNumero_serie());
            ps.setString(3, nuevo.getChofer().getCedula_chofer());
            ps.setString(4, nuevo.getPasajero().getCedula_pasajero());
            ps.executeUpdate();
            db.cerrarConexion();
            return "Viaje registrado exitosamente en la BD.";
        } catch (Exception e) {
            return "Error al registrar viaje (Verifique que las llaves foráneas existan): " + e.getMessage();
        }
    }

    public String listar_viajes() {
        try {
            Conexion_db db = new Conexion_db();
            Connection con = db.hacerConexion();
            // Realizamos JOIN con las otras tablas para obtener nombres y marcas en vez de solo los IDs
            String sql = "SELECT v.id_viaje, c.marca, c.placa, m.numero_serie, ch.nombre as nombre_chofer, ch.cedula as cedula_chofer, p.nombre as nombre_pasajero, p.cedula as cedula_pasajero "
                       + "FROM viaje v "
                       + "JOIN carro c ON v.placa_carro = c.placa "
                       + "JOIN motor m ON v.serie_motor = m.numero_serie "
                       + "JOIN chofer ch ON v.cedula_chofer = ch.cedula "
                       + "JOIN pasajero p ON v.cedula_pasajero = p.cedula";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            StringBuilder sb = new StringBuilder();
            int count = 1;
            while (rs.next()) {
                sb.append("--- Viaje ").append(count++).append(" (ID: ").append(rs.getInt("id_viaje")).append(") ---\n");
                sb.append("Carro (Placa) : ").append(rs.getString("placa")).append("\n");
                sb.append("Motor (Serie) : ").append(rs.getString("numero_serie")).append("\n");
                sb.append("Chofer (CI)   : ").append(rs.getString("cedula_chofer"))
                  .append(" - ").append(rs.getString("nombre_chofer")).append("\n");
                sb.append("Pasajero (CI) : ").append(rs.getString("cedula_pasajero"))
                  .append(" - ").append(rs.getString("nombre_pasajero")).append("\n");
            }
            db.cerrarConexion();
            if (sb.length() == 0) return "No hay viajes registrados.";
            return sb.toString().trim();
        } catch (Exception e) {
            return "Error al listar viajes: " + e.getMessage();
        }
    }

}
