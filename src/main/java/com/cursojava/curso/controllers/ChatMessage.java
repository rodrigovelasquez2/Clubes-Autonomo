package com.cursojava.curso.controllers;
import lombok.*;

/**
 * El chat message contiene las variables con las que el usuario interactuara con el sistema
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {
    private String content;
    private String sender;
    private MessageType type;
}//ChatMessage
