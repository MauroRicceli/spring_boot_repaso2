package com.practice2.practice2sboot.services;

import com.practice2.practice2sboot.exceptions.newexceptions.EmpleadoAlreadyRegistered;
import com.practice2.practice2sboot.models.domains.EmpleadoDomain;
import com.practice2.practice2sboot.models.dtos.EmpleadoDTO;
import com.practice2.practice2sboot.models.entities.EmpleadoEntity;
import com.practice2.practice2sboot.repositories.RepoEmpleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private RepoEmpleados repositorioEmpleados;

    public EmpleadoDTO registrarEmpleado(EmpleadoDTO emp){
        EmpleadoDomain prueba = new EmpleadoDomain(emp.getId(), emp.getNombre(), emp.getEmail(), emp.getEdad());
        EmpleadoEntity empleado = new EmpleadoEntity(emp.getId(), emp.getNombre(), emp.getEmail(), emp.getEdad());
        if(repositorioEmpleados.existsById(empleado.getId())){
            throw new EmpleadoAlreadyRegistered("El empleado con esa ID "+emp.getId()+" ya está registrado en el sistema");
        }


        repositorioEmpleados.save(empleado);
        return emp;
    }

    public List<EmpleadoDTO> obtenerEmpleadosRegistrados(){
        List<EmpleadoEntity> empleados = repositorioEmpleados.findAll();
        List<EmpleadoDTO> empleadosDTO = new ArrayList<>();
        for(EmpleadoEntity emp : empleados){
            empleadosDTO.add(new EmpleadoDTO());
        }
        return empleadosDTO;
    }
}
