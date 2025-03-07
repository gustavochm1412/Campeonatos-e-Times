package com.campeonato.controller;

import com.campeonato.model.Time;
import com.campeonato.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/times")
public class TimeController {
    
    @Autowired
    private TimeRepository timeRepository;
    
    @GetMapping
    public List<Time> listarTodos() {
        return timeRepository.findAll();
    }
    
    @PostMapping
    public Time criar(@RequestBody Time time) {
        return timeRepository.save(time);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Time> buscarPorId(@PathVariable Long id) {
        return timeRepository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
} 