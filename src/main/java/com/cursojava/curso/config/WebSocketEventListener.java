package com.cursojava.curso.config;

import com.cursojava.curso.controllers.ChatMessage;
import com.cursojava.curso.controllers.MessageType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@RequiredArgsConstructor
@Slf4j
public class WebSocketEventListener {
    private final SimpMessageSendingOperations messageTemplate;
    public void hadleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) headerAccessor.getSessionAttributes().get("username");

        if (username != null) {
            log.info("User disconnected: {}", username);
            var chatMessague = ChatMessage.builder()
                    .type(MessageType.LEAVE)
                    .sender("username")
                    .build();
            messageTemplate.convertAndSend("/topic/public",chatMessague);


        }//Fin if
    }//Fin hadleWebSocketDisconnectListener
}//Fin WebSocketEventListener
