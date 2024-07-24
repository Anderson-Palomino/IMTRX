<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="modelo.dto.UsuarioDTO" %>
<%
    UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
    boolean estaLogueado = usuario != null;
    Integer contador = (Integer) session.getAttribute("contador");
    if (contador == null) {
        contador = 0; // Valor predeterminado si no hay productos en el carrito
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Header</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bower_components/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bower_components/Ionicons/css/ionicons.min.css">
    <link href="<%=request.getContextPath()%>/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css"/>
    <link href="<%=request.getContextPath()%>/css/header.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <header class="containerHeader">
        <a href="index.jsp" class="logoMenu">
            <img src="<%=request.getContextPath()%>/img/Mgamatrix.png" alt="Logo"/>
        </a>
        <input type="checkbox" id="check">
        <label for="check" class="checkbtn">
            <i class="fa fa-bars"></i>
        </label>
        <nav class="navegador">
            <ul class="menu">
                <li><a href="<%=request.getContextPath()%>/vista/index.jsp">Inicio</a></li>
                <li class="submenuParent">
                    <a href="#">Ofrecemos <i class="fa fa-chevron-down"></i></a>
                    <ul class="submenu">
                        <li class="submenuParent">
                            <a href="#">Componentes <i class="fa fa-chevron-right"></i></a>
                            <ul class="submenu">
                                <li><a href="<%=request.getContextPath()%>/SVProductos?tipo=Almacenamiento">Almacenamiento</a></li>
                                <li><a href="<%=request.getContextPath()%>/SVProductos?tipo=Monitores">Monitores</a></li>
                                <li><a href="<%=request.getContextPath()%>/SVProductos?tipo=Teclado">Teclado</a></li>
                                <li><a href="<%=request.getContextPath()%>/SVProductos?tipo=Mouse">Mouse</a></li>
                                <li><a href="<%=request.getContextPath()%>/SVProductos?tipo=Auriculares">Auriculares</a></li>
                                <li><a href="<%=request.getContextPath()%>/vista/ComponenteCases.jsp">Cases</a></li>
                                <li><a href="<%=request.getContextPath()%>/SVProductos?tipo=Placamadre">Placas Madre</a></li>
                                <li><a href="<%=request.getContextPath()%>/SVProductos?tipo=Memoriaram">Memoria RAM</a></li>
                                <li><a href="<%=request.getContextPath()%>/SVProductos?tipo=Procesador">Procesador</a></li>
                                <li><a href="<%=request.getContextPath()%>/vista/ComponenteTarjetasDeVideo.jsp">Tarjetas de video</a></li>
                                <li><a href="<%=request.getContextPath()%>/SVProductos?tipo=Cooler">Cooler</a></li>
                            </ul>
                        </li>
                        <li class="submenuParent">
                            <a href="#">Servicios <i class="fa fa-chevron-right"></i></a>
                            <ul class="submenu">
                                <li><a href="<%=request.getContextPath()%>/vista/VentanaServicioEnsamblaje.jsp">Ensamblaje</a></li>
                                <li><a href="<%=request.getContextPath()%>/vista/VentanaServicio=Mantenimiento.jsp">Mantenimiento</a></li>
                                <li><a href="<%=request.getContextPath()%>/vista/VentanaServicioInstalacionSO.jsp">Instalación de sistema operativo y drivers</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li><a href="<%=request.getContextPath()%>/vista/Contactanos.jsp">Contactanos</a></li>
                <li><a href="<%=request.getContextPath()%>/vista/Nosotros.jsp">Nosotros</a></li>

                <% if (estaLogueado) { %>
                    <li><a href="#"><%= "Hola, " + usuario.getNombres() %></a></li>
                    <li><a href="<%=request.getContextPath()%>/CerrarSesionServlet">Cerrar Sesión</a></li>
                <% } else { %>
                    <li><a href="<%=request.getContextPath()%>/vista/Registrarse.jsp">Registrese</a></li>
                    <li><a href="<%=request.getContextPath()%>/vista/IniciarSesion.jsp">Inicie Sesión</a></li>
                <% } %>
                <li class="carrito">
                    <a href="SVProductos?accion=Carrito">
                        <i class="fa fa-shopping-cart"></i>Carrito(<%= contador %>)
                    </a>
                </li>
            </ul>
        </nav>
        <script src="<%=request.getContextPath()%>/js/menu.js"></script>
    </header>
</body>
</html>
