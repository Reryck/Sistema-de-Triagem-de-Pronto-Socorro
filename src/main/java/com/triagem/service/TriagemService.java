package com.triagem.service;

import com.triagem.dto.TriagemRequest;
import com.triagem.model.Paciente;
import com.triagem.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TriagemService {
    
    @Autowired
    private PacienteRepository pacienteRepository;
    
    public Paciente realizarTriagem(TriagemRequest request) {
        Paciente paciente = new Paciente(
            request.getNome(),
            request.getIdade(),
            request.getSintomas(),
            request.getPrioridade(),
            request.getGravidade()
        );
        
        return pacienteRepository.save(paciente);
    }
    
    public List<Paciente> listarTodosPacientes() {
        return pacienteRepository.findAll();
    }
    
    public Paciente buscarPacientePorId(Long id) {
        return pacienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
    }
} 