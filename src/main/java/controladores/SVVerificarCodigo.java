package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.dto.UsuarioDTO;

@WebServlet(name = "SVVerificarCodigo", urlPatterns = {"/SVVerificarCodigo"})
public class SVVerificarCodigo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        UsuarioDTO usuarioDTO = (UsuarioDTO) session.getAttribute("authcode");

        String code = request.getParameter("authcode");
        String message;
        String messageColor;
        
        if (code.equals(usuarioDTO.getCode())) {
            message = "Verificación realizada";
            messageColor = "green";
        } else {
            message = "Verificación incorrecta";
            messageColor = "red";
        }

        request.setAttribute("message", message);
        request.setAttribute("messageColor", messageColor);
        request.getRequestDispatcher("/vista/verificar.jsp").forward(request, response);
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


