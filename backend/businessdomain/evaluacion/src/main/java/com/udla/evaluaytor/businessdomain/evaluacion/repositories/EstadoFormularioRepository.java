package com.udla.evaluaytor.businessdomain.evaluacion.repositories;

import com.udla.evaluaytor.businessdomain.evaluacion.models.EstadoFormulario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoFormularioRepository extends JpaRepository<EstadoFormulario, Long> {
}