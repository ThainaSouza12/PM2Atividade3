package com.example.inovaempresa.service;

import com.example.inovaempresa.model.Collaborator;
import com.example.inovaempresa.repository.CollaboratorRepository;
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
public class CollaboratorServiceTests {

    @Mock
    private CollaboratorRepository collaboratorRepository;

    @InjectMocks
    private CollaboratorService collaboratorService;

    public CollaboratorServiceTests() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveCollaborator() {
        Collaborator collaborator = new Collaborator();
        collaborator.setName("John Doe");
        when(collaboratorRepository.save(collaborator)).thenReturn(collaborator);

        Collaborator savedCollaborator = collaboratorService.saveCollaborator(collaborator);
        assertEquals("John Doe", savedCollaborator.getName());
    }

    @Test
    void testFindCollaboratorById() {
        Collaborator collaborator = new Collaborator();
        collaborator.setId(1L);
        when(collaboratorRepository.findById(1L)).thenReturn(Optional.of(collaborator));

        Optional<Collaborator> foundCollaborator = collaboratorService.findCollaboratorById(1L);
        assertTrue(foundCollaborator.isPresent());
        assertEquals(1L, foundCollaborator.get().getId());
    }
}
