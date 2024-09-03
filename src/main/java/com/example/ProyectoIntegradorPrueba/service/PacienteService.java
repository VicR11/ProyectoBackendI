package com.example.ProyectoIntegradorPrueba.service;

import com.example.ProyectoIntegradorPrueba.model.Paciente;
import com.example.ProyectoIntegradorPrueba.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteService implements IPacienteService{
    @Autowired
    IPacienteRepository iPacienteRepository;
    @Override
    public void guardarPaciente(Paciente paciente) {
        iPacienteRepository.save(paciente);
    }

    @Override
    public Paciente buscarPorId(Long id) {
        Optional<Paciente> pacienteBuscado = iPacienteRepository.findById(id);
        if (pacienteBuscado.isPresent()) {
            return pacienteBuscado.get();
        } else {
            return null;
        }
    }

    @Override
    public void modificarPaciente(Paciente paciente) {
        iPacienteRepository.save(paciente);
    }

    @Override
    public void eliminarPaciente(Long id) {
        iPacienteRepository.deleteById(id);
    }

    @Override
    public Set<Paciente> ListarPacientes() {
        Set<Paciente> pacientes = new HashSet<>(iPacienteRepository.findAll());
        return pacientes;
    }
}
