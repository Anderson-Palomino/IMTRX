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
        String sql = "SELECT idUsuario, nombres, apellidos, correo, contrasena, code, correo_verificado FROM usuarios WHERE correo = ? AND contrasena = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, correo);
            ps.setString(2, contrasena);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuario = new UsuarioDTO();
                    usuario.setId(rs.getInt("idUsuario"));
                    usuario.setNombres(rs.getString("nombres"));
                    usuario.setApellidos(rs.getString("apellidos"));
                    usuario.setCorreo(rs.getString("correo"));
                    usuario.setContrasena(rs.getString("contrasena"));
                    usuario.setCode(rs.getString("code"));
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

        String query = "INSERT INTO usuarios (nombres, apellidos, correo, contrasena, code) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setString(1, usuario.getNombres());
            pstmt.setString(2, usuario.getApellidos());
            pstmt.setString(3, usuario.getCorreo());
            pstmt.setString(4, usuario.getContrasena());
            pstmt.setString(5, usuario.getCode());
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
}




