package com.udla.evaluaytor.businessdomain.empresa.services;

import com.udla.evaluaytor.businessdomain.empresa.dto.CategoriaDTO;
import com.udla.evaluaytor.businessdomain.empresa.dto.CategoriaResponseDTO;
import com.udla.evaluaytor.businessdomain.empresa.dto.MatrizEvaluacionResponseDTO;
import com.udla.evaluaytor.businessdomain.empresa.models.Categoria;
import com.udla.evaluaytor.businessdomain.empresa.models.MatrizEvaluacion;
import com.udla.evaluaytor.businessdomain.empresa.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaResponseDTO createCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria();
        categoria.setDescripcion(categoriaDTO.getDescripcion());

        Categoria savedCategoria = categoriaRepository.save(categoria);
        return convertToResponseDTO(savedCategoria);
    }

    public CategoriaResponseDTO updateCategoria(Long id, CategoriaDTO categoriaDTO) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);

        if (categoriaOptional.isPresent()) {
            Categoria categoria = categoriaOptional.get();
            categoria.setDescripcion(categoriaDTO.getDescripcion());

            Categoria updatedCategoria = categoriaRepository.save(categoria);
            return convertToResponseDTO(updatedCategoria);
        } else {
            return null; // Handle appropriately in the controller
        }
    }

    public List<CategoriaResponseDTO> getAllCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias.stream().map(this::convertToResponseDTO).collect(Collectors.toList());
    }

    public CategoriaResponseDTO getCategoriaById(Long id) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
        return categoriaOptional.map(this::convertToResponseDTO).orElse(null);
    }

    public void deleteCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }

    private CategoriaResponseDTO convertToResponseDTO(Categoria categoria) {
        CategoriaResponseDTO responseDTO = new CategoriaResponseDTO();
        responseDTO.setId(categoria.getId());
        responseDTO.setDescripcion(categoria.getDescripcion());
        responseDTO.setMatrizEvaluaciones(
                categoria.getMatrizEvaluaciones().stream()
                        .map(this::convertMatrizEvaluacionToResponseDTO)
                        .collect(Collectors.toList())
        );
        return responseDTO;
    }

    private MatrizEvaluacionResponseDTO convertMatrizEvaluacionToResponseDTO(MatrizEvaluacion matrizEvaluacion) {
        MatrizEvaluacionResponseDTO responseDTO = new MatrizEvaluacionResponseDTO();
        responseDTO.setId(matrizEvaluacion.getId());
        responseDTO.setPregunta(matrizEvaluacion.getPregunta());
        responseDTO.setPuntos(matrizEvaluacion.getPuntos());
        responseDTO.setRequiere_documento(matrizEvaluacion.getRequiere_documento());
        responseDTO.setCategoriaId(matrizEvaluacion.getCategoria().getId()); // Ajuste aquí
        return responseDTO;
    }
}


