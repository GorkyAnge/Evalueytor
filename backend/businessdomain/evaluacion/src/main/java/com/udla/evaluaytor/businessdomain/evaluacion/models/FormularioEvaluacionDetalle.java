package com.udla.evaluaytor.businessdomain.evaluacion.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FormularioEvaluacionDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private byte cumplimiento;
    private String observacion;

    @ManyToOne
    @JoinColumn(name = "id_formulario_evaluacion")
    private FormularioEvaluacion formularioEvaluacion;

    @ManyToOne
    @JoinColumn(name = "id_estado_detalle")
    private EstadoDetalle estadoDetalle;

    @OneToOne(mappedBy = "formularioEvaluacionDetalle")
    private Documento documento;

    private Long matrizEvaluacionId;

    @Transient
    private MatrizEvaluacion matrizEvaluacion;
}

