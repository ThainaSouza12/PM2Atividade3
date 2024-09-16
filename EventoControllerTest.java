package com.example.inovaempresa.controller;

import com.example.inovaempresa.model.Evento;
import com.example.inovaempresa.repository.EventoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(EventoController.class)
public class EventoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventoRepository repository;

    @Test
    public void testAddEvento() throws Exception {
        mockMvc.perform(post("/eventos")
                .contentType("application/json")
                .content("{\"nome\":\"Evento de Teste\",\"descricao\":\"Descrição do evento\",\"dataInicio\":\"2024-09-01\",\"dataFim\":\"2024-09-10\",\"dataAvaliacaoJurados\":\"2024-09-05\",\"dataAvaliacaoPopular\":\"2024-09-09\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Evento de Teste")));
    }
}