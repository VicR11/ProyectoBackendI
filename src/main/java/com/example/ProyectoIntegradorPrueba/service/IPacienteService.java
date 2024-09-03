package com.example.ProyectoIntegradorPrueba.service;

import com.example.ProyectoIntegradorPrueba.model.Paciente;

import java.util.Set;

public interface IPacienteService {
    void guardarPaciente(Paciente paciente);
    Paciente buscarPorId(Long id);
    void modificarPaciente(Paciente paciente);
    void eliminarPaciente(Long id);
    Set<Paciente> ListarPacientes();
}
