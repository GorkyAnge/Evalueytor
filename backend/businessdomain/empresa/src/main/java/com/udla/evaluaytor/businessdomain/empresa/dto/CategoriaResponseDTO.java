package com.udla.evaluaytor.businessdomain.empresa.dto;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class CategoriaResponseDTO {
    private Long id;
    private String descripcion;
    private Set<ProveedorDTO> proveedores;
    private List<MatrizEvaluacionResponseDTO> matrizEvaluaciones;
}
