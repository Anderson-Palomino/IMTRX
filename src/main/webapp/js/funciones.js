async function documentGa(idp) {
    // URL de la petición
    let url = "SVProductos";
    
    // Configuración de la petición
    let options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: 'idp=' + encodeURIComponent(idp) + '&accion=Delete'
    };
    
    // Mostrar la alerta de confirmación
    swal({
        title: "Are you sure?",
        text: "Once deleted, you will not be able to recover this imaginary file!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
    .then(async (willDelete) => {
        if (willDelete) {
            try {
                // Realizar la petición
                let response = await fetch(url, options);
                
                // Verificar si la respuesta es correcta
                if (response.ok) {
                    swal("Poof! Your imaginary file has been deleted!", {
                        icon: "success",
                    });
                } else {
                    swal("Ocurrió un problema", {
                        icon: "error",
                    });
                }
                
                // Recargar la página para reflejar los cambios
                location.reload();
                
            } catch (error) {
                // Manejo de errores
                swal("Ocurrió un problema", {
                    icon: "error",
                });
                location.reload(); // Opcional: recarga la página para reflejar los cambios
            }
        } else {
            swal("Your imaginary file is safe!");
        }
    });
}
