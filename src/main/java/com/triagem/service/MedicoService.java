package com.triagem.service;

import com.triagem.dto.MedicoRequest;
import com.triagem.model.Medico;
import com.triagem.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {
    
    @Autowired
    private MedicoRepository medicoRepository;
    
    public Medico cadastrarMedico(MedicoRequest request) {
        if (medicoRepository.existsByCrm(request.getCrm())) {
            throw new RuntimeException("CRM já cadastrado");
        }
        
        Medico medico = new Medico(
            request.getNome(),
            request.getEspecialidade(),
            request.getCrm()
        );
        
        return medicoRepository.save(medico);
    }
    
    public List<Medico> listarTodosMedicos() {
        return medicoRepository.findAll();
    }
    
    public Medico buscarMedicoPorId(Long id) {
        return medicoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Médico não encontrado"));
    }
    
    public Medico atualizarStatusPlantao(Long id, Boolean emPlantao) {
        Medico medico = medicoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Médico não encontrado"));
        
        medico.setEmPlantao(emPlantao);
        return medicoRepository.save(medico);
    }
    
    public boolean existemMedicosEmPlantao() {
        return !medicoRepository.findByEmPlantaoTrue().isEmpty();
    }
} 