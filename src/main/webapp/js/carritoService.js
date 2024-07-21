function agregarAlCarrito(producto) {
    const memoria = JSON.parse(localStorage.getItem("celulares"));
    console.log(memoria);

    let cuenta = 0;
    if (!memoria) {
        const nuevoProducto = getNuevoProductoParaMemoria(producto);
        localStorage.setItem("celulares", JSON.stringify([nuevoProducto]));
        cuenta = 1;

    } else {
        const indiceProducto = memoria.findIndex(celular => celular.id === producto.id);
        console.log(indiceProducto)
        const nuevaMemoria = memoria;
        if (indiceProducto === -1) {
            nuevaMemoria.push(getNuevoProductoParaMemoria(producto));
            cuenta = 1;

        } else {
            if (nuevaMemoria[indiceProducto].stock > 0) {
                nuevaMemoria[indiceProducto].cantidad++;
                cuenta = nuevaMemoria[indiceProducto].cantidad;
                //Restar menos uno al stock cuando agregas
                nuevaMemoria[indiceProducto].stock--;
            }

        }
        localStorage.setItem("celulares", JSON.stringify(nuevaMemoria));
    }

    actualizarNumeroCarrito();
    return cuenta;
}


function restarAlCarrito(producto) {
    const memoria = JSON.parse(localStorage.getItem("celulares"));
    const indiceProducto = memoria.findIndex(celular => celular.id === producto.id);
    if (memoria[indiceProducto].cantidad === 1) {
        memoria.splice(indiceProducto, 1);
        memoria.stock++;
    } else {
        memoria[indiceProducto].cantidad--;
        memoria[indiceProducto].stock++;
    }
    localStorage.setItem("celulares", JSON.stringify(memoria));
    actualizarNumeroCarrito();
}

/** toma un producto, le agrega cantidad 1 y lo devuelve */
function getNuevoProductoParaMemoria(producto) {
    const nuevoProducto = producto;
    nuevoProducto.cantidad = 1;
    return nuevoProducto;
}

const cuentaCarritoElement = document.getElementById("cuenta-carrito");

function actualizarNumeroCarrito() {
    const memoria = JSON.parse(localStorage.getItem("celulares"));
    if (memoria && memoria.length > 0) {
        const cuenta = memoria.reduce((acum, current) => acum + current.cantidad, 0);
        cuentaCarritoElement.innerText = cuenta;
        console.log(cuenta);
    } else {
        cuentaCarritoElement.innerHTML = 0;
    }
}

actualizarNumeroCarrito();

function enviarLocalStorageAlServidor() {
    // Obtener el array de objetos del localStorage y convertirlo a un array de JavaScript
    var celulares = JSON.parse(localStorage.getItem("celulares")) || [];

    // Realizar la solicitud AJAX con el array de objetos
    $.ajax({
        type: "POST",
        url: "./obtenerLocalStorage.php",
        data: { celulares: celulares },
        success: function(response) {
            // Puedes hacer algo con la respuesta si es necesario
            console.log(response);
        }
    });
}

enviarLocalStorageAlServidor();