package com.cursojava.curso.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

//Clase de configuración para WebSocket
/**
 *	En esta clase, el método configureMessageBroker define cómo se van a manejar los mensajes y canales en la aplicación.
 *  Por ejemplo, se puede establecer un prefijo para los canales de mensajes,
 *  como "/app" o "/topic", que se utilizarán para enrutar los mensajes a los controladores apropiados.
 *
 */
@Configuration //Habilita la funcionalidad de WebSockets en la aplicación Spring
@EnableWebSocketMessageBroker //Permite la comunicación en tiempo real a través de WebSockets.
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    /**
     El método registerStompEndpoints registra un punto final WebSocket ("/chat" en este caso)
     que permite a los clientes conectarse al servidor WebSocket.
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();
    }//Fin registerStompEndpoints

    /**
     * Configura el broker de mensajes para la manipulación de la mensajería en la aplicación.
     * Establece un prefijo de destino de aplicación y habilita un broker simple.
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/topic");
    }//Fin configureMessageBroker
}//Fin WebSocketConfig
