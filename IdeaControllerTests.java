package com.example.inovaempresa.controller;

import com.example.inovaempresa.model.Idea;
import com.example.inovaempresa.service.IdeaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(IdeaController.class)
public class IdeaControllerTests {

    @Mock
    private IdeaService ideaService;

    @InjectMocks
    private IdeaController ideaController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(ideaController).build();
    }

    @Test
    void testCreateIdea() throws Exception {
        Idea idea = new Idea();
        idea.setName("Test Idea");

        mockMvc.perform(post("/api/ideas")
                .contentType("application/json")
                .content("{\"name\":\"Test Idea\", \"impact\":\"High\", \"estimatedCost\":100.0, \"description\":\"Description\"}"))
                .andExpect(status().isOk());
    }
  }
