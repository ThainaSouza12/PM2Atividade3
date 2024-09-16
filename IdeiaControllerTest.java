package com.example.inovaempresa.controller;

import com.example.inovaempresa.model.Ideia;
import com.example.inovaempresa.repository.IdeiaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(IdeiaController.class)
public class IdeiaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IdeiaRepository repository;

    @Test
    public void testAddIdeia() throws Exception {
        mockMvc.perform(post("/ideias")
                .contentType("application/json")
                .content("{\"nome\":\"Ideia de Teste\",\"impacto\":\"Alto\",\"custoEstimado\":1000.00,\"descricao\":\"Descrição da ideia\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Ideia de Teste")));
    }
}