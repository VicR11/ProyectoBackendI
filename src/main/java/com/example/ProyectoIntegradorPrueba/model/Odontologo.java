package com.example.ProyectoIntegradorPrueba.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "odontologos")
public class Odontologo {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String apellido;
    private String matricula;

    @OneToMany(mappedBy = "odontologo")
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Set<Turno> getTurno() {
        return turno;
    }

    public void setTurno(Set<Turno> turno) {
        this.turno = turno;
    }
}
