package com.udla.evaluaytor.businessdomain.evaluacion.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String tipo;
    private byte[] contenido;

    @OneToOne
    @JoinColumn(name = "formulario_detalle_id", nullable = true)
    private FormularioEvaluacionDetalle formularioEvaluacionDetalle;
}