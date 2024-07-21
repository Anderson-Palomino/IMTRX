<%@ page contentType="text/html" pageEncoding="UTF-8" %>
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
<jsp:include page="header.jsp" />
<body>
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
