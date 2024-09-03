package com.example.ProyectoIntegradorPrueba.controller;

import com.example.ProyectoIntegradorPrueba.model.Odontologo;
import com.example.ProyectoIntegradorPrueba.model.Paciente;
import com.example.ProyectoIntegradorPrueba.service.IOdontologoService;
import com.example.ProyectoIntegradorPrueba.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    IPacienteService iPacienteService;

    @PostMapping
    public ResponseEntity<?> guardarPaciente(@RequestBody Paciente paciente){
        iPacienteService.guardarPaciente(paciente);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Paciente buscarPorId(@PathVariable Long id){
        return iPacienteService.buscarPorId(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarPaciente(@RequestBody  Paciente paciente){
        iPacienteService.modificarPaciente(paciente);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id){
        iPacienteService.eliminarPaciente(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<Paciente> listarPacientes(){
        return iPacienteService.ListarPacientes();
    }
}
