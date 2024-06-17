<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Verificación</title>
        <link href="<%=request.getContextPath()%>/css/headerCSS.css" rel="stylesheet" type="text/css"/>
        <link href="<%=request.getContextPath()%>/css/footerCSS.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/css/verificacion.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="icon" href="<%=request.getContextPath()%>/img/MgamatrixL.png" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link href="<%=request.getContextPath()%>/css/producto.css" rel="stylesheet" type="text/css"/>
        <style>
        </style>
    </head>
    <jsp:include page="header.jsp" />

    <body class="verificacion-body">
        <div class="container">
            <span>Vamos a verificar tu correo electrónico</span>
            <form action="${pageContext.request.contextPath}/SVVerificarCodigo" method="post">
                <input type="text" name="authcode" required placeholder="Código de verificación">
                <input type="submit" value="Verificar">
            </form>
            <c:if test="${not empty message}">
                <p style="color: ${messageColor};">${message}</p>
            </c:if>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <script>
            const colors = ['#ddeeff', '#00264d'];
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
