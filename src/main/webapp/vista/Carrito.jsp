<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>Carrito de compras</title>
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

                    <% if (estaLogueado) {%>
                    <li><a href="#"><%= "Hola, " + usuario.getNombres()%></a></li>
                    <li><a href="<%=request.getContextPath()%>/CerrarSesionServlet">Cerrar Sesión</a></li>
                        <% } else {%>
                    <li><a href="<%=request.getContextPath()%>/vista/Registrarse.jsp">Registrese</a></li>
                    <li><a href="<%=request.getContextPath()%>/vista/IniciarSesion.jsp">Inicie Sesión</a></li>
                        <% }%>
                    <li class="carrito">
                        <a href="<%=request.getContextPath()%>/vista/index.jsp"></i>Seguir Comprando
                        </a>
                    </li>
                </ul>
            </nav>
            <script src="<%=request.getContextPath()%>/js/menu.js"></script>
        </header>
        <div class="container mt-4">
            <h3>Carrito</h3>
            <div class="row">
                <div class="col-sm-8">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ITEM</th>
                                <th>NOMBRE</th>
                                <th>IMAGEN</th>
                                <th>PRECIO</th>
                                <th>CANT</th>
                                <th>SUBTOTAL</th>
                                <th>ACCION</th>
                            </tr>
                        </thead>
                        <tbody>
                        <tbody>
                            <c:forEach var="car" items="${carrito}">
                                <tr>
                                    <td>${car.getItem()}</td>
                                    <td>${car.getNombre()}</td>
                                    <td>
                                        <c:if test="${not empty car.imagen}">
                                            <img src="${pageContext.request.contextPath}/img/${car.imagen}" width="100" height="100">
                                        </c:if>
                                    </td>
                                    <td>${car.getPreciocompra()}</td>
                                    <td>${car.getCantidad()}</td>
                                    <td>${car.getSubTotal()}</td>
                                    <td>
                                        <button id="btnDelete" type="button" class="btnDelete" data-id="${car.getIdProducto()}">Eliminar</button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>

                        </tbody>
                    </table>

                </div>
                <div class="col-sm-4">
                    <div class="card">
                        <div class="card-header">
                            <h3>Generar Compra</h3>
                        </div>
                        <div class="card-body">
                            <label>Subtotal:</label>
                            <input type="text" value="$.${totalPagar}0" readonly="" class="form-control">
                            <label>Descuento:</label>
                            <input type="text" value="$.0.00" readonly="" class="form-control">
                            <label>Total Pagar:</label>
                            <input type="text" value="$.${totalPagar}0" readonly="" class="form-control">
                        </div>
                        <div class="card-footer">
                            <a href="#" class="btn btn-info btn-block">Realiza Pago</a>
                            <a href="#" class="btn btn-danger btn-block">Generar Compra</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="../js/funciones.js" type="text/javascript"></script>
    </body>
    <jsp:include page="footer.jsp" />
</html>
