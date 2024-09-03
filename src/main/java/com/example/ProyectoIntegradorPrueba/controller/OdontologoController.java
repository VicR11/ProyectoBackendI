package com.example.ProyectoIntegradorPrueba.controller;

import com.example.ProyectoIntegradorPrueba.model.Odontologo;
import com.example.ProyectoIntegradorPrueba.service.IOdontologoService;
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

    @PostMapping
    public ResponseEntity<?> guardarOdontologo(@RequestBody Odontologo odontologo){
        iOdontologoService.guardarOdontologo(odontologo);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Odontologo buscarPorId(@PathVariable Long id){
        return iOdontologoService.buscarPorId(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarOdontologo(@RequestBody  Odontologo odontologo){
        iOdontologoService.modificarOdontologo(odontologo);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id){
        iOdontologoService.eliminarOdontologo(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<Odontologo> listarOdontologos(){
        return iOdontologoService.ListarOndontologos();
    }

}
