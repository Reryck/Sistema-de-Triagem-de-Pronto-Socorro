package com.triagem.controller;

import com.triagem.dto.TriagemRequest;
import com.triagem.model.Paciente;
import com.triagem.service.TriagemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TriagemController {
    
    @Autowired
    private TriagemService triagemService;
    
    @PostMapping("/triagem")
    public ResponseEntity<Paciente> realizarTriagem(@Valid @RequestBody TriagemRequest request) {
        Paciente paciente = triagemService.realizarTriagem(request);
        return ResponseEntity.ok(paciente);
    }
    
    @GetMapping("/pacientes")
    public ResponseEntity<List<Paciente>> listarPacientes() {
        List<Paciente> pacientes = triagemService.listarTodosPacientes();
        return ResponseEntity.ok(pacientes);
    }
    
    @GetMapping("/pacientes/{id}")
    public ResponseEntity<Paciente> buscarPaciente(@PathVariable Long id) {
        Paciente paciente = triagemService.buscarPacientePorId(id);
        return ResponseEntity.ok(paciente);
    }
} 