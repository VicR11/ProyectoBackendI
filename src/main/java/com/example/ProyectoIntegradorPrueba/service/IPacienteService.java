package com.example.ProyectoIntegradorPrueba.service;

import com.example.ProyectoIntegradorPrueba.model.Odontologo;
import com.example.ProyectoIntegradorPrueba.model.Paciente;

import java.util.Set;

public interface IPacienteService {
    Paciente guardarPaciente(Paciente paciente);
    Paciente buscarPorId(Long id);
    Paciente buscarPorNombreApellido(String nombre, String apellido);
    Paciente modificarPaciente(Paciente paciente);
    void eliminarPaciente(Long id);
    Set<Paciente> ListarPacientes();
}
