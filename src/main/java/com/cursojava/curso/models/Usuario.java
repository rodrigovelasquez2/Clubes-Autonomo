package com.cursojava.curso.models;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author Rodrigo Andres Velasquez Quiroz
 * @date 28/09/23
 */
@Entity
@Table(name = "usuarios")

@Data //Incluye anotaciones de get and set
@Builder //
@EqualsAndHashCode

//Constructores
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String rol;
}//Fin Usuario
