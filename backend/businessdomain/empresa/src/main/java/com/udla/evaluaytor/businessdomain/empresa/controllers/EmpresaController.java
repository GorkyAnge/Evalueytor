package com.udla.evaluaytor.businessdomain.empresa.controllers;

import com.udla.evaluaytor.businessdomain.empresa.dto.*;
import com.udla.evaluaytor.businessdomain.empresa.models.Categoria;
import com.udla.evaluaytor.businessdomain.empresa.models.Perito;
import com.udla.evaluaytor.businessdomain.empresa.repositories.PeritoRepository;
import com.udla.evaluaytor.businessdomain.empresa.services.CategoriaService;
import com.udla.evaluaytor.businessdomain.empresa.services.MatrizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.udla.evaluaytor.businessdomain.empresa.repositories.CategoriaRepository;
import com.udla.evaluaytor.businessdomain.empresa.repositories.EmpresaRepository;
import com.udla.evaluaytor.businessdomain.empresa.repositories.ProveedorRepository;
import com.udla.evaluaytor.businessdomain.empresa.services.ProveedorService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {
    @Autowired
    EmpresaRepository empresaRepository;

    @Autowired
    ProveedorRepository proveedorRepository;

    @Autowired 
    CategoriaRepository categoriaRepository;

    @Autowired
    private ProveedorService proveedorService;
    @Autowired
    private PeritoRepository peritoRepository;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private MatrizService matrizService;
    // CRUD PROVEEDOR
    @PostMapping("/proveedor/save")
    public ResponseEntity<ProveedorResponseDTO> createProveedor(@RequestBody ProveedorDTO proveedorDTO) {
        ProveedorResponseDTO proveedorGuardado = proveedorService.createProveedor(proveedorDTO);
        return new ResponseEntity<>(proveedorGuardado, HttpStatus.CREATED);
    }
      
    @PutMapping("/proveedor/update/{id}")
    public ResponseEntity<ProveedorResponseDTO> updateProveedor(@PathVariable Long id, @RequestBody ProveedorDTO proveedorUpdateDTO) {
        ProveedorResponseDTO updatedProveedor = proveedorService.updateProveedor(id, proveedorUpdateDTO);
        return ResponseEntity.ok(updatedProveedor);
    }


    @GetMapping("proveedor/findall")
    public ResponseEntity<List<ProveedorResponseDTO>> getAllProveedores() {
        List<ProveedorResponseDTO> proveedores = proveedorService.getAllProveedores();
        return ResponseEntity.ok(proveedores);
    }

    @GetMapping("proveedor/findbyid/{id}")
     public ResponseEntity<ProveedorResponseDTO> getProveedorById(@PathVariable Long id) {
        ProveedorResponseDTO proveedor = proveedorService.getProveedorById(id);
        return ResponseEntity.ok(proveedor);
    }

    //CRUD PERITO
    @GetMapping("/perito/findbyid/{id}")
    public ResponseEntity<Perito> obtenerPeritoPorId(@PathVariable Long id) {
        Optional<Perito> premioOptional = peritoRepository.findById(id);
        return premioOptional.map(premio -> new ResponseEntity<>(premio, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/perito/save")
    public ResponseEntity<Perito> crearEmpresa(@RequestBody Perito nuevoPerito) {
        Perito peritoGuardado = peritoRepository.save(nuevoPerito);
        return new ResponseEntity<>(peritoGuardado, HttpStatus.CREATED);

    }

    @GetMapping("/perito/findall")
    public ResponseEntity<List<Perito>> obtenerTodosLosPeritos() {
        List<Perito> peritos = peritoRepository.findAll();
        return new ResponseEntity<>(peritos, HttpStatus.OK);
    }

    @DeleteMapping("/perito/delete/{id}")
    public ResponseEntity<Void> eliminarPerito(@PathVariable Long id) {
        if (peritoRepository.existsById(id)) {
            peritoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/perito/update/{id}")
    public ResponseEntity<Perito> actualizarPerito(@PathVariable Long id, @RequestBody Perito peritoActualizado) {
        return peritoRepository.findById(id).map(perito -> {
            perito.setNombre(peritoActualizado.getNombre());
            perito.setDireccion(peritoActualizado.getDireccion());
            Perito peritoGuardado = peritoRepository.save(perito);
            return new ResponseEntity<>(peritoGuardado, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //CRUD CATEGORIA
    @PostMapping("/categoria/save")
    public ResponseEntity<CategoriaResponseDTO> createCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        CategoriaResponseDTO categoriaGuardada = categoriaService.createCategoria(categoriaDTO);
        return new ResponseEntity<>(categoriaGuardada, HttpStatus.CREATED);
    }

    @PutMapping("/categoria/update/{id}")
    public ResponseEntity<CategoriaResponseDTO> updateCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaUpdateDTO) {
        CategoriaResponseDTO updatedCategoria = categoriaService.updateCategoria(id, categoriaUpdateDTO);
        return ResponseEntity.ok(updatedCategoria);
    }

    @GetMapping("/categoria/findall")
    public ResponseEntity<List<CategoriaResponseDTO>> getAllCategorias() {
        List<CategoriaResponseDTO> categorias = categoriaService.getAllCategorias();
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/categoria/findbyid/{id}")
    public ResponseEntity<CategoriaResponseDTO> getCategoriaById(@PathVariable Long id) {
        CategoriaResponseDTO categoria = categoriaService.getCategoriaById(id);
        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping("/categoria/delete/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    // CRUD MATRIZ EVALUACION
    @PostMapping("/matriz_evaluacion/save")
    public ResponseEntity<MatrizEvaluacionResponseDTO> createMatrizEvaluacion(@RequestBody MatrizEvaluacionDTO matrizEvaluacionDTO) {
        MatrizEvaluacionResponseDTO matrizEvaluacionGuardada = matrizService.createMatrizEvaluacion(matrizEvaluacionDTO);
        return new ResponseEntity<>(matrizEvaluacionGuardada, HttpStatus.CREATED);
    }

    @PutMapping("/matriz_evaluacion/update/{id}")
    public ResponseEntity<MatrizEvaluacionResponseDTO> updateMatrizEvaluacion(@PathVariable Long id, @RequestBody MatrizEvaluacionDTO matrizEvaluacionDTO) {
        MatrizEvaluacionResponseDTO updatedMatrizEvaluacion = matrizService.updateMatrizEvaluacion(id, matrizEvaluacionDTO);
        if (updatedMatrizEvaluacion != null) {
            return ResponseEntity.ok(updatedMatrizEvaluacion);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/matriz_evaluacion/findall")
    public ResponseEntity<List<MatrizEvaluacionResponseDTO>> getAllMatrizEvaluaciones() {
        List<MatrizEvaluacionResponseDTO> matrizEvaluaciones = matrizService.getAllMatrizEvaluaciones();
        return ResponseEntity.ok(matrizEvaluaciones);
    }

    @GetMapping("/matriz_evaluacion/findbyid/{id}")
    public ResponseEntity<MatrizEvaluacionResponseDTO> getMatrizEvaluacionById(@PathVariable Long id) {
        MatrizEvaluacionResponseDTO matrizEvaluacion = matrizService.getMatrizEvaluacionById(id);
        if (matrizEvaluacion != null) {
            return new ResponseEntity<>(matrizEvaluacion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/matriz_evaluacion/delete/{id}")
    public ResponseEntity<Void> deleteMatrizEvaluacion(@PathVariable Long id) {
        matrizService.deleteMatrizEvaluacion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
