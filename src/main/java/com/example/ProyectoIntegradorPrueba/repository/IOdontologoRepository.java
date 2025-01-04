package com.example.ProyectoIntegradorPrueba.repository;

import com.example.ProyectoIntegradorPrueba.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo,Long> {
    Optional<Odontologo> findByMatricula(String matricula);
    Optional<Odontologo> findByNombreAndApellido(String nombre, String apellido);

}
