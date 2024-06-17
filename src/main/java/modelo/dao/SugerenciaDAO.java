package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.dto.SugerenciaDTO;
import servicios.ConexionDB;

public class SugerenciaDAO {
    private final String INSERT_SQL = "INSERT INTO sugerencias (tipo_documento, nro_documento, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, celular, correo, observaciones, imagen, pedido_consumidor, fecha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public boolean insertarSugerencia(SugerenciaDTO sugerencia) {
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(INSERT_SQL)) {

            stmt.setString(1, sugerencia.getTipoDocumento());
            stmt.setString(2, sugerencia.getNroDocumento());
            stmt.setString(3, sugerencia.getPrimerNombre());
            stmt.setString(4, sugerencia.getSegundoNombre());
            stmt.setString(5, sugerencia.getPrimerApellido());
            stmt.setString(6, sugerencia.getSegundoApellido());
            stmt.setString(7, sugerencia.getCelular());
            stmt.setString(8, sugerencia.getCorreo());
            stmt.setString(9, sugerencia.getObservaciones());
            stmt.setBytes(10, sugerencia.getImagen());
            stmt.setString(11, sugerencia.getPedidoConsumidor());
            stmt.setTimestamp(12, sugerencia.getFecha());

            int filasInsertadas = stmt.executeUpdate();
            return filasInsertadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}

