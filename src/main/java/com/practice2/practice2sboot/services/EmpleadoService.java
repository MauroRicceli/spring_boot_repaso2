package com.practice2.practice2sboot.services;

import com.practice2.practice2sboot.exceptions.newexceptions.EmpleadoAlreadyRegistered;
import com.practice2.practice2sboot.exceptions.newexceptions.EmpleadoDoesntExists;
import com.practice2.practice2sboot.models.domains.DepartamentoDomain;
import com.practice2.practice2sboot.models.domains.EmpleadoCreateDomain;
import com.practice2.practice2sboot.models.domains.EmpleadoDomain;
import com.practice2.practice2sboot.models.dtos.EmpleadoCreateDTO;
import com.practice2.practice2sboot.models.dtos.EmpleadoDTO;
import com.practice2.practice2sboot.models.entities.DepartamentoEntity;
import com.practice2.practice2sboot.models.entities.EmpleadoEntity;
import com.practice2.practice2sboot.repositories.RepoEmpleados;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    private final RepoEmpleados repositorioEmpleados;
    private final EmpleadoMapper empleadoMapper;
    private final DepartamentoMapper departamentoMapper;

    @Autowired
    public EmpleadoService(RepoEmpleados repositorioEmpleados, EmpleadoMapper empleadoMapper, DepartamentoMapper departamentoMapper){
        this.repositorioEmpleados = repositorioEmpleados;
        this.empleadoMapper = empleadoMapper;
        this.departamentoMapper = departamentoMapper;
    }

    public EmpleadoCreateDTO registrarEmpleado(EmpleadoCreateDTO emp){
        //Verificar que los datos son válidos.
        EmpleadoCreateDomain prueba = new EmpleadoCreateDomain(emp.getNombre(), emp.getEmail(), emp.getEdad());

        //Preparar la insert
        EmpleadoEntity empleado = new EmpleadoEntity();
        empleado.setEdad(emp.getEdad());
        empleado.setNombre(emp.getNombre());
        empleado.setEmail(emp.getEmail());

        //Insert
        repositorioEmpleados.save(empleado);

        return emp;
    }

    public List<EmpleadoDTO> obtenerEmpleadosRegistrados(){
        List<EmpleadoEntity> empleados = repositorioEmpleados.findAll();
        List<EmpleadoDTO> empleadosDTO = new ArrayList<>();
        for(EmpleadoEntity emp : empleados){
            empleadosDTO.add(empleadoMapper.convertirEmpleadoEntityADTO(emp));
        }
        return empleadosDTO;
    }

    public EmpleadoDTO borrarEmpleado(Long id){
        EmpleadoDTO emp;
        EmpleadoEntity aux = repositorioEmpleados.findById(id).orElseThrow(() -> new EmpleadoDoesntExists("El empleado de id "+id+" no existe en el sistema"));

        emp = empleadoMapper.convertirEmpleadoEntityADTO(aux);
        repositorioEmpleados.deleteById(id);
        return emp;
    }

    public EmpleadoDTO actualizarEmpleado(EmpleadoDTO emp){
        //verifico validez
        EmpleadoDomain aux = empleadoMapper.convertirEmpleadoDTOaDomain(emp);

        EmpleadoEntity empleado = repositorioEmpleados.findById(emp.getId()).orElseThrow(() -> new EmpleadoDoesntExists("El empleado de id "+emp.getId()+" no existe en el sistema"));

        empleado.setEmail(emp.getEmail());
        empleado.setNombre(emp.getNombre());
        empleado.setEdad(emp.getEdad());

        repositorioEmpleados.save(empleado);
        return emp;
    }

    public EmpleadoEntity obtenerEmpleadoPorID(Long empleadoID){
        EmpleadoEntity emp = repositorioEmpleados.findById(empleadoID).orElseThrow(() -> new EmpleadoDoesntExists("El empleado no existe en el sistema"));
        return emp;
    }

    public void guardarEmpleadoEntity(EmpleadoEntity emp){
        repositorioEmpleados.save(emp);
    }

    public boolean verificarExistenciaEmpleado(EmpleadoDTO emp){
        EmpleadoEntity aux = repositorioEmpleados.findById(emp.getId()).orElseThrow(() -> new EmpleadoDoesntExists("El empleado de id "+emp.getId()+" no existe en el sistema"));

        return true;
    }
}
