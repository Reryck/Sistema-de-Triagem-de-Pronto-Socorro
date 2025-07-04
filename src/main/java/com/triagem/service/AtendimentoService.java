package com.triagem.service;

import com.triagem.model.Paciente;
import com.triagem.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtendimentoService {
    
    @Autowired
    private PacienteRepository pacienteRepository;
    
    @Autowired
    private MedicoService medicoService;
    
    public Paciente obterProximoPaciente() {
        if (!medicoService.existemMedicosEmPlantao()) {
            throw new RuntimeException("Não há médicos em plantão");
        }
        
        return pacienteRepository.findPacientesAguardandoAtendimento()
            .stream()
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Não há pacientes aguardando atendimento"));
    }
} 