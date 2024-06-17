
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.dto.*;
import servicios.ConexionDB;

/**
 *
 * @author ander
 */
public class ProductosDAO {

    Connection conexion;
    ConexionDB cdb = new ConexionDB();
    PreparedStatement ps;
    ResultSet rs;
    
    public ProductoDTO listarId(int id){
        String sql="select * from producto where idProducto="+id;
        ProductoDTO p = new ProductoDTO();
        try {
            conexion=cdb.obtenerConexion();
            ps=conexion.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                p.setIdProducto(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setImagen(rs.getString(3));
                p.setDescripcion(rs.getString(4));
                p.setPrecio(rs.getDouble(5));
            }
        } catch (Exception e) {
        }
        return p;
    }
    
    public List listarPLM() {
        List<ProductoDTO> p = new ArrayList<>();
        String SQL = "SELECT * FROM producto where Categoria='placamadre'";

        try {
            conexion = cdb.obtenerConexion();
            ps = conexion.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductoDTO ai = new ProductoDTO();
                ai.setIdProducto(rs.getInt(1));
                ai.setCategoria(rs.getString(2));
                ai.setNombre(rs.getString(3));
                ai.setImagen(rs.getString(4));
                ai.setDescripcion(rs.getString(5));
                ai.setPrecio(rs.getDouble(6));
                p.add(ai);
            }
        } catch (SQLException e) {
        }
        return p;
    }
    public List listarCooler() {
        List<ProductoDTO> p = new ArrayList<>();
        String SQL = "SELECT * FROM producto where Categoria='cooler'";

        try {
            conexion = cdb.obtenerConexion();
            ps = conexion.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductoDTO ai = new ProductoDTO();
                ai.setIdProducto(rs.getInt(1));
                ai.setCategoria(rs.getString(2));
                ai.setNombre(rs.getString(3));
                ai.setImagen(rs.getString(4));
                ai.setDescripcion(rs.getString(5));
                ai.setPrecio(rs.getDouble(6));
                p.add(ai);
            }
        } catch (SQLException e) {
        }
        return p;
    }

    public List listarMRAM() {
        List<ProductoDTO> p = new ArrayList<>();
        String SQL = "SELECT * FROM producto where Categoria='memoriaram'";
        try {
            conexion = cdb.obtenerConexion();
            ps = conexion.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductoDTO ai = new ProductoDTO();
                ai.setIdProducto(rs.getInt(1));
                ai.setCategoria(rs.getString(2));
                ai.setNombre(rs.getString(3));
                ai.setImagen(rs.getString(4));
                ai.setDescripcion(rs.getString(5));
                ai.setPrecio(rs.getDouble(6));
                p.add(ai);
            }
        } catch (Exception e) {
        }
        return p;
    }

    public List listarAuriculares() {
        List<ProductoDTO> p = new ArrayList<>();
        String SQL = "SELECT * FROM producto where Categoria='auriculares'";

        try {
            conexion = cdb.obtenerConexion();
            ps = conexion.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductoDTO ai = new ProductoDTO();
                ai.setIdProducto(rs.getInt(1));
                ai.setCategoria(rs.getString(2));
                ai.setNombre(rs.getString(3));
                ai.setImagen(rs.getString(4));
                ai.setDescripcion(rs.getString(5));
                ai.setPrecio(rs.getDouble(6));
                p.add(ai);
            }
        } catch (Exception e) {
        }
        return p;
    }

    public List listarMouses() {
        List<ProductoDTO> p = new ArrayList<>();
        String SQL = "SELECT * FROM producto where Categoria='mouse'"; // Ajusta el nombre de la tabla según sea necesario

        try {
            conexion = cdb.obtenerConexion();
            ps = conexion.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductoDTO ai = new ProductoDTO();
                ai.setIdProducto(rs.getInt(1));
                ai.setCategoria(rs.getString(2));
                ai.setNombre(rs.getString(3));
                ai.setImagen(rs.getString(4));
                ai.setDescripcion(rs.getString(5));
                ai.setPrecio(rs.getDouble(6));
                p.add(ai);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Añade manejo de excepciones adecuado
        }
        return p;
    }

    public List listarTeclados() {
        List<ProductoDTO> p = new ArrayList<>();
        String SQL = "SELECT * FROM producto where Categoria='teclado'"; // Ajusta el nombre de la tabla según sea necesario

        try {
            conexion = cdb.obtenerConexion();
            ps = conexion.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductoDTO ai = new ProductoDTO();
                ai.setIdProducto(rs.getInt(1));
                ai.setCategoria(rs.getString(2));
                ai.setNombre(rs.getString(3));
                ai.setImagen(rs.getString(4));
                ai.setDescripcion(rs.getString(5));
                ai.setPrecio(rs.getDouble(6));
                p.add(ai);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Añade manejo de excepciones adecuado
        }
        return p;
    }

    public List listarProsc() {
        List<ProductoDTO> p = new ArrayList<>();
        String SQL = "SELECT * FROM producto where Categoria='procesador'";
        try {
            conexion = cdb.obtenerConexion();
            ps = conexion.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductoDTO ai = new ProductoDTO();
                ai.setIdProducto(rs.getInt(1));
                ai.setCategoria(rs.getString(2));
                ai.setNombre(rs.getString(3));
                ai.setImagen(rs.getString(4));
                ai.setDescripcion(rs.getString(5));
                ai.setPrecio(rs.getDouble(6));
                p.add(ai);
            }
        } catch (Exception e) {
        }
        return p;
    }

    public List listarMonitores() {
        List<ProductoDTO> p = new ArrayList<>();
        String SQL = "SELECT * FROM producto where Categoria='monitores'";
        try {
            conexion = cdb.obtenerConexion();
            ps = conexion.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductoDTO ai = new ProductoDTO();
                ai.setIdProducto(rs.getInt(1));
                ai.setCategoria(rs.getString(2));
                ai.setNombre(rs.getString(3));
                ai.setImagen(rs.getString(4));
                ai.setDescripcion(rs.getString(5));
                ai.setPrecio(rs.getDouble(6));
                p.add(ai);
            }
        } catch (Exception e) {
        }
        return p;
    }
    public List listarAlmac(){
       List<ProductoDTO> p = new ArrayList<>();
        String SQL = "SELECT * FROM producto where Categoria='almacenamiento'";
        try {
            conexion = cdb.obtenerConexion();
            ps = conexion.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                ProductoDTO ai = new ProductoDTO();
                ai.setIdProducto(rs.getInt(1));
                ai.setCategoria(rs.getString(2));
                ai.setNombre(rs.getString(3));
                ai.setImagen(rs.getString(4));
                ai.setDescripcion(rs.getString(5));
                ai.setPrecio(rs.getDouble(6));
                p.add(ai);
            }
        } catch (Exception e) {
        }
        return p;
    }
}
