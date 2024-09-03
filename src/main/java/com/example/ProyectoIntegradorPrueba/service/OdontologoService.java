package com.example.ProyectoIntegradorPrueba.service;

import com.example.ProyectoIntegradorPrueba.model.Odontologo;
import com.example.ProyectoIntegradorPrueba.repository.IOdontologoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService{

    @Autowired
    private IOdontologoRepository iodontologoRepository;

    @Override
    public void guardarOdontologo(Odontologo odontologo) {
        iodontologoRepository.save(odontologo);
    }

    @Override
    public Odontologo buscarPorId(Long id) {
        Optional<Odontologo> odontologoBuscado = iodontologoRepository.findById(id);
        if (odontologoBuscado.isPresent()) {
            return odontologoBuscado.get();
        } else {
            return null;
        }
    }

    @Override
    public void modificarOdontologo(Odontologo odontologo) {

        //iodontologoRepository.save(odontologo);
        Optional<Odontologo> odontologoExistente = iodontologoRepository.findById(odontologo.getId());

        if (odontologoExistente.isPresent()) {
            // Si existe, se actualizan los datos
            iodontologoRepository.save(odontologo);
        } else {
            // Si no existe, puedes manejar el caso según sea necesario
            // Por ejemplo, lanzar una excepción o retornar un mensaje de error
            throw new EntityNotFoundException("El odontólogo con el ID " + odontologo.getId() + " no existe.");
        }
    }

    @Override
    public void eliminarOdontologo(Long id) {
       iodontologoRepository.deleteById(id);
    }

    @Override
    public Set<Odontologo> ListarOndontologos() {
        Set<Odontologo> odontologos = new HashSet<>(iodontologoRepository.findAll());
        return odontologos;
    }
}
