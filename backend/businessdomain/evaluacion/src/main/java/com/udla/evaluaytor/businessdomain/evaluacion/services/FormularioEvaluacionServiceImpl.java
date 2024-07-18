package com.udla.evaluaytor.businessdomain.evaluacion.services;

import com.udla.evaluaytor.businessdomain.evaluacion.models.FormularioEvaluacion;
import com.udla.evaluaytor.businessdomain.evaluacion.repositories.FormularioEvaluacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormularioEvaluacionServiceImpl implements FormularioEvaluacionService {

    @Autowired
    private FormularioEvaluacionRepository formularioEvaluacionRepository;

    @Override
    public FormularioEvaluacion getFormularioEvaluacion(Long formularioId) {
        return formularioEvaluacionRepository.findById(formularioId)
                .orElseThrow(() -> new RuntimeException("Formulario no encontrado"));
    }

    @Override
    public FormularioEvaluacion createFormularioEvaluacion(FormularioEvaluacion formularioEvaluacion) {
        return formularioEvaluacionRepository.save(formularioEvaluacion);
    }

    @Override
    public FormularioEvaluacion updateFormularioEvaluacion(Long formularioId, FormularioEvaluacion formularioEvaluacion) {
        FormularioEvaluacion existingFormulario = formularioEvaluacionRepository.findById(formularioId)
                .orElseThrow(() -> new RuntimeException("Formulario no encontrado"));
        existingFormulario.setNumero(formularioEvaluacion.getNumero());
        existingFormulario.setFecha(formularioEvaluacion.getFecha());
        existingFormulario.setEvaluacion(formularioEvaluacion.getEvaluacion());
        existingFormulario.setEstadoFormulario(formularioEvaluacion.getEstadoFormulario());
        existingFormulario.setProveedorId(formularioEvaluacion.getProveedorId());
        existingFormulario.setCategoriaId(formularioEvaluacion.getCategoriaId());
        existingFormulario.setPeritoId(formularioEvaluacion.getPeritoId());
        existingFormulario.setFormularioEvaluacionDetalle(formularioEvaluacion.getFormularioEvaluacionDetalle());
        return formularioEvaluacionRepository.save(existingFormulario);
    }

    @Override
    public void deleteFormularioEvaluacion(Long formularioId) {
        formularioEvaluacionRepository.deleteById(formularioId);
    }

    @Override
    public List<FormularioEvaluacion> getAllFormulariosEvaluacion() {
        return formularioEvaluacionRepository.findAll();
    }
}
