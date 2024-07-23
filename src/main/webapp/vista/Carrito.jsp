<%@ page contentType="text/html" pageEncoding="UTF-8" %>
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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Auriculares</title>
    <link href="<%=request.getContextPath()%>/css/headerCSS.css" rel="stylesheet" type="text/css"/>
    <link href="<%=request.getContextPath()%>/css/footerCSS.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="icon" href="<%=request.getContextPath()%>/img/MgamatrixL.png" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" 
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="<%=request.getContextPath()%>/css/producto.css" rel="stylesheet" type="text/css"/>
    <link rel="icon" href="../img/MgamatrixL.png" />
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            padding-top: 80px;
            transition: background-color 3s ease;
        }
        .containerCC {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            text-align: center;
        }
        #productos-container, #totales {
            width: 100%;
            max-width: 600px;
            margin: 20px auto;
            background-color: #ffffff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        #totales {
            text-align: center;
        }
        .resumen-compra {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .resumen-compra p, .resumen-compra button, .resumen-compra a {
            margin: 10px 0;
        }
    </style>
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
                    <a href="<%=request.getContextPath()%>/vista/index.jsp"></i>Seguir Comprando
                    </a>
                </li>
            </ul>
        </nav>
        <script src="<%=request.getContextPath()%>/js/menu.js"></script>
    </header>
    <main class="containerCC">
        <p id="carrito-vacio">Ups! No hay productos en el carrito</p>
        <section id="productos-container">
        </section>
        <section id="totales">
            <h2>Resumen de compra</h2>
            <div class="resumen-compra">
                <p>Total productos: <span id="unidades">0</span></p>
                <p>Total precio: <span id="precio">0</span></p>
                <button id="reiniciar">Reiniciar carrito</button>
                <a href="funcionCompra.jsp"><button>Comprar</button></a>
            </div>
        </section>
    </main>
</body>
<jsp:include page="footer.jsp" />
</html>
