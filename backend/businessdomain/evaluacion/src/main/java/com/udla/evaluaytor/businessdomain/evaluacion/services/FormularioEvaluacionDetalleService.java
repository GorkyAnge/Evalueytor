package com.udla.evaluaytor.businessdomain.evaluacion.services;

import com.udla.evaluaytor.businessdomain.evaluacion.models.FormularioEvaluacionDetalle;
import java.util.List;

public interface FormularioEvaluacionDetalleService {
    FormularioEvaluacionDetalle getFormularioEvaluacionDetalle(Long detalleId);
    FormularioEvaluacionDetalle createFormularioEvaluacionDetalle(FormularioEvaluacionDetalle formularioEvaluacionDetalle);
    FormularioEvaluacionDetalle updateFormularioEvaluacionDetalle(Long detalleId, FormularioEvaluacionDetalle formularioEvaluacionDetalle);
    void deleteFormularioEvaluacionDetalle(Long detalleId);
    List<FormularioEvaluacionDetalle> getAllFormulariosEvaluacionDetalle();
}