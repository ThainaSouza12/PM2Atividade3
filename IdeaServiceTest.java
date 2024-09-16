package com.example.inovaempresa.service;

import com.example.inovaempresa.model.Idea;
import com.example.inovaempresa.repository.IdeaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@SpringJUnitConfig
public class IdeaServiceTests {

    @Mock
    private IdeaRepository ideaRepository;

    @InjectMocks
    private IdeaService ideaService;

    public IdeaServiceTests() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveIdea() {
        Idea idea = new Idea();
        idea.setName("New Idea");
        when(ideaRepository.save(idea)).thenReturn(idea);

        Idea savedIdea = ideaService.saveIdea(idea);
        assertEquals("New Idea", savedIdea.getName());
    }

    @Test
    void testFindIdeaById() {
        Idea idea = new Idea();
        idea.setId(1L);
        when(ideaRepository.findById(1L)).thenReturn(Optional.of(idea));

        Optional<Idea> foundIdea = ideaService.findIdeaById(1L);
        assertTrue(foundIdea.isPresent());
        assertEquals(1L, foundIdea.get().getId());
    }
}
