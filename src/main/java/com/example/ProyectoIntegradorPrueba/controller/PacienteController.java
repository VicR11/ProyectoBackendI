package com.example.ProyectoIntegradorPrueba.controller;

import com.example.ProyectoIntegradorPrueba.model.Odontologo;
import com.example.ProyectoIntegradorPrueba.model.Paciente;
import com.example.ProyectoIntegradorPrueba.service.IOdontologoService;
import com.example.ProyectoIntegradorPrueba.service.IPacienteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private static final Logger logger = LogManager.getLogger(PacienteController.class);
    @Autowired
    IPacienteService iPacienteService;

    @PostMapping
    public ResponseEntity<Paciente> guardarPaciente(@RequestBody Paciente paciente){
        logger.info("Solicitud para guardar paciente: {}", paciente);
        Paciente nuevoPaciente = iPacienteService.guardarPaciente(paciente);
        return ResponseEntity.ok(nuevoPaciente);
    }

    @GetMapping("/{id}")
    public Paciente buscarPorId(@PathVariable Long id){
        logger.info("Solicitud para buscar paciente por id: {}", id);
        return iPacienteService.buscarPorId(id);
    }

    @GetMapping("/buscar")
    public Paciente buscarPorNombreApellido(@RequestParam String nombre, @RequestParam String apellido){
        logger.info("Solicitud para buscar paciente: {}", nombre, apellido);
        return iPacienteService.buscarPorNombreApellido(nombre, apellido);
    }


    @PutMapping
    public ResponseEntity<Paciente> modificarPaciente(@RequestBody  Paciente paciente){
        logger.info("Solicitud para modificar paciente: {}", paciente);
        Paciente nuevoPaciente = iPacienteService.modificarPaciente(paciente);
        return ResponseEntity.ok(nuevoPaciente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id){
        logger.info("Solicitud para eliminar paciente con id: {}", id);
        iPacienteService.eliminarPaciente(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<Paciente> listarPacientes(){
        return iPacienteService.ListarPacientes();
    }
}
