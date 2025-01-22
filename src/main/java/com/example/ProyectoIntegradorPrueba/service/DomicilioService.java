package com.example.ProyectoIntegradorPrueba.service;

import com.example.ProyectoIntegradorPrueba.model.Domicilio;
import com.example.ProyectoIntegradorPrueba.model.Odontologo;
import com.example.ProyectoIntegradorPrueba.model.Paciente;
import com.example.ProyectoIntegradorPrueba.repository.IDomicilioRepository;
import com.example.ProyectoIntegradorPrueba.repository.IPacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DomicilioService implements IDomicilioService{
    @Autowired
    IDomicilioRepository iDomicilioRepository;

    @Override
    public Domicilio guardarDomicilio(Domicilio domicilio) {
        return iDomicilioRepository.save(domicilio);
    }

    @Override
    public Domicilio actualizarDomicilio(Domicilio domicilio) {
        Optional<Domicilio> domicilioExistente = iDomicilioRepository.findById(domicilio.getId());

        if (domicilioExistente.isPresent()) {
            // Si existe, se actualizan los datos
            Domicilio nuevoDomicilio = iDomicilioRepository.save(domicilio);
            return nuevoDomicilio;
        } else {
            throw new EntityNotFoundException("El domicilio con el ID " + domicilio.getId() + " no existe.");
        }
    }

    @Override
    public void eliminarDomicilio(Long id) {
        Optional<Domicilio> domicilioBuscado = iDomicilioRepository.findById(id);
        if (domicilioBuscado.isPresent()) {
            iDomicilioRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("El domiclio con el ID " + id + " no existe.");
        }
    }
}
