<%-- 
    Document   : ComponenteProcesador
    Created on : 5 jun. 2024, 11:24:15
    Author     : ander
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Almacenamiento</title>
        <link href="<%=request.getContextPath()%>/css/headerCSS.css" rel="stylesheet" type="text/css"/>
        <link href="<%=request.getContextPath()%>/css/footerCSS.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="icon" href="<%=request.getContextPath()%>/img/MgamatrixL.png" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link href="<%=request.getContextPath()%>/css/producto.css" rel="stylesheet" type="text/css"/>
    </head>
    <jsp:include page="header.jsp" />
    <body>
        <div class="container mt-5">
            <div class="row">
                <c:forEach var="p" items="${productos}">
                    <div class="col-md-4 mb-4">
                        <div class="card">
                            <img src="${pageContext.request.contextPath}/img/${p.getImagen()}" class="card-img-top" alt="productos">
                            <div class="card-body text-center">
                                <h4 class="card-title">${p.getNombre()}</h4>
                                <p class="card-text">S/.${p.getPrecio()}</p>
                                <a href="SVProductos?accion=AgregarCarrito&id=${p.idProducto}&tipo=Almacenamiento" class="btn btn-outline-info">Añadir al carrito</a>
                                <a href="SVProductos?accion=Comprar&id=${p.idProducto}&tipo=Almacenamiento" class="btn btn-danger">Comprar</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <script>
            const colors = ['#f8f9fa', '#000'];
            let currentColorIndex = 0;

            function changeBackgroundColor() {
                document.body.style.backgroundColor = colors[currentColorIndex];
                currentColorIndex = (currentColorIndex + 1) % colors.length;
            }

            setInterval(changeBackgroundColor, 3000);
        </script>
    </body>
    <jsp:include page="footer.jsp" />
</html>
