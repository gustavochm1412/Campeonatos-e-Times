package com.campeonato.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Campeonato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    
    @ManyToMany
    @JoinTable(
        name = "campeonato_time",
        joinColumns = @JoinColumn(name = "campeonato_id"),
        inverseJoinColumns = @JoinColumn(name = "time_id")
    )
    private Set<Time> times = new HashSet<>();
    
    @OneToMany(mappedBy = "campeonato", cascade = CascadeType.ALL)
    private Set<Classificacao> classificacoes = new HashSet<>();
    
    public Campeonato() {}
    
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
    
    public LocalDate getDataInicial() {
        return dataInicial;
    }
    
    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }
    
    public LocalDate getDataFinal() {
        return dataFinal;
    }
    
    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }
    
    public Set<Time> getTimes() {
        return times;
    }
    
    public void setTimes(Set<Time> times) {
        this.times = times;
    }
    
    public Set<Classificacao> getClassificacoes() {
        return classificacoes;
    }
    
    public void setClassificacoes(Set<Classificacao> classificacoes) {
        this.classificacoes = classificacoes;
    }
} 