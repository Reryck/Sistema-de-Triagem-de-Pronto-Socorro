package com.triagem.controller;

import com.triagem.dto.MedicoRequest;
import com.triagem.model.Medico;
import com.triagem.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MedicoController {
    
    @Autowired
    private MedicoService medicoService;
    
    @PostMapping("/medicos")
    public ResponseEntity<Medico> cadastrarMedico(@Valid @RequestBody MedicoRequest request) {
        Medico medico = medicoService.cadastrarMedico(request);
        return ResponseEntity.ok(medico);
    }
    
    @GetMapping("/medicos")
    public ResponseEntity<List<Medico>> listarMedicos() {
        List<Medico> medicos = medicoService.listarTodosMedicos();
        return ResponseEntity.ok(medicos);
    }
    
    @GetMapping("/medicos/{id}")
    public ResponseEntity<Medico> buscarMedicoPorId(@PathVariable Long id) {
        Medico medico = medicoService.buscarMedicoPorId(id);
        return ResponseEntity.ok(medico);
    }
    
    @PutMapping("/medicos/{id}/plantao")
    public ResponseEntity<Medico> atualizarStatusPlantao(
            @PathVariable Long id,
            @RequestParam Boolean emPlantao) {
        Medico medico = medicoService.atualizarStatusPlantao(id, emPlantao);
        return ResponseEntity.ok(medico);
    }
} 