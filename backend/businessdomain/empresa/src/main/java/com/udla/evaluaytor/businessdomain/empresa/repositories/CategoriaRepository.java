package com.udla.evaluaytor.businessdomain.empresa.repositories;

import com.udla.evaluaytor.businessdomain.empresa.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
