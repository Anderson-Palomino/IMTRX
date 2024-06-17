package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.dto.CategoriaDTO;
import modelo.dto.PreguntaDTO;
import servicios.ConexionDB;

public class PreguntaDAO {
    Connection cnx = null;
    ConexionDB cn = new ConexionDB();
    PreparedStatement ps;
    ResultSet rs;
       
    
    public List listar1(){
        List<PreguntaDTO> cat1 = new ArrayList<>();
        String SQL = "SELECT * FROM preguntasfrecuentes WHERE idCategoria='1'";

        try {
            cnx = ConexionDB.obtenerConexion();
            ps = cnx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                PreguntaDTO p1 = new PreguntaDTO();
                p1.setId(rs.getInt(1));
                p1.setPregunta(rs.getString(2));
                p1.setRespuesta(rs.getString(3));
                p1.setCategoria(rs.getInt(4));
                cat1.add(p1);
            }
        } catch (SQLException e) {
        }
        return cat1;
    }
    
    public List listar2(){
        List<PreguntaDTO> cat2 = new ArrayList<>();
        String SQL = "SELECT * FROM preguntasfrecuentes WHERE idCategoria='2'";

        try {
            cnx = ConexionDB.obtenerConexion();
            ps = cnx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                PreguntaDTO p2 = new PreguntaDTO();
                p2.setId(rs.getInt(1));
                p2.setCategoria(rs.getInt(2));
                p2.setPregunta(rs.getString(3));
                p2.setRespuesta(rs.getString(4));
                cat2.add(p2);
            }
        } catch (SQLException e) {
        }
        return cat2;
    }
    
    public List listar3(){
        List<PreguntaDTO> cat3 = new ArrayList<>();
        String SQL = "SELECT * FROM preguntasfrecuentes WHERE idCategoria='3'";

        try {
            cnx = ConexionDB.obtenerConexion();
            ps = cnx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                PreguntaDTO p3 = new PreguntaDTO();
                p3.setId(rs.getInt(1));
                p3.setCategoria(rs.getInt(2));
                p3.setPregunta(rs.getString(3));
                p3.setRespuesta(rs.getString(4));
                cat3.add(p3);
            }
        } catch (SQLException e) {
        }
        return cat3;
    }
    
        public List listar4(){
        List<PreguntaDTO> cat4 = new ArrayList<>();
        String SQL = "SELECT * FROM preguntasfrecuentes WHERE idCategoria='4'";

        try {
            cnx = ConexionDB.obtenerConexion();
            ps = cnx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                PreguntaDTO p4 = new PreguntaDTO();
                p4.setId(rs.getInt(1));
                p4.setCategoria(rs.getInt(2));
                p4.setPregunta(rs.getString(3));
                p4.setRespuesta(rs.getString(4));
                cat4.add(p4);
            }
        } catch (SQLException e) {
        }
        return cat4;
    }
}
