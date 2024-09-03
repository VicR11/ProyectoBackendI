package com.example.ProyectoIntegradorPrueba.repository;

import com.example.ProyectoIntegradorPrueba.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository<Paciente, Long> {
}
