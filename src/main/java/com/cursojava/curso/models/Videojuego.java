package com.cursojava.curso.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "Videojuegos")
@Data @RequiredArgsConstructor
@AllArgsConstructor
public class Videojuego {

    @Id
    private String id;

    private String title;

    private String description;

    private String urlVideo;
}
