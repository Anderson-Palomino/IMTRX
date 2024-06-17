/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.ProductosDAO;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SVPlacasMadre", urlPatterns = {"/SVPlacasMadre"})
public class SVPlacasMadre extends HttpServlet {
    
    ProductosDAO prodao = new ProductosDAO();
    List<ProductosDAO> PlacaMadre =new ArrayList<>();
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        PlacaMadre = prodao.listarPLM();
        switch (accion != null ? accion : "default") {
            case "accion1":
                break;
            case "accion2":
                break;
            case "default":
                request.setAttribute("PlacaMadre", PlacaMadre);
                request.getRequestDispatcher("./vista/ComponentePlacaMadre.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
