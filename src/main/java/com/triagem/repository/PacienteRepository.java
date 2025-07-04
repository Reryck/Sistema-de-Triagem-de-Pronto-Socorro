package com.triagem.repository;

import com.triagem.model.Paciente;
import com.triagem.model.enums.Prioridade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    
    @Query("SELECT p FROM Paciente p WHERE p.emAtendimento = false ORDER BY " +
           "CASE p.prioridade " +
           "WHEN 'VERMELHA' THEN 1 " +
           "WHEN 'AMARELA' THEN 2 " +
           "WHEN 'VERDE' THEN 3 " +
           "END ASC, " +
           "CASE p.gravidade " +
           "WHEN 'GRAVE' THEN 1 " +
           "WHEN 'MODERADA' THEN 2 " +
           "WHEN 'LEVE' THEN 3 " +
           "END ASC, " +
           "p.dataTriagem ASC")
    List<Paciente> findPacientesAguardandoAtendimento();
    
    List<Paciente> findByPrioridadeOrderByDataTriagem(Prioridade prioridade);
} 