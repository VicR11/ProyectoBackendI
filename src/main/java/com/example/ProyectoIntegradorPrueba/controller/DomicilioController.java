package com.example.ProyectoIntegradorPrueba.controller;

import com.example.ProyectoIntegradorPrueba.model.Domicilio;
import com.example.ProyectoIntegradorPrueba.model.Odontologo;
import com.example.ProyectoIntegradorPrueba.service.IDomicilioService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {

    private static final Logger logger = LogManager.getLogger(DomicilioController.class);
    @Autowired
    IDomicilioService iDomicilioService;

    @PostMapping
    public ResponseEntity<Domicilio> guardarDomicilio(@RequestBody Domicilio domicilio){
        logger.info("Solicitud para guardar domicilio: {}", domicilio);
        Domicilio nuevoDomicilio = iDomicilioService.guardarDomicilio(domicilio);
        return ResponseEntity.ok(nuevoDomicilio);
    }

    @PutMapping
    public ResponseEntity<Domicilio> actualizarDomicilio(@RequestBody  Domicilio domicilio){
        logger.info("Solicitud para editar domicilio: {}", domicilio);
        Domicilio domicilioModificado = iDomicilioService.actualizarDomicilio(domicilio);
        return ResponseEntity.ok(domicilioModificado  );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarDomicilio(@PathVariable Long id){
        logger.info("Solicitud para eliminar domicilio con id: {}", id);
        iDomicilioService.eliminarDomicilio(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
