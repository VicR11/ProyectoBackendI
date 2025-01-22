package com.example.ProyectoIntegradorPrueba.service;

import com.example.ProyectoIntegradorPrueba.exception.ResourceNotFoundException;
import com.example.ProyectoIntegradorPrueba.model.Odontologo;
import com.example.ProyectoIntegradorPrueba.model.Paciente;

import java.util.Set;

public interface IPacienteService {
    Paciente guardarPaciente(Paciente paciente);
    Paciente buscarPorId(Long id) throws ResourceNotFoundException;
    Paciente buscarPorNombreApellido(String nombre, String apellido) throws ResourceNotFoundException;
    Paciente modificarPaciente(Paciente paciente);
    void eliminarPaciente(Long id);
    Set<Paciente> ListarPacientes();
}
