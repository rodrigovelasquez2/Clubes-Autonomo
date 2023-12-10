package com.cursojava.curso.controllers;

import com.cursojava.curso.models.Videojuego;
import com.cursojava.curso.services.VideojuegoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class VideojuegoController {

    private final VideojuegoService videojuegoService;

    @GetMapping("/{id}")
    public ResponseEntity<Videojuego> findById(@PathVariable String id) {
        return ResponseEntity.ok(this.videojuegoService.findById(id));
    }

    @PostMapping("/save-all")
    public ResponseEntity<List<Videojuego>> saveAll(@RequestBody List<Videojuego> videojuegos) {
        return ResponseEntity.ok(this.videojuegoService.saveAll(videojuegos));
    }

    @PostMapping("/save")
    public ResponseEntity<Videojuego> save(@RequestBody Videojuego videojuego) {
        return ResponseEntity.ok(this.videojuegoService.save(videojuego));
    }
}
