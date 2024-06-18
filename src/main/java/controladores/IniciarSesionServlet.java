package controladores;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.dao.UsuarioDAO;
import modelo.dto.UsuarioDTO;

@WebServlet(name = "IniciarSesionServlet", urlPatterns = {"/IniciarSesionServlet"})
public class IniciarSesionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        UsuarioDTO usuario = usuarioDAO.validarUsuario(correo, contrasena);

        if (usuario != null) {
            try {
                if (usuarioDAO.verificarCorreoVerificado(usuario.getCode())) {
                    HttpSession session = request.getSession();
                    session.setAttribute("usuario", usuario);
                    response.sendRedirect(request.getContextPath() + "/vista/index.jsp");
                } else {
                    request.setAttribute("error", "Correo electrónico no verificado");
                    request.getRequestDispatcher("/vista/IniciarSesion.jsp").forward(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(IniciarSesionServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            request.setAttribute("error", "Correo o contraseña incorrectos");
            request.getRequestDispatcher("/vista/IniciarSesion.jsp").forward(request, response);
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
        return "Servlet para iniciar sesión";
    }
}


