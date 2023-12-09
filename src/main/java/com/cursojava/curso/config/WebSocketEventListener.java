package com.cursojava.curso.config;

import com.cursojava.curso.controllers.ChatMessage;
import com.cursojava.curso.controllers.MessageType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

/**
 * El oyente de eventos escucha eventos de desconexión de sesiones WebSocket.
 * Cuando un usuario se desconecta, se dispara un evento y este oyente se encarga de manejarlo.
 */

@Component
@RequiredArgsConstructor
@Slf4j
    public class WebSocketEventListener {
    private final SimpMessageSendingOperations messageTemplate;

    public void hadleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        // Obtiene los encabezados del mensaje WebSocket
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        // Extrae el nombre de usuario de los atributos de la sesión
        String username = (String) headerAccessor.getSessionAttributes().get("username");

        /**
         * Cuando se detecta una desconexión, el oyente puede acceder al controlador de chat o directamente
         * a través de un servicio para notificar a otros participantes sobre la desconexión.
         */

        // Verifica si se ha proporcionado un nombre de usuario válido
        if (username != null) {
            // Registra la desconexión del usuario en el registro
            log.info("Usuario desconectado: {}", username);

            // Crea un mensaje de chat de tipo "LEAVE" para notificar la desconexión del usuario
            var chatMessage = ChatMessage.builder()
                    .type(MessageType.LEAVE)
                    .sender(username)
                    .build();

            // Envía el mensaje a través de WebSocket a un tema específico para informar a otros usuarios
            messageTemplate.convertAndSend("/topic/public", chatMessage);
        }//Fin if
    }//Fin hadleWebSocketDisconnectListener
}//Fin WebSocketEventListener
