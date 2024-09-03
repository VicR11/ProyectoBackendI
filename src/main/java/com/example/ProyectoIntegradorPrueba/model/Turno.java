package com.example.ProyectoIntegradorPrueba.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="turnos")
public class Turno {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="odontologo_id", nullable = false)
    private Odontologo odontologo;
    @ManyToOne
    @JoinColumn(name="paciente_id", nullable = false)
    private Paciente paciente;
    private LocalDateTime fechaHora;

    public Odontologo getOdontologo() {
        return odontologo;
    }
    public Long getId() {
        return id;
    }
    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }
}
