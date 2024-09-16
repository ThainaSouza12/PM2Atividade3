package com.example.inovaempresa.service;

import com.example.inovaempresa.model.Event;
import com.example.inovaempresa.repository.EventRepository;
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
public class EventServiceTests {

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private EventService eventService;

    public EventServiceTests() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveEvent() {
        Event event = new Event();
        event.setName("Annual Meeting");
        when(eventRepository.save(event)).thenReturn(event);

        Event savedEvent = eventService.saveEvent(event);
        assertEquals("Annual Meeting", savedEvent.getName());
    }

    @Test
    void testFindEventById() {
        Event event = new Event();
        event.setId(1L);
        when(eventRepository.findById(1L)).thenReturn(Optional.of(event));

        Optional<Event> foundEvent = eventService.findEventById(1L);
        assertTrue(foundEvent.isPresent());
        assertEquals(1L, foundEvent.get().getId());
    }
}
