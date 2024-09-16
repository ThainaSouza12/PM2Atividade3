package com.example.inovaempresa.service;

import com.example.inovaempresa.model.Ideia;
import com.example.inovaempresa.repository.IdeiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdeiaService {
    @Autowired
    private IdeiaRepository repository;

    public Ideia save(Ideia ideia) {
        return repository.save(ideia);
    }
}