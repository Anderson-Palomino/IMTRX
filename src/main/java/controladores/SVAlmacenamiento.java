package controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.dao.ProductosDAO;
import modelo.dto.CarritoDTO;
import modelo.dto.ProductoDTO;

@WebServlet(name = "SVAlmacenamiento", urlPatterns = {"/SVAlmacenamiento"})
public class SVAlmacenamiento extends HttpServlet {
    ProductosDAO prodao = new ProductosDAO();
    ProductoDTO p = new ProductoDTO();
    List<ProductosDAO> Almacenamiento = new ArrayList<>();
    int item;
    double totalPagar = 0;
    int cantidad = 1;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        Almacenamiento = prodao.listarAlmac();
        HttpSession session = request.getSession();
        List<CarritoDTO> listaCarrito = (List<CarritoDTO>) session.getAttribute("listaCarrito");
        if (listaCarrito == null) {
            listaCarrito = new ArrayList<>();
        }
        
        switch (accion != null ? accion : "default") {
            case "AgregarCarrito":
                int idp = Integer.parseInt(request.getParameter("id"));
                p = prodao.listarId(idp);
                item = listaCarrito.size() + 1;
                CarritoDTO car = new CarritoDTO();
                car.setItem(item);
                car.setIdProducto(p.getIdProducto());
                car.setNombre(p.getNombre());
                car.setDescripcion(p.getDescripcion());
                car.setCantidad(cantidad);
                car.setSubTotal(cantidad * p.getPrecio());
                listaCarrito.add(car);
                session.setAttribute("listaCarrito", listaCarrito);
                break;
            case "accion2":
                break;
            case "default":
                break;
        }

        session.setAttribute("contador", listaCarrito.size());
        request.setAttribute("contador", listaCarrito.size());
        request.setAttribute("Almacenamiento", Almacenamiento);
        request.getRequestDispatcher("./vista/ComponenteAlmacenamiento.jsp").forward(request, response);
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
