package com.example.inovaempresa.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Ideia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String impacto;
    private Double custoEstimado;
    private String descricao;
    
    @ManyToOne
    private Colaborador colaborador;
}