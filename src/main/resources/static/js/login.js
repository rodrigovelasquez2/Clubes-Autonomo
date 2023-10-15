// Esta función se llama cuando el DOM se ha cargado completamente y está listo.
$(document).ready(function () {
    // TODO: Coloca aquí el código que debe ejecutarse cuando el DOM esté listo.
});

// Esta función asincrónica maneja el inicio de sesión de usuarios.
async function iniciarSesion() {
    // Crea un objeto para almacenar los datos del usuario.
    let datos = {};
    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;

    // Envía una solicitud POST al servidor (similar al método 'login' del AuthController).
    const request = await fetch('api/login', {
        method: 'POST',
        headers: {
            // Indica que estamos enviando y esperando datos en formato JSON.
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos) // Convierte el objeto de datos a una cadena JSON.
    });

    // Espera la respuesta del servidor.
    const respuesta = await request.text(); // Obtiene una lista de usuarios.

    // Comprueba si el inicio de sesión fue exitoso.
    if (respuesta != 'FAIL') {
        // Si es exitoso, almacena el token JWT y el correo del usuario en el almacenamiento local.
        localStorage.token = respuesta;
        localStorage.email = datos.email;
        // Redirige al usuario a la página 'usuarios.html'.
        window.location.href = 'usuarios.html';
    } else {
        // Muestra un mensaje de error si el inicio de sesión falla.
        alert("Usuario o contraseña incorrectos. ¡Por favor, ingrese la información correcta!");
    }// Fin del bloque 'else'.
}// Fin de la función 'iniciarSesion'
