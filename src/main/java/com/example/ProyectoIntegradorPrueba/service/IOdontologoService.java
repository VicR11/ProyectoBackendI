package com.example.ProyectoIntegradorPrueba.service;

import com.example.ProyectoIntegradorPrueba.model.Odontologo;

import java.util.Set;

public interface IOdontologoService {
    Odontologo guardarOdontologo(Odontologo odontologo);
    Odontologo buscarPorId(Long id);
    Odontologo buscarPorMatricula(String natricula);
    Odontologo buscarPorNombreApellido(String nombre, String apellido);
    Odontologo modificarOdontologo(Odontologo odontologo);
    void eliminarOdontologo(Long id);
    Set<Odontologo> ListarOndontologos();
}
