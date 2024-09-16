package com.example.inovaempresa.controller;

import com.example.inovaempresa.model.Colaborador;
import com.example.inovaempresa.repository.ColaboradorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(ColaboradorController.class)
public class ColaboradorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ColaboradorRepository repository;

    @Test
    public void testAddColaborador() throws Exception {
        mockMvc.perform(post("/colaboradores")
                .contentType("application/json")
                .content("{\"nome\":\"John Doe\",\"email\":\"john@example.com\",\"senha\":\"password\",\"perfil\":\"colaborador\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("John Doe")));
    }
}