// Call the dataTables jQuery plugin
$(document).ready(function () {
// TODO CODE ALL HERE
});
async function registrarUsuario() {
    //Guarda lo capturado al array Datos
    let datos = {};
    datos.nombre = document.getElementById('txtNombre').value;
    datos.apellido = document.getElementById('txtApellido').value;
    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;

    // Validación de campos en blanco
    if ( datos.nombre === '' || datos.apellido === '' || datos.email === '' || datos.password === ''){
        alert('Por favor, completa todos los campos.');
    }else{
        let repetirPassword = document.getElementById('txtRepetirPassword').value;

        if (repetirPassword != datos.password) {
            alert('La contraseña que escribiste es diferente.');
            return; //Corta la función
        }
        // el fetch se coloca tal cual en el AuthController de UsuarioController
        const request = await fetch('api/usuarios', {//await: Esperar el resultado
            method: 'POST',
            headers: {
                //Indica que usara Json
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(datos)// Llama a la funcion y agarra cualquier objeto a string de JSON
        });
        const respuesta = await request.text(); // Suponiendo que 'request' es tu solicitud y obtienes una respuesta en texto.
        alert(respuesta);

        alert("La cuenta fue creada con exito!");
        window.location.href = 'index.html' // Posible cambiarlo

    }//Fin if



}//Fin cargarUsuarios
