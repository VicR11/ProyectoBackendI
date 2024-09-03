package com.example.ProyectoIntegradorPrueba.service;

import com.example.ProyectoIntegradorPrueba.model.Odontologo;

import java.util.Set;

public interface IOdontologoService {
    void guardarOdontologo(Odontologo odontologo);
    Odontologo buscarPorId(Long id);
    void modificarOdontologo(Odontologo odontologo);
    void eliminarOdontologo(Long id);
    Set<Odontologo> ListarOndontologos();
}
