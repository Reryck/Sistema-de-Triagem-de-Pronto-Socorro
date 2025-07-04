package com.triagem.model;

import com.triagem.model.enums.Prioridade;
import com.triagem.model.enums.Gravidade;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private Integer idade;
    
    @Column(nullable = false)
    private String sintomas;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Prioridade prioridade;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gravidade gravidade;
    
    @Column(name = "data_triagem", nullable = false)
    private LocalDateTime dataTriagem;
    
    @Column(name = "em_atendimento")
    private Boolean emAtendimento = false;

    // Construtores
    public Paciente() {}

    public Paciente(String nome, Integer idade, String sintomas, 
                   Prioridade prioridade, Gravidade gravidade) {
        this.nome = nome;
        this.idade = idade;
        this.sintomas = sintomas;
        this.prioridade = prioridade;
        this.gravidade = gravidade;
        this.dataTriagem = LocalDateTime.now();
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
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
    
    public LocalDateTime getDataTriagem() { return dataTriagem; }
    public void setDataTriagem(LocalDateTime dataTriagem) { this.dataTriagem = dataTriagem; }
    
    public Boolean getEmAtendimento() { return emAtendimento; }
    public void setEmAtendimento(Boolean emAtendimento) { this.emAtendimento = emAtendimento; }
} 