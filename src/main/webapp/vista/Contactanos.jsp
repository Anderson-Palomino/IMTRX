
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/headerCSS.css" rel="stylesheet" type="text/css"/>
        <link href="../css/footerCSS.css" rel="stylesheet" type="text/css"/>
        <link href="../css/contactanosCSS.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <title>Contactanos</title>
        <link rel="icon" href="../img/favicon_2.png" />
    </head>
    <jsp:include page="header.jsp" />
    <body>
        <div class="containerContac">
            <h1>Contáctanos</h1>
            <div class="contacto">
                <div class="info">
                    <article id="bloque">
                        <h3>NOSOTROS TE AYUDAMOS</h3>
                        <br/>
                        <h4>Correo Electrónico:</h4>
                        soporte@Megamatrix.com
                        <br><br>
                        <h4><i class="fa-brands fa-whatsapp"></i> Whatsapp:</h4>
                        984561234
                        <br><br><br>
                        <img src="../img/soporte.png" alt="soporte">

                    </article>
                </div>
                <div class="info">
                    <article id="bloque">
                        <h3>REDES SOCIALES</h3>
                        <br />
                        <ul class="redesSociales"> <!---REDES SOCIALES--->
                            <li><i class="fab fa-facebook"></i><b> Facebook:</b><a href="#"><br>facebook.com/Megamatrix</a></li><br />
                            <li><i class="fab fa-instagram"></i><b> Instagram:</b><a href="#"><br/>instagram.com/Megamatrix</a></li><br />
                            <li><i class="fab fa-tiktok"></i><b> Tiktok:</b><a href="#"><br />tiktok.com/Megamatrix</a></li><br />
                        </ul>
                    </article>
                </div>

            </div>
            <div class="mapa">
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d124899.85801760976!2d-77.08016670147458!3d-11.96615377330381!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x9105c8c6e5da2a27%3A0x9a2057fc20600e91!2siShop!5e0!3m2!1ses-419!2spe!4v1695018859142!5m2!1ses-419!2spe" width=100% height=100% style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
            </div>
        </div>
    </body>
    <jsp:include page="footer.jsp" />
</html>
