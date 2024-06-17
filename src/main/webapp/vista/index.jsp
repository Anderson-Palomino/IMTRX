
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        <link href="../css/headerCSS.css" rel="stylesheet" type="text/css"/>
        <link href="../css/footerCSS.css" rel="stylesheet" type="text/css"/>
        <link href="../css/indexCSS.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="icon" href="../img/MgamatrixL.png" />
    </head>
    <jsp:include page="header.jsp" />
    <body>
        <main>

            <section class="bannerPrincipal"> <!-- Banner de bienvenida -->
                <h1 class="tituloPrincipal">BIENVENIDO A
                    <br> MEGAMATRIX
                </h1>
                <img src="../img/fondoo.png" alt="Fondo"/>
            </section>

            <h1 class="vendido-top">
                LOS SERVICIOS QUE OFRECEMOS 
            </h1>


            <div class="Vendido">
                <div class="tab_header">
                    <label class="active"><button class="tab_btn">COMPONENTES</button></label>
                    <label><button class="tab_btn">SERVICIOS</button></label>
                </div>

                <div class="celularesTOP">
                    <div class="contenidoProductos active">
                        <section id="productos-IOS"></section>
                    </div>
                    <div class="contenidoProductos">
                        <section id="productos-Android"></section>
                    </div>
                </div>
            </div>
        </main>
    </body>
    <jsp:include page="footer.jsp" />
</html>
