package com.example.inovaempresa.controller;

import com.example.inovaempresa.model.Ideia;
import com.example.inovaempresa.service.IdeiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ideias")
public class IdeiaController {
    @Autowired
    private IdeiaService service;

    @PostMapping
    public Ideia addIdeia(@RequestBody Ideia ideia) {
        return service.save(ideia);
    }
}