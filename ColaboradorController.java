package com.example.inovaempresa.controller;

import com.example.inovaempresa.model.Colaborador;
import com.example.inovaempresa.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {
    @Autowired
    private ColaboradorService service;

    @PostMapping
    public Colaborador addColaborador(@RequestBody Colaborador colaborador) {
        return service.save(colaborador);
    }
}