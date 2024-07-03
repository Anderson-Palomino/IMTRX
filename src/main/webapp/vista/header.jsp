<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="modelo.dto.UsuarioDTO" %>
<%
    UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
    boolean estaLogueado = usuario != null;
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tu página</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bower_components/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bower_components/Ionicons/css/ionicons.min.css">
    <script src="https://unpkg.com/boxicons@2.1.4/dist/boxicons.js"></script>
    <link href="src\main\webapp\css\headerCSS.css" rel="stylesheet" type="text/css"/>
</head>
<body>

    <div class="navbar">
        <div class="navbar-top">
            <div class="navbar-logo">
                <img src="../img/meg.png" alt="LOGO IMX">
            </div>
            <div class="navbar-search">
                <input type="text" placeholder="BUSCAR.">
                <button>
                    <box-icon name='search-alt-2'></box-icon>
                </button>
            </div>
            <div class="navbar-icons">
                <a href="#"><box-icon name='user-circle'></box-icon><span>Inicia Sesión</span></a>
                <a href="#"><box-icon name='package'></box-icon><span>Mis Pedidos</span></a>
                <a href="#"><box-icon name='cart'></box-icon><span>0</span></a>
            </div>
        </div>
        <div class="navbar-middle">
            <a href="#">Categorías</a>
            <a href="#" style="color: red;">Ofertas</a>
            <a href="#">Campañas</a>
            <a href="#">Marcas</a>
            <a href="#">Distribuidores</a>
            <a href="#">¿Qué Vas A Jugar?</a>
            <a href="#">Contactanos</a>
        </div>
        <div class="navbar-bottom">
            <a href="#">Nuevo Ingreso</a>
            <a href="#">PC's Completas</a>
            <a href="#">Laptops</a>
            <a href="#">Nuestros Locales</a>
            <a href="#">Modalidades De Pago</a>
            <a href="#">Envíos A Provincia</a>
            <a href="#">Delivery Lima</a>
            <a href="#">Chatea Con Nosotros</a>
        </div>
    </div>

</body>
</html>
