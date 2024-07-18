package com.udla.evaluaytor.businessdomain.empresa.services;

import com.udla.evaluaytor.businessdomain.empresa.dto.CategoriaDTO;
import com.udla.evaluaytor.businessdomain.empresa.dto.MatrizEvaluacionDTO;
import com.udla.evaluaytor.businessdomain.empresa.dto.MatrizEvaluacionResponseDTO;
import com.udla.evaluaytor.businessdomain.empresa.models.Categoria;
import com.udla.evaluaytor.businessdomain.empresa.models.MatrizEvaluacion;
import com.udla.evaluaytor.businessdomain.empresa.repositories.CategoriaRepository;
import com.udla.evaluaytor.businessdomain.empresa.repositories.MatrizEvaluacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatrizService {

    @Autowired
    private MatrizEvaluacionRepository matrizEvaluacionRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public MatrizEvaluacionResponseDTO createMatrizEvaluacion(MatrizEvaluacionDTO matrizEvaluacionDTO) {
        MatrizEvaluacion matrizEvaluacion = new MatrizEvaluacion();
        matrizEvaluacion.setPregunta(matrizEvaluacionDTO.getPregunta());
        matrizEvaluacion.setPuntos(matrizEvaluacionDTO.getPuntos());
        matrizEvaluacion.setRequiere_documento(matrizEvaluacionDTO.getRequiere_documento());

        Categoria categoria = categoriaRepository.findById(matrizEvaluacionDTO.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
        matrizEvaluacion.setCategoria(categoria);

        MatrizEvaluacion matrizGuardada = matrizEvaluacionRepository.save(matrizEvaluacion);

        MatrizEvaluacionResponseDTO responseDTO = new MatrizEvaluacionResponseDTO();
        responseDTO.setId(matrizGuardada.getId());
        responseDTO.setPregunta(matrizGuardada.getPregunta());
        responseDTO.setPuntos(matrizGuardada.getPuntos());
        responseDTO.setRequiere_documento(matrizGuardada.getRequiere_documento());

        responseDTO.setCategoriaId(matrizGuardada.getCategoria().getId());

        return responseDTO;
    }

    public MatrizEvaluacionResponseDTO updateMatrizEvaluacion(Long id, MatrizEvaluacionDTO matrizEvaluacionDTO) {
        MatrizEvaluacion matrizEvaluacion = matrizEvaluacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MatrizEvaluacion no encontrada"));

        matrizEvaluacion.setPregunta(matrizEvaluacionDTO.getPregunta());
        matrizEvaluacion.setPuntos(matrizEvaluacionDTO.getPuntos());
        matrizEvaluacion.setRequiere_documento(matrizEvaluacionDTO.getRequiere_documento());

        Categoria categoria = categoriaRepository.findById(matrizEvaluacionDTO.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
        matrizEvaluacion.setCategoria(categoria);

        MatrizEvaluacion matrizGuardada = matrizEvaluacionRepository.save(matrizEvaluacion);

        MatrizEvaluacionResponseDTO responseDTO = new MatrizEvaluacionResponseDTO();
        responseDTO.setId(matrizGuardada.getId());
        responseDTO.setPregunta(matrizGuardada.getPregunta());
        responseDTO.setPuntos(matrizGuardada.getPuntos());
        responseDTO.setRequiere_documento(matrizGuardada.getRequiere_documento());
        responseDTO.setCategoriaId(matrizGuardada.getCategoria().getId());

        return responseDTO;
    }

    public List<MatrizEvaluacionResponseDTO> getAllMatrizEvaluaciones() {
        List<MatrizEvaluacion> matrizEvaluaciones = matrizEvaluacionRepository.findAll();
        return matrizEvaluaciones.stream().map(matriz -> {
            MatrizEvaluacionResponseDTO responseDTO = new MatrizEvaluacionResponseDTO();
            responseDTO.setId(matriz.getId());
            responseDTO.setPregunta(matriz.getPregunta());
            responseDTO.setPuntos(matriz.getPuntos());
            responseDTO.setRequiere_documento(matriz.getRequiere_documento());
            CategoriaDTO categoriaDTO = new CategoriaDTO();
            responseDTO.setCategoriaId(matriz.getCategoria().getId());
            return responseDTO;
        }).collect(Collectors.toList());
    }

    public MatrizEvaluacionResponseDTO getMatrizEvaluacionById(Long id) {
        MatrizEvaluacion matrizEvaluacion = matrizEvaluacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MatrizEvaluacion no encontrada"));

        MatrizEvaluacionResponseDTO responseDTO = new MatrizEvaluacionResponseDTO();
        responseDTO.setId(matrizEvaluacion.getId());
        responseDTO.setPregunta(matrizEvaluacion.getPregunta());
        responseDTO.setPuntos(matrizEvaluacion.getPuntos());
        responseDTO.setRequiere_documento(matrizEvaluacion.getRequiere_documento());
        responseDTO.setCategoriaId(matrizEvaluacion.getCategoria().getId());

        return responseDTO;
    }

    public void deleteMatrizEvaluacion(Long id) {
        if (matrizEvaluacionRepository.existsById(id)) {
            matrizEvaluacionRepository.deleteById(id);
        } else {
            throw new RuntimeException("MatrizEvaluacion no encontrada");
        }
    }
}


