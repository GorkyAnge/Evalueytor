package com.udla.evaluaytor.businessdomain.evaluacion.controllers;

import com.udla.evaluaytor.businessdomain.evaluacion.models.*;
import com.udla.evaluaytor.businessdomain.evaluacion.repositories.DocumentoRepository;
import com.udla.evaluaytor.businessdomain.evaluacion.repositories.EstadoDetalleRepository;
import com.udla.evaluaytor.businessdomain.evaluacion.services.FormularioEvaluacionDetalleService;
import com.udla.evaluaytor.businessdomain.evaluacion.services.FormularioEvaluacionService;
import com.udla.evaluaytor.businessdomain.evaluacion.services.FormularioEvaluacionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/evaluacion")
public class FormularioEvaluacionController {

    @Autowired
    private FormularioEvaluacionService formularioEvaluacionService;

    @Autowired
    private FormularioEvaluacionDetalleService formularioEvaluacionDetalleService;

    @Autowired
    private DocumentoRepository documentoRepository;

    @Autowired
    private EstadoDetalleRepository estadoDetalleRepository;

    // Formulario Evaluacion

    @PostMapping("/formulario_evaluacion")
    public ResponseEntity<FormularioEvaluacion> createFormularioEvaluacion(@RequestBody FormularioEvaluacion formularioEvaluacion) {
        FormularioEvaluacion savedFormulario = formularioEvaluacionService.createFormularioEvaluacion(formularioEvaluacion);
        return new ResponseEntity<>(savedFormulario, HttpStatus.CREATED);
    }


    @GetMapping("/formulario_evaluacion/{formularioId}")
    public ResponseEntity<FormularioEvaluacion> getFormularioEvaluacion(@PathVariable Long formularioId) {
        FormularioEvaluacion formularioEvaluacion = formularioEvaluacionService.getFormularioEvaluacion(formularioId);
        return new ResponseEntity<>(formularioEvaluacion, HttpStatus.OK);
    }

    @PutMapping("/formulario_evaluacion/{formularioId}")
    public ResponseEntity<FormularioEvaluacion> updateFormularioEvaluacion(@PathVariable Long formularioId, @RequestBody FormularioEvaluacion formularioEvaluacion) {
        FormularioEvaluacion updatedFormulario = formularioEvaluacionService.updateFormularioEvaluacion(formularioId, formularioEvaluacion);
        return new ResponseEntity<>(updatedFormulario, HttpStatus.OK);
    }


    @DeleteMapping("/formulario_evaluacion/{formularioId}")
    public ResponseEntity<Void> deleteFormularioEvaluacion(@PathVariable Long formularioId) {
        formularioEvaluacionService.deleteFormularioEvaluacion(formularioId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/formulario_evaluacion")
    public ResponseEntity<List<FormularioEvaluacion>> getAllFormulariosEvaluacion() {
        List<FormularioEvaluacion> formularios = formularioEvaluacionService.getAllFormulariosEvaluacion();
        return new ResponseEntity<>(formularios, HttpStatus.OK);
    }
    // Formulario Evaluacion Detalle

    @PostMapping("/formulario_evaluacion_detalle")
    public ResponseEntity<FormularioEvaluacionDetalle> createFormularioEvaluacionDetalle(@RequestBody FormularioEvaluacionDetalle formularioEvaluacionDetalle) {
        FormularioEvaluacionDetalle savedDetalle = formularioEvaluacionDetalleService.createFormularioEvaluacionDetalle(formularioEvaluacionDetalle);
        return new ResponseEntity<>(savedDetalle, HttpStatus.CREATED);
    }


    @GetMapping("/formulario_evaluacion_detalle/{detalleId}")
    public ResponseEntity<FormularioEvaluacionDetalle> getFormularioEvaluacionDetalle(@PathVariable Long detalleId) {
        FormularioEvaluacionDetalle formularioEvaluacionDetalle = formularioEvaluacionDetalleService.getFormularioEvaluacionDetalle(detalleId);
        return new ResponseEntity<>(formularioEvaluacionDetalle, HttpStatus.OK);
    }


    @PutMapping("/formulario_evaluacion_detalle/{detalleId}")
    public ResponseEntity<FormularioEvaluacionDetalle> updateFormularioEvaluacionDetalle(@PathVariable Long detalleId, @RequestBody FormularioEvaluacionDetalle formularioEvaluacionDetalle) {
        FormularioEvaluacionDetalle updatedDetalle = formularioEvaluacionDetalleService.updateFormularioEvaluacionDetalle(detalleId, formularioEvaluacionDetalle);
        return new ResponseEntity<>(updatedDetalle, HttpStatus.OK);
    }


    @DeleteMapping("/formulario_evaluacion_detalle/{detalleId}")
    public ResponseEntity<Void> deleteFormularioEvaluacionDetalle(@PathVariable Long detalleId) {
        formularioEvaluacionDetalleService.deleteFormularioEvaluacionDetalle(detalleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/formulario_evaluacion_detalle")
    public ResponseEntity<List<FormularioEvaluacionDetalle>> getAllFormulariosEvaluacionDetalle() {
        List<FormularioEvaluacionDetalle> detalles = formularioEvaluacionDetalleService.getAllFormulariosEvaluacionDetalle();
        return new ResponseEntity<>(detalles, HttpStatus.OK);
    }


    // Documento
    @GetMapping("/documento/{documentoId}")
    public ResponseEntity<Documento> getDocumento(@PathVariable Long documentoId) {
        Optional<Documento> documento = documentoRepository.findById(documentoId);
        return documento.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/documento")
    public ResponseEntity<Documento> createDocumento(@RequestBody Documento documento) {
        Documento savedDocumento = documentoRepository.save(documento);
        return new ResponseEntity<>(savedDocumento, HttpStatus.CREATED);
    }

    @PutMapping("/documento/{documentoId}")
    public ResponseEntity<Documento> updateDocumento(@PathVariable Long documentoId, @RequestBody Documento documento) {
        if (!documentoRepository.existsById(documentoId)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        documento.setId(documentoId);
        Documento updatedDocumento = documentoRepository.save(documento);
        return new ResponseEntity<>(updatedDocumento, HttpStatus.OK);
    }

    @DeleteMapping("/documento/{documentoId}")
    public ResponseEntity<Void> deleteDocumento(@PathVariable Long documentoId) {
        documentoRepository.deleteById(documentoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
