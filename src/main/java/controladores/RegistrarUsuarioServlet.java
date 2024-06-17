package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.dao.UsuarioDAO;
import modelo.dto.UsuarioDTO;
import servicios.EnviarCorreo;

@WebServlet(name = "RegistrarUsuarioServlet", urlPatterns = {"/RegistrarUsuarioServlet"})
public class RegistrarUsuarioServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");

        EnviarCorreo ec = new EnviarCorreo();
        String code = ec.getRandom();

        UsuarioDTO usuarioDTO = new UsuarioDTO(nombres, apellidos, correo, contrasena, code);
        boolean test = false;

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        try {
            if (usuarioDAO.registrarUsuario(usuarioDTO)) {
                test = ec.enviarEmail(usuarioDTO);

                if (test) {
                    HttpSession session = request.getSession();
                    session.setAttribute("authcode", usuarioDTO);
                    response.sendRedirect("./vista/verificar.jsp");
                } else {
                    request.setAttribute("error", "Error al enviar el correo de verificación. Por favor, inténtelo de nuevo.");
                    request.getRequestDispatcher("./vista/Registrarse.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("error", "El correo ya está registrado.");
                request.getRequestDispatcher("./vista/Registrarse.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Ocurrió un error al procesar la solicitud. Por favor, inténtelo de nuevo.");
            request.getRequestDispatcher("./vista/Registrarse.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}


