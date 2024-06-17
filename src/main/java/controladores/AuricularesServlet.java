/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.ProductosDAO;
import modelo.dto.CarritoDTO;
import modelo.dto.ProductoDTO;

/**
 *
 * @author user
 */
@WebServlet(name = "AuricularesServlet", urlPatterns = {"/AuricularesServlet"})
public class AuricularesServlet extends HttpServlet {

    ProductosDAO prodao = new ProductosDAO();
    ProductoDTO p =new ProductoDTO();
    List<ProductosDAO> Auriculares = new ArrayList<>();
    List<CarritoDTO> listaCarrito = new ArrayList<>();
    int item;
    double totalPagar=0;
    int cantidad=1;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        Auriculares = prodao.listarAuriculares();
        switch (accion != null ? accion : "default") {
            case "AgregarCarrito":
                int idp=Integer.parseInt(request.getParameter("id"));
                p=prodao.listarId(idp);
                item=item+1;
                CarritoDTO car= new CarritoDTO();
                car.setItem(item);
                car.setIdProducto(p.getIdProducto());
                car.setNombre(p.getNombre());
                car.setDescripcion(p.getDescripcion());
                car.setCantidad(cantidad);
                car.setSubTotal(cantidad*p.getPrecio());
                listaCarrito.add(car);
                request.getRequestDispatcher("Controlador?accion=");
                break;
            case "accion2":
                // Lógica para accion2
                break;
            // Agrega más casos según sea necesario
            case "default":
                request.setAttribute("Auriculares", Auriculares);
                request.getRequestDispatcher("./vista/ComponenteAuriculares.jsp").forward(request, response);
                break;
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
