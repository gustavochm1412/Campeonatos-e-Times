package com.campeonato.controller;

import com.campeonato.model.Classificacao;
import com.campeonato.repository.ClassificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/classificacoes")
public class ClassificacaoController {
    
    @Autowired
    private ClassificacaoRepository classificacaoRepository;
    
    @PutMapping("/{id}/pontos")
    public ResponseEntity<Classificacao> atualizarPontos(
            @PathVariable Long id,
            @RequestParam Integer pontos) {
        return classificacaoRepository.findById(id)
            .map(classificacao -> {
                classificacao.setPontos(pontos);
                return ResponseEntity.ok(classificacaoRepository.save(classificacao));
            })
            .orElse(ResponseEntity.notFound().build());
    }
} 