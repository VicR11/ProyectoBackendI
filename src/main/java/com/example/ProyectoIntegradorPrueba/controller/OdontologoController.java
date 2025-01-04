package com.example.ProyectoIntegradorPrueba.controller;

import com.example.ProyectoIntegradorPrueba.model.Odontologo;
import com.example.ProyectoIntegradorPrueba.service.IOdontologoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    IOdontologoService iOdontologoService;

    private static final Logger logger = LogManager.getLogger(OdontologoController.class);

    @PostMapping
    public ResponseEntity<Odontologo> guardarOdontologo(@RequestBody Odontologo odontologo){
        logger.info("Solicitud para guardar odontologo: {}", odontologo);
        Odontologo nuevoOdontologo = iOdontologoService.guardarOdontologo(odontologo);
        return ResponseEntity.ok(nuevoOdontologo);
    }

    @GetMapping("/id/{id}")
    public Odontologo buscarPorId(@PathVariable Long id){
        logger.info("Solicitud para buscar odontologo con id: {}", id);
        return iOdontologoService.buscarPorId(id);
    }

    @GetMapping("/matricula/{matricula}")
    public Odontologo buscarPorMatricula(@PathVariable String matricula){
        logger.info("Solicitud para buscar odontologo con matriula: {}", matricula);
        return iOdontologoService.buscarPorMatricula(matricula);
    }

    @GetMapping("/buscar")
    public Odontologo buscarPorNombreApellido(@RequestParam String nombre, @RequestParam String apellido){
        logger.info("Solicitud para buscar odontologo: {}", nombre,apellido);
        return iOdontologoService.buscarPorNombreApellido(nombre, apellido);
    }

    @PutMapping
    public ResponseEntity<Odontologo> modificarOdontologo(@RequestBody  Odontologo odontologo){
        logger.info("Solicitud para editar odontologo: {}", odontologo);
        Odontologo odontologoModificado = iOdontologoService.modificarOdontologo(odontologo);
        return ResponseEntity.ok(odontologoModificado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id){
        logger.info("Solicitud para eliminar odontologo con id: {}", id);
        iOdontologoService.eliminarOdontologo(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<Odontologo> listarOdontologos(){
        logger.info("Solicitud para listar odontologos: {}");
        return iOdontologoService.ListarOndontologos();
    }

}
