package com.example.ProyectoIntegradorPrueba.service;

import com.example.ProyectoIntegradorPrueba.exception.ResourceNotFoundException;
import com.example.ProyectoIntegradorPrueba.model.Odontologo;

import java.util.Set;

public interface IOdontologoService {
    Odontologo guardarOdontologo(Odontologo odontologo);
    Odontologo buscarPorId(Long id) throws ResourceNotFoundException;
    Odontologo buscarPorMatricula(String matricula) throws ResourceNotFoundException;
    Odontologo buscarPorNombreApellido(String nombre, String apellido) throws ResourceNotFoundException;
    Odontologo modificarOdontologo(Odontologo odontologo);
    void eliminarOdontologo(Long id);
    Set<Odontologo> ListarOndontologos();
}
