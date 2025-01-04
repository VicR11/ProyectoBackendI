package com.example.ProyectoIntegradorPrueba.service;

import com.example.ProyectoIntegradorPrueba.model.Odontologo;
import com.example.ProyectoIntegradorPrueba.model.Turno;
import com.example.ProyectoIntegradorPrueba.repository.ITurnoRepósitory;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoService implements ITurnoService {
    @Autowired
    ITurnoRepósitory iTurnoRepository;
    @Override
    public Turno guardarTurno(Turno turno) {

        return iTurnoRepository.save(turno);
    }

    @Override
    public Turno buscarPorId(Long id) {
        Optional<Turno> turnoBuscado = iTurnoRepository.findById(id);
        if (turnoBuscado.isPresent()) {
            return turnoBuscado.get();
        } else {
            return null;
        }
    }

    @Override
    public void modificarTurno(Turno turno) {
        Optional<Turno> turnoExistente = iTurnoRepository.findById(turno.getId());

        if (turnoExistente.isPresent()) {
            // Si existe, se actualizan los datos
            iTurnoRepository.save(turno);
        } else {
            // Si no existe, puedes manejar el caso según sea necesario
            // Por ejemplo, lanzar una excepción o retornar un mensaje de error
            throw new EntityNotFoundException("El turno con el ID " + turno.getId() + " no existe.");
        }

    }

    @Override
    public void eliminarTurno(Long id) {
        iTurnoRepository.deleteById(id);
    }

    @Override
    public Set<Turno> ListarTurnos() {
        Set<Turno> turnos = new HashSet<>(iTurnoRepository.findAll());
        return turnos;
    }
}
