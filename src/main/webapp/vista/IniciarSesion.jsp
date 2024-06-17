<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/css/headerCSS.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/footerCSS.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/ingresarCSS.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>COMUNICATEC&reg;</title>
    <link rel="icon" href="${pageContext.request.contextPath}/img/favicon_2.png" /> <!-- Icono del sitio web -->
</head>
<jsp:include page="header.jsp" />
<body>
    <div class="containerLogin">
        <section class="form-login">
            <h5>Ingresar</h5>
            <c:if test="${not empty error}">
                <p style="color: red">${error}</p>
            </c:if>
            <form action="${pageContext.request.contextPath}/IniciarSesionServlet" method="post">
                <input class="controls" type="text" name="correo" id="correo" value="" placeholder="Correo">
                <input class="controls" type="password" name="contrasena" id="contrasena" value="" placeholder="Contraseña">
                <input class="buttons" type="submit" value="Ingresar">
            </form>
            <p class="buttom"><a href="${pageContext.request.contextPath}/vista/Registrarse.jsp">¿No tienes cuenta? Registrate</a></p>
            <p class="buttom"><a href="${pageContext.request.contextPath}/vista/Registrarse.jsp">Has olvidado tu contraseña?</a></p>
        </section>
    </div>
</body>
<jsp:include page="footer.jsp" />
</html>