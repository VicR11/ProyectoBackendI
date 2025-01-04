package com.example.ProyectoIntegradorPrueba.service;

import com.example.ProyectoIntegradorPrueba.model.Turno;

import java.util.Set;

public interface ITurnoService {
    Turno guardarTurno(Turno turno);
    Turno buscarPorId(Long id);
    void modificarTurno(Turno turno);
    void eliminarTurno(Long id);
    Set<Turno> ListarTurnos();
}
