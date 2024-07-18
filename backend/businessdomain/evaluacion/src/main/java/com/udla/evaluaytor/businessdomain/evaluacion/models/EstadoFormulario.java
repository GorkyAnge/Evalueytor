package com.udla.evaluaytor.businessdomain.evaluacion.models;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class EstadoFormulario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;

    @OneToMany(mappedBy = "estadoFormulario")
    private List<FormularioEvaluacion> formularioEvaluacion;
}

