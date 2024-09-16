package com.example.inovaempresa.service;

import com.example.inovaempresa.model.Colaborador;
import com.example.inovaempresa.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColaboradorService {
    @Autowired
    private ColaboradorRepository repository;

    public Colaborador save(Colaborador colaborador) {
        return repository.save(colaborador);
    }
}