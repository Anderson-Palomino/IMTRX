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
        String sql = "SELECT id, nombres, apellidos, correo,direcion,telefono,contraseña, code FROM usuarios WHERE correo = ? AND contrasena = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, correo);
            ps.setString(2, contrasena);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuario = new UsuarioDTO();
                    usuario.setId(rs.getInt("id"));
                    usuario.setNombres(rs.getString("nombres"));
                    usuario.setApellidos(rs.getString("apellidos"));
                    usuario.setCorreo(rs.getString("correo"));
                    usuario.setDireccion(rs.getString("direcion"));
                    usuario.setContrasena(rs.getString("contrasena"));
                    usuario.setTelefono(rs.getString("Telefono"));
                    usuario.setCode(rs.getString("code"));
                   // if (esCorreoVerificado(usuario.getCode())) {
                    //    System.out.println("El correo del usuario está verificado.");
                  //  } else {
                   //     System.out.println("El correo del usuario no está verificado.");
                   // }
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
        String query = "INSERT INTO usuarios (nombres, apellidos, correo, contraseña,dirrecion,telefono,code) VALUES (?, ?, ?, ?, ?, ?, ?)";
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
    public boolean esCorreoVerificado(String code) throws SQLException {
        String sql = "SELECT correo_verificar FROM usuario WHERE code = ?";
        boolean correoVerificado = false;

        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, code);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    correoVerificado = rs.getInt("correo_verificar") == 1;
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
}





