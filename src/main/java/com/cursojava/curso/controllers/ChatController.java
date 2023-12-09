package com.cursojava.curso.controllers;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    /**
     * El método sendMessage se llama cuando un usuario envía un mensaje.
     * El controlador procesa el mensaje y lo distribuye a todos
     * los demás participantes conectados a través de la conexión WebSocket.
     * @param chatMessague
     * @return El mensaje del usuario
     */
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessague) {
        return chatMessague;
    }//Fin ChatMessage

    /**
     * 	El método addUser podría ser llamado cuando un nuevo usuario se une al chat.
     * 	Recibirá información sobre el nuevo usuario y podría notificar a
     * 	otros participantes que un nuevo usuario se ha unido.
     * @param chatMessage
     * @param headerAccessor
     * @return El mensaje del usuario
     */
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        //Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
}//Fin ChatController
