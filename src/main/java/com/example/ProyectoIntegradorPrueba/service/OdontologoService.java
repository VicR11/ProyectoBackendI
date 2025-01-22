package com.example.ProyectoIntegradorPrueba.service;

import com.example.ProyectoIntegradorPrueba.exception.ResourceNotFoundException;
import com.example.ProyectoIntegradorPrueba.model.Odontologo;
import com.example.ProyectoIntegradorPrueba.repository.IOdontologoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService{
    private static final Logger logger = LogManager.getLogger(OdontologoService.class);
    @Autowired
    private IOdontologoRepository iodontologoRepository;

    @Override
    public Odontologo guardarOdontologo(Odontologo odontologo) {
            //funcion para evitar duplicados utilizando la matricula
            logger.info("Iniciando guardarOdontologo con datos: {}", odontologo);
          return iodontologoRepository.save(odontologo);
    }

    @Override
    public Odontologo buscarPorId(Long id) throws ResourceNotFoundException {
        // findById carga la entidad completa
        logger.info("Iniciando buscar odontologo con: {}", id);


        //try {
            // Intentar buscar el odontólogo en la base de datos
            Optional<Odontologo> odontologoBuscado = iodontologoRepository.findById(id);
            if (odontologoBuscado.isPresent()) {
                return odontologoBuscado.get();
            } else {
                // Lanzar ResourceNotFoundException si no se encuentra el odontólogo
                throw new ResourceNotFoundException("No se encontró el odontólogo con ID " + id);
            }
        /*} catch (Exception ex) {
            // Capturar cualquier excepción inesperada y encapsularla en InternalServerErrorException
            logger.error("Error inesperado al buscar el odontólogo con ID: {}", id, ex);
            throw new InternalServerErrorException("Ocurrió un error interno al buscar el odontólogo con ID " + id);
        }*/
    }

    @Override
    public Odontologo buscarPorMatricula(String matricula) throws ResourceNotFoundException {
        logger.info("Iniciando buscar odontologo por matricula: {}", matricula);
        Optional<Odontologo> odontologoBuscadoByMatricula = iodontologoRepository.findByMatricula(matricula);
        if (odontologoBuscadoByMatricula.isPresent()) {
            return odontologoBuscadoByMatricula.get();
        } else {
            throw new ResourceNotFoundException("El odontólogo con la matricula " + matricula + " no existe.");
        }
    }

    @Override
    public Odontologo buscarPorNombreApellido(String nombre, String apellido) throws ResourceNotFoundException{
        logger.info("Iniciando buscar odontologo: {}", nombre, apellido);
        String nombreNormalizado = nombre.toLowerCase();
        String apellidoNormalizado = apellido.toLowerCase();
        Optional<Odontologo> odontologoBuscadoByNombreAndApellido = iodontologoRepository.findByNombreAndApellido(nombreNormalizado, apellidoNormalizado);
        if (odontologoBuscadoByNombreAndApellido.isPresent()) {
            return odontologoBuscadoByNombreAndApellido.get();
        } else {
            throw new ResourceNotFoundException("El odontólogo " + nombre+ " "+apellido + " no existe.");
        }
    }


    @Override
    public Odontologo modificarOdontologo(Odontologo odontologo) {
        logger.info("Iniciando modificacion de odontologo: {}", odontologo);
        Optional<Odontologo> odontologoExistente = iodontologoRepository.findById(odontologo.getId());

        if (odontologoExistente.isPresent()) {
            iodontologoRepository.save(odontologo);
            return odontologoExistente.get();
        } else {
            throw new EntityNotFoundException("El odontólogo con el ID " + odontologo.getId() + " no existe.");
        }
    }

    @Override
    public void eliminarOdontologo(Long id) {
        logger.info("Iniciando eliminacion de odontologo: {}", id);
       if(iodontologoRepository.existsById(id)) {
           iodontologoRepository.deleteById(id);
       }else {
           throw new EntityNotFoundException("El odontólogo con el ID " + id + " no existe.");
       }
    }

    @Override
    public Set<Odontologo> ListarOndontologos() {
        Set<Odontologo> odontologos = new HashSet<>(iodontologoRepository.findAll());
        return odontologos;
    }
}
