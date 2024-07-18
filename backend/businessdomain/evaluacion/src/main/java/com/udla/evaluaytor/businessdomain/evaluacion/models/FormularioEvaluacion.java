package com.udla.evaluaytor.businessdomain.evaluacion.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FormularioEvaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer numero;
    private LocalDate fecha;
    private Integer evaluacion;

    @ManyToOne
    @JoinColumn(name = "id_estado_formulario")
    private EstadoFormulario estadoFormulario;

    @OneToMany(mappedBy = "formularioEvaluacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FormularioEvaluacionDetalle> formularioEvaluacionDetalle;

    private Long proveedorId;
    private Long categoriaId;
    private Long peritoId;

    @Transient
    private Proveedor proveedor;

    @Transient
    private Perito perito;

    @Transient
    private Categoria categoria;
}

