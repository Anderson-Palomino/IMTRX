package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.dto.CategoriaDTO;
import servicios.ConexionDB;

public class CategoriaDAO {
    Connection cnx = null;
    
    public CategoriaDAO() throws SQLException {
        cnx = ConexionDB.obtenerConexion();
    }
    
    public List<CategoriaDTO> getList(){
        PreparedStatement ps;
        ResultSet rs;
        String cadSQL = "SELECT idCategoria,nombre FROM categoria";
        List<CategoriaDTO> lista = null;
        try {
            ps = cnx.prepareStatement(cadSQL);
            rs = ps.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()){
                CategoriaDTO c = new CategoriaDTO(
                rs.getInt("idCategoria"),
                        rs.getString("nombre"));
                lista.add(c);
            }
            rs.close();
        }catch (SQLException ex){
            
        }
        return lista;   
    }
}
