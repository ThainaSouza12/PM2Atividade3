package com.example.inovaempresa.repository;

import com.example.inovaempresa.model.Ideia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdeiaRepository extends JpaRepository<Ideia, Long> {
}