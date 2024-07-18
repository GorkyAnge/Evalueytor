package com.udla.evaluaytor.businessdomain.empresa.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "matriz_evaluacion")
public class MatrizEvaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pregunta;
    private int puntos;
    private byte requiere_documento;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
}

