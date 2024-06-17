package controladores;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelo.dao.SugerenciaDAO;
import modelo.dto.SugerenciaDTO;

@WebServlet(name = "SVPortalSugerencias", urlPatterns = {"/SVPortalSugerencias"})
@MultipartConfig(maxFileSize = 2 * 1024 * 1024) // 2MB
public class SVPortalSugerencias extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recibir parámetros del formulario
        String tipoDocumento = request.getParameter("Documentos");
        String nroDocumento = request.getParameter("NroDoc");
        String primerNombre = request.getParameter("PrimerNombre");
        String segundoNombre = request.getParameter("SegundoNombre");
        String primerApellido = request.getParameter("PrimerApellido");
        String segundoApellido = request.getParameter("SegundoApellido");
        String celular = request.getParameter("Celular");
        String correo = request.getParameter("Correo");
        String observaciones = request.getParameter("Obs");
        String pedidoConsumidor = request.getParameter("pedido_consumidor");

        // Manejo del archivo de imagen
        Part imagenPart = request.getPart("imagen_reclamante");
        byte[] imagen = null;
        if (imagenPart != null && imagenPart.getSize() > 0) {
            try (InputStream inputStream = imagenPart.getInputStream()) {
                imagen = inputStream.readAllBytes();
            }
        }

        // Suponiendo que la fecha es el momento actual
        Timestamp fecha = new Timestamp(System.currentTimeMillis());

        // Crear el objeto DTO y establecer sus atributos
        SugerenciaDTO sugerencia = new SugerenciaDTO();
        sugerencia.setTipoDocumento(tipoDocumento);
        sugerencia.setNroDocumento(nroDocumento);
        sugerencia.setPrimerNombre(primerNombre);
        sugerencia.setSegundoNombre(segundoNombre);
        sugerencia.setPrimerApellido(primerApellido);
        sugerencia.setSegundoApellido(segundoApellido);
        sugerencia.setCelular(celular);
        sugerencia.setCorreo(correo);
        sugerencia.setObservaciones(observaciones);
        sugerencia.setImagen(imagen);
        sugerencia.setPedidoConsumidor(pedidoConsumidor);
        sugerencia.setFecha(fecha);

        // Insertar la sugerencia en la base de datos a través del DAO
        SugerenciaDAO sugerenciaDAO = new SugerenciaDAO();
        boolean exito = sugerenciaDAO.insertarSugerencia(sugerencia);

        // Redirigir con mensaje basado en el resultado
        String mensaje;
        if (exito) {
            mensaje = "Sugerencia registrada correctamente.";
        } else {
            mensaje = "Error al registrar la sugerencia.";
        }
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher("/vista/PortalSugerencias.jsp").forward(request, response);
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
}

