
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portal de sugerencias</title>

        <link href="<%=request.getContextPath()%>/css/headerCSS.css" rel="stylesheet" type="text/css"/>
        <link href="<%=request.getContextPath()%>/css/footerCSS.css" rel="stylesheet" type="text/css"/>
        <link href="<%=request.getContextPath()%>/css/portalSugerenciasCSS.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="icon" href="<%=request.getContextPath()%>/img/favicon_2.png" />
    </head>
    <jsp:include page="header.jsp" />
    <body>
        <div class="containerPS">
            <c:if test="${not empty mensaje}">
                <p style="color: green">${mensaje}</p>
            </c:if>
            <c:if test="${not empty error}">
                <p style="color: red">${error}</p>
            </c:if>
            <form action="${pageContext.request.contextPath}/SVPortalSugerencias" method="post" enctype="multipart/form-data">
                <fieldset>
                    <legend>Portal de Sugerencias</legend>
                    <label for="Documentos">Tipo de Documento:</label>
                    <select name="Documentos" id="Documentos">
                        <option value="d" selected>DNI</option>
                        <option value="c">Carnet de Identidad</option>
                    </select>

                    <label for="NroDoc">Número de Documento:</label>
                    <input type="text" name="NroDoc" placeholder="Número de Documento *" required title="Número de Documento *" pattern="\d+" maxlength="20" />

                    <label for="PrimerNombre">Primer Nombre:</label>
                    <input type="text" name="PrimerNombre" placeholder="Primer Nombre *" required title="Primer Nombre *" maxlength="50" />

                    <label for="SegundoNombre">Segundo Nombre:</label>
                    <input type="text" name="SegundoNombre" placeholder="Segundo Nombre" maxlength="50" />

                    <label for="PrimerApellido">Primer Apellido:</label>
                    <input type="text" name="PrimerApellido" placeholder="Primer Apellido *" required title="Primer Apellido *" maxlength="50" />

                    <label for="SegundoApellido">Segundo Apellido:</label>
                    <input type="text" name="SegundoApellido" placeholder="Segundo Apellido" maxlength="50" />

                    <label for="Celular">Celular:</label>
                    <input type="text" name="Celular" placeholder="Celular *"  pattern="\d+" maxlength="15" />

                    <label for="Correo">Correo:</label>
                    <input type="email" name="Correo" placeholder="Correo *" required title="Correo *" maxlength="100" />

                    <label for="Obs">Observaciones:</label>
                    <textarea name="Obs" rows="4" cols="20"></textarea>

                    <div class="input-group">
                        <label for="imagen_reclamante">Adjuntar una imagen: NO debe ser mayor a 2MB</label>
                        <input type="file" name="imagen_reclamante" id="imagen_reclamante" accept="image/*">
                    </div>

                    <div class="input-group">
                        <label for="pedido_consumidor">Pedido del consumidor:</label>
                        <textarea id="pedido_consumidor" name="pedido_consumidor" rows="4"></textarea>
                    </div>

                    <input type="submit" value="Enviar" />
                </fieldset>
            </form>
        </div>

    </body>
    <jsp:include page="footer.jsp" />
</html>
