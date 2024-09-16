package com.example.inovaempresa.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private String dataInicio;
    private String dataFim;
    private String dataAvaliacaoJurados;
    private String dataAvaliacaoPopular;
}