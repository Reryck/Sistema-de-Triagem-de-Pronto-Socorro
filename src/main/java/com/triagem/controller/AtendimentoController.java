package com.triagem.controller;

import com.triagem.model.Paciente;
import com.triagem.service.AtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/atendimento")
public class AtendimentoController {
    
    @Autowired
    private AtendimentoService atendimentoService;
    
    @GetMapping("/proximo")
    public ResponseEntity<Paciente> obterProximoPaciente() {
        Paciente paciente = atendimentoService.obterProximoPaciente();
        return ResponseEntity.ok(paciente);
    }
} 