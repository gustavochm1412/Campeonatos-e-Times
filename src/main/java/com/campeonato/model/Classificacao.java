package com.campeonato.model;

import jakarta.persistence.*;

@Entity
public class Classificacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "campeonato_id")
    private Campeonato campeonato;
    
    @ManyToOne
    @JoinColumn(name = "time_id")
    private Time time;
    
    private Integer pontos;
    private Integer posicao;
    
    public Classificacao() {}
    
    // Getters e Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Campeonato getCampeonato() {
        return campeonato;
    }
    
    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }
    
    public Time getTime() {
        return time;
    }
    
    public void setTime(Time time) {
        this.time = time;
    }
    
    public Integer getPontos() {
        return pontos;
    }
    
    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }
    
    public Integer getPosicao() {
        return posicao;
    }
    
    public void setPosicao(Integer posicao) {
        this.posicao = posicao;
    }
} 