package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.ReclamacionDAO;
import modelo.dto.ReclamacionDTO;

@WebServlet(name = "RegistrarReclamacionServlet", urlPatterns = {"/RegistrarReclamacionServlet"})
@MultipartConfig(maxFileSize = 2 * 1024 * 1024) // 2MB
public class RegistrarReclamacionServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Obtener parámetros del formulario
            String primerNombre = request.getParameter("primer_nombre");
            String segundoNombre = request.getParameter("segundo_nombre");
            String apellidoPaterno = request.getParameter("apellido_paterno");
            String apellidoMaterno = request.getParameter("apellido_materno");
            String domicilio = request.getParameter("domicilio");
            String departamento = request.getParameter("departamento");
            String provincia = request.getParameter("provincia");
            String distrito = request.getParameter("distrito");
            String dni = request.getParameter("dni");
            String telefono = request.getParameter("telefono");
            String correo = request.getParameter("correo");
            boolean menor = Boolean.parseBoolean(request.getParameter("menor"));
            String tipoBienContratado = request.getParameter("cboCategoria"); // Cambiado el nombre del parámetro
            double montoReclamo = Double.parseDouble(request.getParameter("monto_reclamo"));
            String tipoReclamo = request.getParameter("tipo_reclamo");
            String descripcion = request.getParameter("descripcion");
            String imagenReclamante = request.getParameter("imagen_reclamante");
            String pedidoConsumidor = request.getParameter("pedido_consumidor");
            boolean respuestaDireccion = Boolean.parseBoolean(request.getParameter("respuesta_direccion"));

            // Crear objeto ReclamacionDTO
            ReclamacionDTO reclamacion = new ReclamacionDTO();
            reclamacion.setPrimerNombre(primerNombre);
            reclamacion.setSegundoNombre(segundoNombre);
            reclamacion.setApellidoPaterno(apellidoPaterno);
            reclamacion.setApellidoMaterno(apellidoMaterno);
            reclamacion.setDomicilio(domicilio);
            reclamacion.setDepartamento(departamento);
            reclamacion.setProvincia(provincia);
            reclamacion.setDistrito(distrito);
            reclamacion.setDni(dni);
            reclamacion.setTelefono(telefono);
            reclamacion.setCorreo(correo);
            reclamacion.setMenor(menor);
            reclamacion.setTipoBienContratado(tipoBienContratado);
            reclamacion.setMontoReclamo(montoReclamo);
            reclamacion.setTipoReclamo(tipoReclamo);
            reclamacion.setDescripcion(descripcion);
            reclamacion.setImagenReclamante(imagenReclamante);
            reclamacion.setPedidoConsumidor(pedidoConsumidor);
            reclamacion.setRespuestaDireccion(respuestaDireccion);

            // Guardar la reclamación en la base de datos
            ReclamacionDAO reclamacionDAO = new ReclamacionDAO();
            boolean registroExitoso = reclamacionDAO.insertarReclamacion(reclamacion);

            // Redireccionar y mostrar mensaje
            if (registroExitoso) {
                request.setAttribute("mensaje", "La reclamación se registró correctamente.");
            } else {
                request.setAttribute("mensaje", "Error al registrar la reclamación. Inténtalo de nuevo.");
            }
        } catch (NumberFormatException e) {
            // Capturar excepción si no se puede convertir un valor a número
            request.setAttribute("mensaje", "Error al procesar el formulario. Verifica que los datos sean correctos.");
        }

        request.getRequestDispatcher("vista/LibroReclamaciones.jsp").forward(request, response);
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