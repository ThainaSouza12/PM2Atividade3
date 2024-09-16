package com.example.inovaempresa.repository;

import com.example.inovaempresa.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}