package com.campeonato.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    @ManyToMany(mappedBy = "times")
    private Set<Campeonato> campeonatos = new HashSet<>();
    
    public Time() {}
    
    // Getters e Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Set<Campeonato> getCampeonatos() {
        return campeonatos;
    }
    
    public void setCampeonatos(Set<Campeonato> campeonatos) {
        this.campeonatos = campeonatos;
    }
} 