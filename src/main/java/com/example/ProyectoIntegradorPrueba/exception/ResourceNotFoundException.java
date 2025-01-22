package com.example.ProyectoIntegradorPrueba.exception;

public class ResourceNotFoundException extends RuntimeException {
    // extiende de RuntimeException y no de Exception para no tener que manejar la excepcion desde el controlador
    public ResourceNotFoundException(String message) {//constructor
        super(message);
    }
}
