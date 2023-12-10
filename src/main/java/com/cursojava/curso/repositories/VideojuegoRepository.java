package com.cursojava.curso.repositories;

import com.cursojava.curso.models.Videojuego;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideojuegoRepository extends JpaRepository<Videojuego, String> {
}
