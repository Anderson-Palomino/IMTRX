package controladores;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.ProductosDAO;
import modelo.dto.ProductoDTO;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@WebServlet(name = "ReporteCarritoServlet", urlPatterns = {"/ReporteCarritoServlet"})
public class ReporteCarritoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf");
        OutputStream out = response.getOutputStream();

        // para resumir todo el arreglo usado en el try, estoy buscando el formato de boleta, revisandolo, llenando campos, poneindole titulo al pdf, generandolo y dandoselo al cliente
        try {
            String jrxmlFile = getServletContext().getRealPath("aca iria la url generada del jasper studio");
            JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlFile);
            ProductosDAO productosDAO = new ProductosDAO();
            List<ProductoDTO> carrito = productosDAO.obtenerCarrito();
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(carrito);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("ReportTitle", "Carrito de Compras");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
            JasperExportManager.exportReportToPdfStream(jasperPrint, out);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        } finally {
            out.close();
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
        return "Reporte Carrito Servlet";
    }
}
