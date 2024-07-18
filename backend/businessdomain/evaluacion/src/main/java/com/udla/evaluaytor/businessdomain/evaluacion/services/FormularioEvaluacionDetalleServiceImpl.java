package com.udla.evaluaytor.businessdomain.evaluacion.services;

import com.udla.evaluaytor.businessdomain.evaluacion.models.FormularioEvaluacionDetalle;
import com.udla.evaluaytor.businessdomain.evaluacion.repositories.FormularioEvaluacionDetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormularioEvaluacionDetalleServiceImpl implements FormularioEvaluacionDetalleService {

    @Autowired
    private FormularioEvaluacionDetalleRepository formularioEvaluacionDetalleRepository;

    @Override
    public FormularioEvaluacionDetalle getFormularioEvaluacionDetalle(Long detalleId) {
        return formularioEvaluacionDetalleRepository.findById(detalleId)
                .orElseThrow(() -> new RuntimeException("Detalle no encontrado"));
    }

    @Override
    public FormularioEvaluacionDetalle createFormularioEvaluacionDetalle(FormularioEvaluacionDetalle formularioEvaluacionDetalle) {
        return formularioEvaluacionDetalleRepository.save(formularioEvaluacionDetalle);
    }

    @Override
    public FormularioEvaluacionDetalle updateFormularioEvaluacionDetalle(Long detalleId, FormularioEvaluacionDetalle formularioEvaluacionDetalle) {
        FormularioEvaluacionDetalle existingDetalle = formularioEvaluacionDetalleRepository.findById(detalleId)
                .orElseThrow(() -> new RuntimeException("Detalle no encontrado"));
        existingDetalle.setDocumento(formularioEvaluacionDetalle.getDocumento());
        // Actualiza otros campos según sea necesario
        return formularioEvaluacionDetalleRepository.save(existingDetalle);
    }

    @Override
    public void deleteFormularioEvaluacionDetalle(Long detalleId) {
        formularioEvaluacionDetalleRepository.deleteById(detalleId);
    }

    @Override
    public List<FormularioEvaluacionDetalle> getAllFormulariosEvaluacionDetalle() {
        return formularioEvaluacionDetalleRepository.findAll();
    }
}
