package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.dto.UsuarioDTO;
import servicios.ConexionDB;

public class UsuarioDAO {
    private final Connection conexion;

    public UsuarioDAO() {
        this.conexion = ConexionDB.obtenerConexion();
    }

    public UsuarioDTO validarUsuario(String correo, String contrasena) {
        UsuarioDTO usuario = null;
        String sql = "SELECT idUsuario, nombre, apellidos, correo,direccion,telefono,contraseña, code FROM usuarios WHERE correo = ? AND contraseña = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, correo);
            ps.setString(2, contrasena);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuario = new UsuarioDTO();
                    usuario.setId(rs.getInt("idUsuario"));
                    usuario.setNombres(rs.getString("nombre"));
                    usuario.setApellidos(rs.getString("apellidos"));
                    usuario.setCorreo(rs.getString("correo"));
                    usuario.setDireccion(rs.getString("direccion"));
                    usuario.setContrasena(rs.getString("contraseña"));
                    usuario.setTelefono(rs.getString("telefono"));
                    usuario.setCode(rs.getString("code"));
                   if (!verificarCorreoVerificado(usuario.getCode())) {
                    System.out.println("El correo electrónico del usuario no está verificado.");
                    usuario = null;
                }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
    public boolean registrarUsuario(UsuarioDTO usuario) {
        System.out.println("Correo ya registrado: " + usuario.getCorreo());
       if (correoExiste(usuario.getCorreo())) {
          return false;
       }
        String query = "INSERT INTO usuarios (nombre, apellidos, correo, contraseña,direccion,telefono,code) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setString(1, usuario.getNombres());
            pstmt.setString(2, usuario.getApellidos());
            pstmt.setString(3, usuario.getCorreo());
            pstmt.setString(4, usuario.getContrasena());
            pstmt.setString(5,usuario.getDireccion());
            pstmt.setString(6,usuario.getTelefono());
            pstmt.setString(7, usuario.getCode());
            int filasAfectadas = pstmt.executeUpdate();
            System.out.println("Usuario registrado: " + usuario.getCorreo());
            return filasAfectadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean correoExiste(String correo) {
        String query = "SELECT correo FROM usuarios WHERE correo = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setString(1, correo);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
  public boolean verificarCorreoVerificado(String code) throws SQLException {
 String sql = "SELECT correo_verificado FROM usuarios WHERE code = ?";
    boolean correoVerificado = false;

    try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
        pstmt.setString(1, code);
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                correoVerificado = rs.getBoolean("correo_verificado");
            } else {
                System.out.println("No se encontró el usuario con el código proporcionado.");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw e;
    }
    return correoVerificado;
}
 public void actualizarCorreoVerificado() throws SQLException {
    String sql = "UPDATE usuarios SET correo_verificado = CASE WHEN code > 0 THEN 1 ELSE 0 END";
    try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
        pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        throw e;
    }
} 
  
}





