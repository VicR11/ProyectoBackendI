package com.example.ProyectoIntegradorPrueba.service;

import com.example.ProyectoIntegradorPrueba.model.Odontologo;
import com.example.ProyectoIntegradorPrueba.model.Paciente;
import com.example.ProyectoIntegradorPrueba.repository.IPacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteService implements IPacienteService{
    private static final Logger logger = LogManager.getLogger(PacienteService.class);

    @Autowired
    IPacienteRepository iPacienteRepository;
    @Override
    public Paciente guardarPaciente(Paciente paciente) {
        logger.info("Iniciando guardar paciente: {}", paciente);
        return iPacienteRepository.save(paciente);
    }

    @Override
    public Paciente buscarPorId(Long id) {
        logger.info("Iniciando busqueda de paciente por id: {}", id);
        Optional<Paciente> pacienteBuscado = iPacienteRepository.findById(id);
        if (pacienteBuscado.isPresent()) {
            return pacienteBuscado.get();
        } else {
            throw new EntityNotFoundException("El paciente con el ID " + id + " no existe.");
        }
    }

    @Override
    public Paciente buscarPorNombreApellido(String nombre, String apellido) {
        logger.info("Iniciando busqueda de paciente: {}", nombre, apellido);
        String nombreNormalizado = nombre.toLowerCase();
        String apellidoNormalizado = apellido.toLowerCase();
        Optional<Paciente> pacienteBuscadoByNombreApellido = iPacienteRepository.findByNombreAndApellido(nombreNormalizado, apellidoNormalizado);
        if (pacienteBuscadoByNombreApellido.isPresent()) {
            return pacienteBuscadoByNombreApellido.get();
        } else {
            throw new EntityNotFoundException("El paciente" + nombre+" "+apellido + " no existe.");
        }
    }

    @Override
    public Paciente modificarPaciente(Paciente paciente) {
        logger.info("Iniciando modificacion de paciente: {}", paciente);
        Optional<Paciente> pacienteExistente = iPacienteRepository.findById(paciente.getId());

        if (pacienteExistente.isPresent()) {
            // Si existe, se actualizan los datos
            iPacienteRepository.save(paciente);
            return pacienteExistente.get();
        } else {
            // Si no existe, puedes manejar el caso según sea necesario
            // Por ejemplo, lanzar una excepción o retornar un mensaje de error
            throw new EntityNotFoundException("El paciente con el ID " + paciente.getId() + " no existe.");
        }
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
