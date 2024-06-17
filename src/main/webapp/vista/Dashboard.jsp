<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/css/dashboardCSS.css">
    <script src="<%= request.getContextPath() %>/js/Dashboardjs.js" defer></script>
</head>
<body>
    <div class="menu-dashboard">
        <div class="top-menu">
            <div class="logo">
                <img src="<%= request.getContextPath() %>/img/Mgamatrixfalt.png" alt="">
                <span>Megamatrix</span>
            </div>
            <div class="toggle">
                <i class='bx bx-menu'></i>
            </div>
        </div>
        <div class="menu">
            <div class="enlace">
                <i class='bx bxs-dashboard'></i>
                <span>Resumen General</span>
            </div>
            <div class="enlace">
                <i class='bx bxs-box'></i>
                <span>Gestión de Productos</span>
            </div>
            <div class="enlace">
                <i class='bx bxs-cart'></i>
                <span>Gestión de Pedidos</span>
            </div>
            <div class="enlace">
                <i class='bx bxs-message-dots'></i>
                <span>Atención al Cliente</span>
            </div>
            <div class="enlace">
                <i class='bx bxs-wrench'></i>
                <span>Gestión de Servicios</span>
            </div>
            <div class="enlace">
                <i class='bx bxs-discount'></i>
                <span>Promociones y Descuentos</span>
            </div>
            <div class="enlace">
                <i class='bx bxs-bar-chart-square'></i>
                <span>Reportes y Estadísticas</span>
            </div>
            <div class="enlace">
                <i class='bx bxs-user'></i>
                <span>Gestión de Clientes</span>
            </div>
        </div>
    </div>
</body>
</html>
