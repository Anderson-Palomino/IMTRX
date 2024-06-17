<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/css/footerCSS.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/headerCSS.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/registrarseCSS.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>COMUNICATEC&reg; - Registrarse</title>
    <link rel="icon" href="${pageContext.request.contextPath}/img/favicon_2.png" /> <!-- Icono del sitio web -->
</head>
<body>
    <jsp:include page="header.jsp" />
    <form action="${pageContext.request.contextPath}/RegistrarUsuarioServlet" method="post">
        <div class="containerRegistrar">
            <section class="form-register">
                <h4>Formulario Registro</h4>
                <c:if test="${not empty mensaje}">
                    <p style="color: green">${mensaje}</p>
                </c:if>
                <c:if test="${not empty error}">
                    <p style="color: red">${error}</p>
                </c:if>
                <input class="controls" type="text" name="nombres" id="nombres" placeholder="Ingrese su Nombre" value="${param.nombres}">
                <input class="controls" type="text" name="apellidos" id="apellidos" placeholder="Ingrese su Apellido" value="${param.apellidos}">
                <input class="controls" type="email" name="correo" id="correo" placeholder="Ingrese su Correo" value="${param.correo}">
                <input class="controls" type="password" name="contrasena" id="contrasena" placeholder="Ingrese su Contraseña">
                <p>Estoy de acuerdo con <a href="#">Términos y Condiciones</a></p>
                <input class="botons" type="submit" value="Registrar" name="registro">
                <p><a class="buttom" href="${pageContext.request.contextPath}/vista/Ingresar.jsp">Ya tengo cuenta</a></p>
            </section>
        </div>
    </form>
    <jsp:include page="footer.jsp" />
</body>
</html>
