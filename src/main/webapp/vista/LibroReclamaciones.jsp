<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Libro de Reclamaciones</title>
        <link href="../css/headerCSS.css" rel="stylesheet" type="text/css"/>
        <link href="../css/footerCSS.css" rel="stylesheet" type="text/css"/>
        <link href="../css/libroReclamacionesCSS.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="icon" href="../img/favicon_2.png" />
    </head>
    <jsp:include page="header.jsp" />
    <body>
        <div class="containerLR">
            <h1>Libro de Reclamaciones</h1>
            <p class="empresa-info">
                Razón Social: MegaMatrix S.A. <br>
                RUC: 20122667660 <br>
                Dirección: Av. Angamos Oeste Nro. 120 Miraflores, Lima, Perú. <br>
                Hora: 10:07 AM Fecha: 18/09/2024
            </p>
            <form action="SVLibroReclamaciones" method="post" enctype="multipart/form-data">
                <h2>Identificación del consumidor reclamante</h2>

                <div class="input-group">
                    <label for="primer_nombre">Primer Nombre:</label>
                    <input type="text" id="primer_nombre" name="primer_nombre" value="${primer_nombre}" required>
                </div>

                <div class="input-group">
                    <label for="segundo_nombre">Segundo Nombre:</label>
                    <input type="text" id="segundo_nombre" name="segundo_nombre" value="${segundo_nombre}" required>
                </div>

                <div class="input-group">
                    <label for="apellido_paterno">Apellido Paterno:</label>
                    <input type="text" id="apellido_paterno" name="apellido_paterno" value="${apellido_paterno}" required>
                </div>

                <div class="input-group">
                    <label for="apellido_materno">Apellido Materno:</label>
                    <input type="text" id="apellido_materno" name="apellido_materno" value="${apellido_materno}" required>
                </div>

                <div class="input-group">
                    <label for="domicilio">Domicilio:</label>
                    <input type="text" id="domicilio" name="domicilio" value="${domicilio}" required>
                </div>

                <div class="input-group">
                    <label for="departamento">Departamento:</label>
                    <input type="text" id="departamento" name="departamento" value="${departamento}" required>
                </div>

                <div class="input-group">
                    <label for="provincia">Provincia:</label>
                    <input type="text" id="provincia" name="provincia" value="${provincia}" required>
                </div>

                <div class="input-group">
                    <label for="distrito">Distrito:</label>
                    <input type="text" id="distrito" name="distrito" value="${distrito}" required>
                </div>

                <div class="input-group">
                    <label for="dni">DNI:</label>
                    <input type="number" id="dni" name="dni" value="${dni}" required>
                </div>

                <div class="input-group">
                    <label for="telefono">Teléfono:</label>
                    <input type="number" id="telefono" name="telefono" value="${telefono}" required>
                </div>

                <div class="input-group">
                    <label for="correo">Correo Electrónico:</label>
                    <input type="text" id="correo" name="correo" value="${correo}" required>
                </div>

                <div class="input-group">
                    <input type="checkbox" id="menor" name="menor" ${empty menor ? '' : 'checked'}>
                    <label for="menor">Soy menor de edad</label>
                </div>

                <h2>Identificación del bien contratado</h2>

   
                <label for="categoria">Tipo de bien contratado</label>                
                <select id="categoria" name="cboCategoria">
                    <option value="1" ${categoria.equals("1") ? 'selected' : ''}>Producto</option>
                    <option value="2" ${categoria.equals("2") ? 'selected' : ''}>Servicio</option>
                </select>

                <div class="input-group">
                    <label for="monto_reclamo">Monto del reclamo:</label>
                    <input type="number" id="monto_reclamo" name="monto_reclamo" value="${monto_reclamo}">
                </div>

                <h2>Detalle de la reclamación</h2>

                <div class="input-group">
                    <label for="tipo_reclamo">Tipo de reclamo:</label>
                    <select id="tipo_reclamo" name="tipo_reclamo">
                        <option value="1" ${tipo_reclamo.equals("1") ? 'selected' : ''}>Reclamo</option>
                        <option value="2" ${tipo_reclamo.equals("2") ? 'selected' : ''}>Queja</option>
                    </select>
                </div>

                <div class="input-group">
                    <label for="descripcion">Descripción:</label>
                    <textarea id="descripcion" name="descripcion" rows="4" required>${empty descripcion ? '' : descripcion}</textarea>
                </div>

                <div class="input-group">
                    <label for="imagen_reclamante">Adjuntar una imagen:NO debe ser mayor a 2MB</label>
                    <input type="file" id="imagen_reclamante" name="imagen_reclamante" accept="image/*">
                </div>

                <!-- Vista previa de la imagen -->
                <div class="input-group">
                    <label>Vista Previa de la Imagen:</label>
                    <img id="vista_previa" src="#" alt="Vista Previa" style="max-width: 300px; max-height: 300px;">
                </div>

                <div class="input-group">
                    <label for="pedido_consumidor">Pedido del consumidor:</label>
                    <textarea id="pedido_consumidor" name="pedido_consumidor" rows="4">${empty pedido_consumidor ? '' : pedido_consumidor}</textarea>
                </div>

                <h2>Observaciones y acciones adoptadas por el proveedor</h2>
                <p>MegaMatrix dará respuesta a su reclamo en un plazo no mayor de quince (15) días hábiles mediante correo electrónico o mediante una carta que se enviará a su domicilio.</p>

                <h2>Todos los campos son obligatorios.</h2>

                <h2>DECLARACIÓN</h2>
                <p class="declaracion">En aplicación a lo dispuesto por la Ley 29733 – Ley de Protección de datos personales y su Reglamento aprobado por D.S. N° 003-2013-JUS, el suscrito titular de los datos personales, mediante el llenado del presente formulario, autorizo de forma expresa e inequívoca y por tiempo indefinido que mis datos personales, sean tratados, almacenados, sistematizados y utilizados por ComunicaTEC, para fines estadísticos y administrativos, con el propósito de poder brindarme adecuada y oportunamente el servicio que he contratado o que me interese contratar, siendo que los datos serán conservados en un banco de datos cuyo titular es ComunicaTEC. Igualmente declaro conocer que para ejercer mis derechos como acceso, rectificación, cancelación y oposición y otros derechos sobre mis datos, puedo dirigirme a las oficinas ubicadas en Av. Angamos Oeste 120, Miraflores y/o al e-mail comunicatec@gmail.com. Declaro conocer los alcances de la Ley 29733 y su Reglamento, para ejercer mis derechos conforme a Ley.</p>

                <div class="input-group">
                    <label for="respuesta_direccion">Deseo recibir la respuesta en mi dirección física:</label>
                    <input type="checkbox" id="respuesta_direccion" name="respuesta_direccion" value="Si" ${empty respuesta_direccion ? '' : 'checked'}>
                </div>

                <div class="input-group">
                    <input type="submit" value="Enviar Reclamación" name="accion">
                </div>
            </form>
        </div>
    </body>
    <jsp:include page="footer.jsp" />
</html>

