package com.triagem.dto;

import com.triagem.model.enums.Prioridade;
import com.triagem.model.enums.Gravidade;
import jakarta.validation.constraints.*;

public class TriagemRequest {
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    
    @NotNull(message = "Idade é obrigatória")
    @Min(value = 0, message = "Idade deve ser maior ou igual a 0")
    @Max(value = 150, message = "Idade deve ser menor ou igual a 150")
    private Integer idade;
    
    @NotBlank(message = "Sintomas são obrigatórios")
    private String sintomas;
    
    @NotNull(message = "Prioridade é obrigatória")
    private Prioridade prioridade;
    
    @NotNull(message = "Gravidade é obrigatória")
    private Gravidade gravidade;

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public Integer getIdade() { return idade; }
    public void setIdade(Integer idade) { this.idade = idade; }
    
    public String getSintomas() { return sintomas; }
    public void setSintomas(String sintomas) { this.sintomas = sintomas; }
    
    public Prioridade getPrioridade() { return prioridade; }
    public void setPrioridade(Prioridade prioridade) { this.prioridade = prioridade; }
    
    public Gravidade getGravidade() { return gravidade; }
    public void setGravidade(Gravidade gravidade) { this.gravidade = gravidade; }
} 