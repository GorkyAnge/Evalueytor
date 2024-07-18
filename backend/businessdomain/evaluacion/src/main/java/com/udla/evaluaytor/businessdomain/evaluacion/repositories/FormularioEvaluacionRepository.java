package com.udla.evaluaytor.businessdomain.evaluacion.repositories;

import com.udla.evaluaytor.businessdomain.evaluacion.models.FormularioEvaluacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormularioEvaluacionRepository extends JpaRepository<FormularioEvaluacion, Long> {
}

