package com.triagem.dto;

import jakarta.validation.constraints.*;

public class MedicoRequest {
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    
    @NotBlank(message = "Especialidade é obrigatória")
    private String especialidade;
    
    @NotBlank(message = "CRM é obrigatório")
    @Pattern(regexp = "\\d{5,6}", message = "CRM deve ter 5 ou 6 dígitos")
    private String crm;

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }
    
    public String getCrm() { return crm; }
    public void setCrm(String crm) { this.crm = crm; }
} 