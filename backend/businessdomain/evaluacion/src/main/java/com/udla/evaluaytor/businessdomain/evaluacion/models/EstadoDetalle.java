package com.udla.evaluaytor.businessdomain.evaluacion.models;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class EstadoDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @OneToMany(mappedBy = "estadoDetalle")
    private List<FormularioEvaluacionDetalle> formularioEvaluacionDetalle;
}

