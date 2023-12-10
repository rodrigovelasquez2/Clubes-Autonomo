package com.cursojava.curso.services;

import com.cursojava.curso.models.Videojuego;
import com.cursojava.curso.repositories.VideojuegoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VideojuegoService {

    private final VideojuegoRepository videojuegoRepository;

    public Videojuego save(Videojuego videojuego) {
        return this.videojuegoRepository.save(videojuego);
    }

    public List<Videojuego> findAll() {
        return this.videojuegoRepository.findAll();
    }

    public List<Videojuego> saveAll(List<Videojuego> videojuegos) {
        return this.videojuegoRepository.saveAll(videojuegos);
    }

    public Videojuego findById(String id) {
        return this.videojuegoRepository.findById(id)
                .orElseGet(Videojuego::new);
    }
}
