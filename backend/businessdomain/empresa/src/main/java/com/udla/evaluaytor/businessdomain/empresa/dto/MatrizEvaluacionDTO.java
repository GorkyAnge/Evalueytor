package com.udla.evaluaytor.businessdomain.empresa.dto;

import lombok.Data;

@Data
public class MatrizEvaluacionDTO {
    private Long id;
    private String pregunta;
    private int puntos;
    private byte requiere_documento;
    private Long categoriaId;
}
