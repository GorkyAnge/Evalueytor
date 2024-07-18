package com.udla.evaluaytor.businessdomain.evaluacion.repositories;

import com.udla.evaluaytor.businessdomain.evaluacion.models.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {
}