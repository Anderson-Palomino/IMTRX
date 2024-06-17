
package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.ProductosDAO;

@WebServlet(name = "SVMemoriaram", urlPatterns = {"/SVMemoriaram"})
public class SVMemoriaram extends HttpServlet {
    ProductosDAO prodao = new ProductosDAO();
    List<ProductosDAO> MemoriaRAM =new ArrayList<>();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        MemoriaRAM = prodao.listarMRAM();
        switch (accion != null ? accion : "default") {
            case "accion1":
                break;
            case "accion2":
                break;
            case "default":
                request.setAttribute("MemoriaRAM", MemoriaRAM);
                request.getRequestDispatcher("./vista/ComponenteMemoriaram.jsp").forward(request, response);
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
    }

}
