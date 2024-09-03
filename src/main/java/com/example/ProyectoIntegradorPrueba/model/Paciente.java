package com.example.ProyectoIntegradorPrueba.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="pacientes")
public class Paciente {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String apellido;
    private String domicilio;
    private Integer dni;
    private LocalDate fechaDeAlta;

    @OneToMany(mappedBy = "paciente")
    @JsonIgnore
    private Set<Turno> turno;

    public String getNombre() {
        return nombre;
    }
    public Long getId() {
        return id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public LocalDate getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaDeAlta(LocalDate fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    public Set<Turno> getTurno() {
        return turno;
    }

    public void setTurno(Set<Turno> turno) {
        this.turno = turno;
    }
}
