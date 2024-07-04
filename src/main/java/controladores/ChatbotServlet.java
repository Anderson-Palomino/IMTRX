package controladores;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.ProductosDAO;
import modelo.dao.ServiciosDAO;
import modelo.dto.ProductoDTO;
import modelo.dto.ServicioDTO;

import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet(name = "ChatbotServlet", urlPatterns = {"/chatbot"})
public class ChatbotServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        JSONObject jsonResponse = new JSONObject();

        if (action == null) {
            jsonResponse.put("message", "No action specified.");
        } else {
            switch (action) {
                case "productos":
                    jsonResponse = obtenerProductos();
                    break;
                case "servicios":
                    jsonResponse = obtenerServicios();
                    break;
                case "contacto":
                    jsonResponse = obtenerContacto();
                    break;
                default:
                    jsonResponse.put("message", "Acción no reconocida.");
                    break;
            }
        }

        response.getWriter().write(jsonResponse.toString());
    }

    private JSONObject obtenerProductos() {
        JSONObject json = new JSONObject();
        JSONArray productosArray = new JSONArray();
        
        ProductosDAO productosDAO = new ProductosDAO();
        List<ProductoDTO> productos = productosDAO.listarTodos(); 

        for (ProductoDTO producto : productos) {
            JSONObject productoJson = new JSONObject();
            productoJson.put("id", producto.getIdProducto());
            productoJson.put("nombre", producto.getNombre());
            productoJson.put("descripcion", producto.getDescripcion());
            productoJson.put("precio", producto.getPrecio());
            productoJson.put("imagen", producto.getImagen());
            productosArray.put(productoJson);
        }
        
        json.put("productos", productosArray);
        return json;
    }

    private JSONObject obtenerServicios() {
        JSONObject json = new JSONObject();
        JSONArray serviciosArray = new JSONArray();
        
        ServiciosDAO serviciosDAO = new ServiciosDAO();
        List<ServicioDTO> servicios = serviciosDAO.listarServicios();

        for (ServicioDTO servicio : servicios) {
            JSONObject servicioJson = new JSONObject();
            servicioJson.put("id", servicio.getIdServicio());
            servicioJson.put("nombre", servicio.getNombre());
            servicioJson.put("descripcion", servicio.getDescripcion());
            serviciosArray.put(servicioJson);
        }
        
        json.put("servicios", serviciosArray);
        return json;
    }

    private JSONObject obtenerContacto() {
        JSONObject json = new JSONObject();
        json.put("whatsapp", "urlde la la empresa"); 
        json.put("mensaje", "Para más información, contacta a nuestro asesor por WhatsApp.");
        return json;
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
        return "Servlet para manejar interacciones del chatbot";
    }
}
