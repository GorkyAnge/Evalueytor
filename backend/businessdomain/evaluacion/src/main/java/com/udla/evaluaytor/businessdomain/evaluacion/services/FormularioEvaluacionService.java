package com.udla.evaluaytor.businessdomain.evaluacion.services;

import com.udla.evaluaytor.businessdomain.evaluacion.models.FormularioEvaluacion;
import java.util.List;

public interface FormularioEvaluacionService {
    FormularioEvaluacion getFormularioEvaluacion(Long formularioId);
    FormularioEvaluacion createFormularioEvaluacion(FormularioEvaluacion formularioEvaluacion);
    FormularioEvaluacion updateFormularioEvaluacion(Long formularioId, FormularioEvaluacion formularioEvaluacion);
    void deleteFormularioEvaluacion(Long formularioId);
    List<FormularioEvaluacion> getAllFormulariosEvaluacion();
}

