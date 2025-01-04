package com.example.ProyectoIntegradorPrueba.service;

import com.example.ProyectoIntegradorPrueba.model.Domicilio;

public interface IDomicilioService {
    Domicilio guardarDomicilio(Domicilio domicilio);
    Domicilio actualizarDomicilio(Domicilio domicilio);
    void eliminarDomicilio(Long id);



}
