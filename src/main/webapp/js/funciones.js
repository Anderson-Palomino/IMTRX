$(document).ready(function () {
    $(".btnDelete").click(function () {
        var idp = $(this).data("idp").val();
        eliminar(idp);
    });

    function eliminar(idp) {
        $.ajax({
            type: 'POST',
            url: 'SVProductos',
            data: { accion: 'Delete', idp: idp },
            success: function (data, textStatus, jqXHR) {
                alert("Registro eliminado");
                location.reload(); // Opcional: recarga la página para reflejar los cambios
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("Error al eliminar el registro");
            }
        });
    }
});
