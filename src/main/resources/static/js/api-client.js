// api-client.js
const urlEndpoint = 'http://localhost:8087/api';
// Función para realizar una solicitud GET por ID
async function getVideojuegoById(id) {
    const response = await fetch(`${urlEndpoint}/${id}`);
    return await response.json();
}

// Función para realizar una solicitud POST para guardar un solo videojuego
async function saveVideojuego(videojuego) {
    const response = await fetch(`${urlEndpoint}/api/save`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(videojuego),
    });
    return await response.json();
}

// Función para realizar una solicitud POST para guardar varios videojuegos
async function saveAllVideojuegos(videojuegos) {
    const response = await fetch(`${urlEndpoint}/save-all`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(videojuegos),
    });
    return await response.json();
}

// Ejemplos de uso
// const videojuego = { /* datos de tu videojuego */ };
// saveVideojuego(videojuego).then(response => console.log(response));

// const videojuegos = [/* lista de videojuegos */];
// saveAllVideojuegos(videojuegos).then(response => console.log(response));

// const id = /* ID del videojuego */;
// getVideojuegoById(id).then(response => console.log(response));