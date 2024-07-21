<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.servlet.http.*" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/headerCSS.css" />
    <link rel="stylesheet" type="text/css" href="css/funcionCompra.css" />
    <link rel="stylesheet" type="text/css" href="css/footerCSS.css">
    <script src="./js/carritoService.js" defer></script>
    <script src="./js/infoTarjeta.js" defer></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" 
          integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" 
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>COMUNICATEC® - Compra</title>
    <link rel="icon" href="img/favicon_2.png" /> <!-- Icono del sitio web -->
</head>

<body>

    <%
        // No es necesario declarar HttpSession session, ya que está disponible implícitamente
        if (session.getAttribute("usuario") == null) {
            response.sendRedirect("Ingresar.jsp");
            return;
        }

        List<String> errores = new ArrayList<>();
        
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            // Validar tipo de entrega
            String tipoEntrega = request.getParameter("tipoEntrega");
            if (tipoEntrega == null || (!"retiro".equals(tipoEntrega) && !"delibery".equals(tipoEntrega))) {
                errores.add("Seleccione un tipo de entrega válido.");
            } else {
                // Resto de las validaciones y código relacionado con 'tipoEntrega'...
                session.setAttribute("tipoEntrega", tipoEntrega);
            }

            // Validar tipo de pago
            String tipoPago = request.getParameter("tipoPago");
            if (tipoPago == null || (!"debito".equals(tipoPago) && !"credito".equals(tipoPago))) {
                errores.add("Seleccione un tipo de pago válido.");
            } else {
                // Validar los datos de la tarjeta si se ha seleccionado el tipo de pago con tarjeta
                if ("debito".equals(tipoPago) || "credito".equals(tipoPago)) {
                    // Validar el número de tarjeta y el resto de las validaciones de la tarjeta...
                }
                session.setAttribute("tipoPago", tipoPago);
            }

            // Validar los demás campos del formulario
            String numeroTarjeta = request.getParameter("numeroTarjeta");
            String mesVencimiento = request.getParameter("mesVencimiento");
            String anioVencimiento = request.getParameter("anioVencimiento");
            String cvv = request.getParameter("cvv");
            String dni = request.getParameter("dni");
            String terminosCondiciones = request.getParameter("terminosCondiciones");

            if (numeroTarjeta == null || mesVencimiento == null || anioVencimiento == null || cvv == null || dni == null || terminosCondiciones == null) {
                errores.add("Todos los campos son obligatorios. Por favor, complete todos los campos.");
            }

            // Validar el formato de la tarjeta (solo números)
            if (numeroTarjeta != null && !numeroTarjeta.matches("^[0-9]{12,19}$")) {
                errores.add("El número de tarjeta debe contener solo números y tener entre 12 y 19 dígitos.");
            }

            // Validar el formato del CVV (solo números)
            if (cvv != null && !cvv.matches("^[0-9]{3,4}$")) {
                errores.add("El CVV debe contener solo números y tener entre 3 y 4 dígitos.");
            }

            // Validar el formato del DNI (solo números)
            if (dni != null && !dni.matches("^\\d{8}$")) {
                errores.add("El DNI debe contener solo 8 números.");
            }

            // Puedes agregar más validaciones según tus requisitos, por ejemplo, validar el formato de la tarjeta, fecha de vencimiento, etc.

            if (errores.isEmpty()) {
                // Si no hay errores, redirige a Pagar.jsp
                session.setAttribute("numeroTarjeta", numeroTarjeta);
                session.setAttribute("mesVencimiento", mesVencimiento);
                session.setAttribute("anioVencimiento", anioVencimiento);
                session.setAttribute("cvv", cvv);
                session.setAttribute("dni", dni);
                response.sendRedirect("Pagar.jsp");
                return;
            }
        }

        request.getRequestDispatcher("header.jsp").include(request, response);
    %>

    <main class="container-compra">
        <form method="post">
            <section class="info-pago">
                <section class="tipo-entrega">
                    <h1>Tipo de entrega</h1>
                    <div>
                        <section>
                            <h2>Retiro en tienda</h2>
                            <label>
                                <input type="radio" name="tipoEntrega" value="retiro"> Gratis<br>
                            </label>
                        </section>
                        <section>
                            <h2>Envio a domicilio</h2>
                            <label>
                                <input type="radio" name="tipoEntrega" value="delibery"> S/. 9.00<br>
                            </label>
                        </section>
                    </div>
                </section>

                <section class="tipo-pago">
                    <h1>Tipo de pago</h1>
                    <div class="tarjeta">
                        <label>
                            <input type="radio" name="tipoPago" value="debito" id="open-btn1"> Tarjeta de Débito
                        </label>

                        <label>
                            <input type="radio" name="tipoPago" value="credito" id="open-btn2"> Tarjeta de Crédito
                        </label>
                    </div>

                    <div class="tarjeta-info" id="tarjeta-info">
                        <h3>Ingrese los datos de su tarjeta</h3>

                        <input type="text" id="numeroTarjeta" name="numeroTarjeta" pattern="[0-9]{12,19}" maxlength="19" placeholder="Número de Tarjeta" oninput="validarNumeroTarjeta()">
                        <span id="mensajeErrorNumeroTarjeta" style="color: red;"></span>


                        <select id="mesVencimiento" name="mesVencimiento" placeholder="Mes de Vencimiento">
                            <option value="">Mes de Vencimiento</option>
                            <option value="1">01</option>
                            <option value="2">02</option>
                            <option value="3">03</option>
                            <option value="4">04</option>
                            <option value="5">05</option>
                            <option value="6">06</option>
                            <option value="7">07</option>
                            <option value="8">08</option>
                            <option value="9">09</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                        </select>

                        <select id="anioVencimiento" name="anioVencimiento" placeholder="Mes de Vencimiento">
                            <option value="">Año de Vencimiento</option>
                            <option value="2023">2023</option>
                            <option value="2024">2024</option>
                            <option value="2025">2025</option>
                            <option value="2026">2026</option>
                            <option value="2027">2027</option>
                            <option value="2028">2028</option>
                            <option value="2029">2029</option>
                            <option value="2030">2030</option>
                            <option value="2031">2031</option>
                            <option value="2032">2032</option>
                            <option value="2033">2033</option>
                        </select>

                        <input type="text" id="cvv" name="cvv" pattern="[0-9]{3,4}" maxlength="4" placeholder="CVV" oninput="validarCVV()">
                        <span id="mensajeErrorCVV" style="color: red;"></span>


                        <input type="text" id="dni" name="dni" placeholder="DNI" pattern="\\d{8,8}" maxlength="8" oninput="validarDNI()">
                        <span id="mensajeErrorDNI" style="color: red;"></span>
                    </div>

                </section>
            </section>

            <section class="resumen-pago">
                <h1>Resumen de orden</h1>
                <div class="contenedor">
                    <section class="totales">
                        <p>Total productos: <span id="unidades">0</span></p>
                        <section id="producto-paga">
                        </section>
                    </section>
                    <div>
                        <a href="CarroCompra.jsp" class="carritoLogo"><i class="fa-solid fa-cart-shopping" id=carritologo></i>Volver al carrito</a>
                    </div>
                    <label class="terminosycondiciones">
                        <input type="checkbox" id="terminosCondiciones" name="terminosCondiciones"> Declaro que he leído y aceptado los términos y condiciones
                    </label>

                    <center>
                        <input class="btn-pagar" type="submit" name="pagar" value="Pagar">
                    </center>
                    <%
                    if (!errores.isEmpty()) {
                        out.write("<div class='errores'>");
                        for (String error : errores) {
                            out.write("<p>" + error + "</p>");
                        }
                        out.write("</div>");
                    }
                    %>
                </div>
            </section>
        </form>
    </main>

    <%
    request.getRequestDispatcher("footer.jsp").include(request, response);
    %>

</body>

</html>
