package com.example.ProyectoIntegradorPrueba.repository;

import com.example.ProyectoIntegradorPrueba.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo,Long> {
}
