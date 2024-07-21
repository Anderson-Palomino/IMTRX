<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="modelo.dto.UsuarioDTO" %>
<%
    UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
    boolean estaLogueado = usuario != null;
%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bower_components/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bower_components/Ionicons/css/ionicons.min.css">
    <link href="<%=request.getContextPath()%>/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css"/>
    <style>
        .carrito {
            display: flex;
            align-items: center;
        }
        .carrito i {
            font-size: 24px;
            margin-right: 5px;
        }
    </style>
</head>
<body>
    <header class="containerHeader">
        <a href="index.jsp" class="logoMenu">
            <img src="<%=request.getContextPath()%>/img/Mgamatrix.png" alt="Logo"/>
        </a>
        <nav class="navegador">
            <ul class="menu">
                <li><a href="<%=request.getContextPath()%>/vista/index.jsp">Inicio</a></li>
                <li>
                    <a href="#">Ofrecemos <i class="fas fa-chevron-down"></i></a>
                    <ul class="submenu">
                        <li>
                            <a href="#">Componentes <i class="fas fa-chevron-right"></i></a>
                            <ul class="submenu">
                                <li><a href="<%=request.getContextPath()%>/SVAlmacenamiento">Almacenamiento</a></li>
                                <li><a href="<%=request.getContextPath()%>/SVMonitores">Monitores</a></li>
                                <li><a href="<%=request.getContextPath()%>/TecladoServlet">Teclado</a></li>
                                <li><a href="<%=request.getContextPath()%>/MouseServlet">Mouse</a></li>
                                <li><a href="<%=request.getContextPath()%>/AuricularesServlet">Auriculares</a></li>
                                <li><a href="<%=request.getContextPath()%>/vista/ComponenteCases.jsp">Cases</a></li>
                                <li><a href="<%=request.getContextPath()%>/SVPlacasMadre">Placas Madre</a></li>
                                <li><a href="<%=request.getContextPath()%>/SVMemoriaram">Memoria RAM</a></li>
                                <li><a href="<%=request.getContextPath()%>/SVProcesador">Procesador</a></li>
                                <li><a href="<%=request.getContextPath()%>/vista/ComponenteTarjetasDeVideo.jsp">Tarjetas de video</a></li>
                                <li><a href="<%=request.getContextPath()%>/SVCooler">Cooler</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="#">Servicios <i class="fas fa-chevron-right"></i></a>
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
                    <a href="<%=request.getContextPath()%>/vista/Carrito.jsp">
                        <i class="fa fa-shopping-cart"></i> Carrito(<%= request.getAttribute("contador") %>)
                    </a>
                </li>
            </ul>
        </nav>
        <script src="<%=request.getContextPath()%>/js/menu.js"></script>
    </header>
</body>
</html>
