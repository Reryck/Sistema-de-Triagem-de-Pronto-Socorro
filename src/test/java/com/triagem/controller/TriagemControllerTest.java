package com.triagem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.triagem.dto.TriagemRequest;
import com.triagem.model.enums.Prioridade;
import com.triagem.model.enums.Gravidade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
public class TriagemControllerTest {
    
    @Autowired
    private WebApplicationContext webApplicationContext;
    
    private MockMvc mockMvc;
    
    @Test
    public void testRealizarTriagem() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        
        TriagemRequest request = new TriagemRequest();
        request.setNome("João Silva");
        request.setIdade(30);
        request.setSintomas("Dor no peito");
        request.setPrioridade(Prioridade.VERMELHA);
        request.setGravidade(Gravidade.GRAVE);
        
        ObjectMapper mapper = new ObjectMapper();
        String jsonRequest = mapper.writeValueAsString(request);
        
        mockMvc.perform(post("/api/triagem")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("João Silva"))
                .andExpect(jsonPath("$.prioridade").value("VERMELHA"));
    }
} 