package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.dto.ReclamacionDTO;
import servicios.ConexionDB; // Suponiendo que tengas una clase para gestionar la conexión a la base de datos

public class ReclamacionDAO {

    // Método para insertar una nueva reclamación en la base de datos
        private final String INSERT_SQL = "INSERT INTO reclamacion "
                     + "(fecha, primer_nombre, segundo_nombre, apellido_paterno, apellido_materno, domicilio, "
                     + "departamento, provincia, distrito, dni, telefono, correo, menor, tipo_bien_contratado, "
                     + "monto_reclamo, tipo_reclamo, descripcion, imagen_reclamante, pedido_consumidor, respuesta_direccion) "
                     + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            // Método para insertar una nueva reclamación en la base de datos
    public boolean insertarReclamacion(ReclamacionDTO reclamacion) {

        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(INSERT_SQL)) {

            stmt.setString(1, reclamacion.getFecha());
            stmt.setString(2, reclamacion.getPrimerNombre());
            stmt.setString(3, reclamacion.getSegundoNombre());
            stmt.setString(4, reclamacion.getApellidoPaterno());
            stmt.setString(5, reclamacion.getApellidoMaterno());
            stmt.setString(6, reclamacion.getDomicilio());
            stmt.setString(7, reclamacion.getDepartamento());
            stmt.setString(8, reclamacion.getProvincia());
            stmt.setString(9, reclamacion.getDistrito());
            stmt.setString(10, reclamacion.getDni());
            stmt.setString(11, reclamacion.getTelefono());
            stmt.setString(12, reclamacion.getCorreo());
            stmt.setBoolean(13, reclamacion.isMenor());
            stmt.setString(14, reclamacion.getTipoBienContratado());
            stmt.setDouble(15, reclamacion.getMontoReclamo());
            stmt.setString(16, reclamacion.getTipoReclamo());
            stmt.setString(17, reclamacion.getDescripcion());
            stmt.setString(18, reclamacion.getImagenReclamante());
            stmt.setString(19, reclamacion.getPedidoConsumidor());
            stmt.setBoolean(20, reclamacion.isRespuestaDireccion());

            int filasInsertadas = stmt.executeUpdate();
            return filasInsertadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones (log, lanzar excepción personalizada, etc.)
            return false;
        }
    }
}
