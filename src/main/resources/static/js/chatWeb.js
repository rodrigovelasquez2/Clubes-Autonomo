'use strict';

var usernamePage = document.querySelector('#username-page');
var chatPage = document.querySelector('#chat-page');
var usernameForm = document.querySelector('#usernameForm');
var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#message');
var messageArea = document.querySelector('#messageArea');
var connectingElement = document.querySelector('.connecting');

var stompClient = null;
var username = null;

var colors = [
    '#2196F3', '#32c787', '#00BCD4', '#ff5652',
    '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];

/**
 * Se emplea la biblioteca Stomp.js en JavaScript para configurar la conexión WebSocket con el servidor Spring Boot.
 * Se crea un cliente Stomp utilizando Stomp.client para conectarse al servidor WebSocket.
 * La conexión se inicia con client.connect en la URL especificada, que corresponde al punto final WebSocket registrado en la configuración del servidor.
 * @param event
 */

function connect(event) {
    var token = localStorage.getItem('token'); // Obtienes el token
    var tokenEmail = localStorage.getItem('email'); // Obtienes el token

    if(token !=null && tokenEmail!=null){
        username=tokenEmail;
        if(username) { // si el usuario es true
            usernamePage.classList.add('hidden');
            chatPage.classList.remove('hidden'); // Se activa la pestaña del chat web

            var socket = new SockJS('/ws');
            stompClient = Stomp.over(socket); // Crea un nuevo cliente que se conectara al servidor
            stompClient.connect({}, onConnected, onError);
        }
    }else{
        alert("No se recibio el token");
    }
    event.preventDefault();
}//fin Connect

/**
 * Para recibir mensajes del servidor, se utilizan suscripciones a canales específicos.
 * El método client.subscribe se utiliza para suscribirse a un canal, como "/topic/public",
 * que es donde se envían los mensajes de chat públicos.
 * Cuando se recibe un mensaje en un canal al que se está suscrito, se activa una función de devolución de llamada.
 * Esto permite procesar y mostrar los mensajes en la interfaz de usuario en tiempo real.
 */
function onConnected() {
    // Subscribe to the Public Topic
    stompClient.subscribe('/topic/public', onMessageReceived);
    // Tell your username to the server
    stompClient.send("/app/chat.addUser",
        {},
        JSON.stringify({sender: username, type: 'JOIN'})
    )
    connectingElement.classList.add('hidden');
}//Fin onConnected
function onError(error) {
    connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
    connectingElement.style.color = 'red';
}//Fin onError

/**
 * El método sendMessage se utiliza para enviar mensajes al servidor.
 * Puede acceder al controlador de chat a través de la conexión WebSocket y enviar el mensaje.
 * @param event
 */
function sendMessage(event) {
    var messageContent = messageInput.value.trim();
    if(messageContent && stompClient) { // Valida el mensaje y el nuevo cliente registrado por StompCliente en el WebSocket
        var chatMessage = {
            sender: username,
            content: messageInput.value,
            type: 'CHAT'
        };
        stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage)); //Envía un mensaje a través de la conexión WebSocket
        messageInput.value = '';
    }
    event.preventDefault();
}//Fin sendMessage

/**
 * El método onMessageReceived se utiliza para manejar los mensajes recibidos del servidor.
 * Cuando se recibe un mensaje, este método se dispara y puede mostrar el mensaje en la interfaz de usuario.
 * @param payload
 */
function onMessageReceived(payload) {
    var message = JSON.parse(payload.body);
    var messageElement = document.createElement('li');
    if(message.type === 'JOIN') {
        messageElement.classList.add('event-message');
        message.content = message.sender + ' joined!';
    } else if (message.type === 'LEAVE') {
        messageElement.classList.add('event-message');
        message.content = message.sender + ' left!';
    } else {
        messageElement.classList.add('chat-message');
        var avatarElement = document.createElement('i');
        var avatarText = document.createTextNode(message.sender[0]);
        avatarElement.appendChild(avatarText);
        avatarElement.style['background-color'] = getAvatarColor(message.sender);
        messageElement.appendChild(avatarElement);
        var usernameElement = document.createElement('span');
        var usernameText = document.createTextNode(message.sender);
        usernameElement.appendChild(usernameText);
        messageElement.appendChild(usernameElement);
    }
    var textElement = document.createElement('p');
    var messageText = document.createTextNode(message.content);
    textElement.appendChild(messageText);
    messageElement.appendChild(textElement);
    messageArea.appendChild(messageElement);
    messageArea.scrollTop = messageArea.scrollHeight;
}

/**
 * Funcion que añade nuevos iconos de colores por cada usuario conectado
 * @param messageSender
 * @returns {string}
 */
function getAvatarColor(messageSender) {
    var hash = 0;
    for (var i = 0; i < messageSender.length; i++) {
        hash = 31 * hash + messageSender.charCodeAt(i);
    }
    var index = Math.abs(hash % colors.length);
    return colors[index];
}
usernameForm.addEventListener('submit', connect, true)
messageForm.addEventListener('submit', sendMessage, true)