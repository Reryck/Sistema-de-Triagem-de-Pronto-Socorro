package com.triagem.config;

import com.triagem.model.Medico;
import com.triagem.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private MedicoRepository medicoRepository;
    
    @Override
    public void run(String... args) throws Exception {
        // Verificar se já existem médicos cadastrados
        if (medicoRepository.count() == 0) {
            // Cadastrar médicos iniciais
            Medico medico1 = new Medico("Dr. João Silva", "Clínico Geral", "12345");
            medico1.setEmPlantao(true);
            medicoRepository.save(medico1);
            
            Medico medico2 = new Medico("Dra. Maria Santos", "Cardiologia", "54321");
            medico2.setEmPlantao(true);
            medicoRepository.save(medico2);
            
            Medico medico3 = new Medico("Dr. Pedro Oliveira", "Ortopedia", "67890");
            medico3.setEmPlantao(false);
            medicoRepository.save(medico3);
            
            System.out.println("Médicos iniciais cadastrados com sucesso!");
        }
    }
} 