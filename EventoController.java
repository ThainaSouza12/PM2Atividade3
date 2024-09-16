package com.example.inovaempresa.controller;

import com.example.inovaempresa.model.Evento;
import com.example.inovaempresa.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eventos")
public class EventoController {
    @Autowired
    private EventoService service;

    @PostMapping
    public Evento addEvento(@RequestBody Evento evento) {
        return service.save(evento);
    }
}