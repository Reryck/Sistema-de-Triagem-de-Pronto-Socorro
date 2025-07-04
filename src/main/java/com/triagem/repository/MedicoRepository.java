package com.triagem.repository;

import com.triagem.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    
    List<Medico> findByEmPlantaoTrue();
    
    boolean existsByCrm(String crm);
} 