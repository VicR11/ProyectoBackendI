package com.example.ProyectoIntegradorPrueba.controller;

import com.example.ProyectoIntegradorPrueba.model.Paciente;
import com.example.ProyectoIntegradorPrueba.model.Turno;
import com.example.ProyectoIntegradorPrueba.service.IPacienteService;
import com.example.ProyectoIntegradorPrueba.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    ITurnoService iTurnoService;

    @PostMapping
    public ResponseEntity<?> guardarTurno(@RequestBody Turno turno){
        iTurnoService.guardarTurno(turno);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Turno buscarPorId(@PathVariable Long id){
        return iTurnoService.buscarPorId(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarTurno(@RequestBody  Turno turno){
        iTurnoService.modificarTurno(turno);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable Long id){
        iTurnoService.eliminarTurno(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<Turno> listarTurnos(){
        return iTurnoService.ListarTurnos();
    }
}
