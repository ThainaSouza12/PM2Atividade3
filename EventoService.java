package com.example.inovaempresa.service;

import com.example.inovaempresa.model.Evento;
import com.example.inovaempresa.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {
    @Autowired
    private EventoRepository repository;

    public Evento save(Evento evento) {
        return repository.save(evento);
    }
}