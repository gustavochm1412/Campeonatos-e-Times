package com.campeonato.controller;

import com.campeonato.model.Campeonato;
import com.campeonato.repository.CampeonatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campeonatos")
public class CampeonatoController {
    
    @Autowired
    private CampeonatoRepository campeonatoRepository;
    
    @GetMapping
    public List<Campeonato> listarTodos() {
        return campeonatoRepository.findAll();
    }
    
    @PostMapping
    public Campeonato criar(@RequestBody Campeonato campeonato) {
        return campeonatoRepository.save(campeonato);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Campeonato> buscarPorId(@PathVariable Long id) {
        return campeonatoRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
} 