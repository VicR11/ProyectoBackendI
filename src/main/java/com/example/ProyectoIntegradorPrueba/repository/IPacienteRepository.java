package com.example.ProyectoIntegradorPrueba.repository;

import com.example.ProyectoIntegradorPrueba.model.Odontologo;
import com.example.ProyectoIntegradorPrueba.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPacienteRepository extends JpaRepository<Paciente, Long> {
    Optional<Paciente> findByNombreAndApellido(String nombre, String apellido);

}
