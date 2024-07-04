package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.dto.ProductoDTO;
import servicios.ConexionDB;

public class ProductosDAO {

    // Obtiene un producto por su ID
    public ProductoDTO listarId(int id) {
        String sql = "SELECT * FROM producto WHERE idProducto = ?";
        ProductoDTO producto = null;
        
        try (Connection conexion = obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    producto = mapearProducto(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Mejorar esto con un logger en aplicaciones reales
        }
        
        return producto;
    }

    // para resumir esto categorizar ademas de poder obtener los productos y mandarlos al jasper y que los retorne, es necesario refactorizar algunos modelos para que quede con el jasper y el chatbot
    public List<ProductoDTO> listarPorCategoria(String categoria) {
        String sql = "SELECT * FROM producto WHERE Categoria = ?";
        List<ProductoDTO> productos = new ArrayList<>();
        
        try (Connection conexion = obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, categoria);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    productos.add(mapearProducto(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        
        return productos;
    }

    public List<ProductoDTO> listarPLM() {
        return listarPorCategoria("placamadre");
    }

    public List<ProductoDTO> listarCooler() {
        return listarPorCategoria("cooler");
    }

    public List<ProductoDTO> listarMRAM() {
        return listarPorCategoria("memoriaram");
    }

    public List<ProductoDTO> listarAuriculares() {
        return listarPorCategoria("auriculares");
    }

    public List<ProductoDTO> listarMouses() {
        return listarPorCategoria("mouse");
    }

    public List<ProductoDTO> listarTeclados() {
        return listarPorCategoria("teclado");
    }

    public List<ProductoDTO> listarProsc() {
        return listarPorCategoria("procesador");
    }

    public List<ProductoDTO> listarMonitores() {
        return listarPorCategoria("monitores");
    }

    public List<ProductoDTO> listarAlmac() {
        return listarPorCategoria("almacenamiento");
    }

    public List<ProductoDTO> obtenerCarrito() {
        String sql = "SELECT * FROM producto WHERE enCarrito = 1"; 
        List<ProductoDTO> productosCarrito = new ArrayList<>();
        
        try (Connection conexion = obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                productosCarrito.add(mapearProducto(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productosCarrito;
    }
    private ProductoDTO mapearProducto(ResultSet rs) throws SQLException {
        ProductoDTO producto = new ProductoDTO();
        producto.setIdProducto(rs.getInt("idProducto"));
        producto.setCategoria(rs.getString("Categoria"));
        producto.setNombre(rs.getString("Nombre"));
        producto.setImagen(rs.getString("Imagen"));
        producto.setDescripcion(rs.getString("Descripcion"));
        producto.setPrecio(rs.getDouble("Precio"));
        return producto;
    }
    private Connection obtenerConexion() throws SQLException {
        ConexionDB cdb = new ConexionDB();
        return cdb.obtenerConexion();
    }
}
