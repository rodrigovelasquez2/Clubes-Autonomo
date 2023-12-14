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

    // Verifica si los campos de correo electrónico y contraseña están vacíos.
    // Envía una solicitud POST al servidor (similar al método 'login' del AuthController).
    const request = await fetch('/api/login', {
        method: 'POST',
        headers: {
            // Indica que estamos enviando y esperando datos en formato JSON.
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos) // Convierte el objeto de datos a una cadena JSON.
    });

    // Espera la respuesta del servidor.
    const respuesta = await request.text(); // Suponiendo que 'request' es tu solicitud y obtienes una respuesta en texto.
    //alert("RESPUESTA: "+respuesta);
    const respuestaJSON = JSON.parse(respuesta); // Convertimos el texto a un objeto JSON
    const tokenJWT = respuestaJSON.tokenJWT; // Accedemos a la propiedad 'tokenJWT' del objeto JSON
    const rol = respuestaJSON.usuario.rol;

    alert("RESPUESTA: "+respuesta + "RESPUESTA JSON: "+respuestaJSON + "TOKEN JWT: "+tokenJWT + "RESPUESTA JSON.mensaje: "+respuestaJSON.mensaje);
    alert("ROL" + rol);
    // Comprueba si el inicio de sesión fue exitoso.
    if (respuestaJSON.mensaje === "FAIL") {
        alert("Usuario o contraseña incorrectos. ¡Por favor, ingrese la información correcta!");
        return;
        //alert(respuesta);
    } if (rol === "ADMINISTRADOR") {
        // Si es exitoso, almacena el token JWT y el correo del usuario en el localStorage para el chat web
        localStorage.token = tokenJWT;
        localStorage.email = datos.email;
        window.location.href = 'usuarios.html';
    } else if (rol === "USUARIO") {
        // Si es exitoso, almacena el token JWT y el correo del usuario en el localStorage para el chat web
        localStorage.token = tokenJWT;
        localStorage.email = datos.email;
        // Redirige al usuario a la página 'maingPage.html';
        window.location.href = 'mainPage.html';
        //alert("Usuario registrado!");

        //Pruebas de variables
        // console.log("RESPUESTA JSON"+ respuestaJSON);
        // console.log("RESPUESTA JSON.mensaje"+ respuestaJSON.mensaje);
        // console.log("RESPUESTA"+respuesta);
    }

}// Fin de la función 'iniciarSesion'