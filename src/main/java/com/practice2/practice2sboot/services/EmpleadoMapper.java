package com.practice2.practice2sboot.services;

import com.practice2.practice2sboot.models.domains.EmpleadoDomain;
import com.practice2.practice2sboot.models.dtos.EmpleadoDTO;
import com.practice2.practice2sboot.models.entities.EmpleadoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoMapper {

    private final ModelMapper modelMapper;
    private final DepartamentoMapper departamentoMapper;

    @Autowired
    public EmpleadoMapper(ModelMapper modelMapper, DepartamentoMapper departamentoMapper){
        this.modelMapper = modelMapper;
        this.departamentoMapper = departamentoMapper;
    }

    public EmpleadoDTO convertirEmpleadoEntityADTO(EmpleadoEntity emp){
        EmpleadoDTO empleado = new EmpleadoDTO(emp.getId(), emp.getNombre(), emp.getEmail(), emp.getEdad(), departamentoMapper.convertirDepartamentoEntityADTO(emp.getDepartamento()));
        return empleado;
    }

    public EmpleadoEntity convertirEmpleadoDomainAEntity(EmpleadoDomain emp){
        return modelMapper.map(emp, EmpleadoEntity.class);
    }

    public EmpleadoDomain convertirEmpleadoEntityADomain(EmpleadoEntity emp){
        return modelMapper.map(emp, EmpleadoDomain.class);
    }

    public EmpleadoDTO convertirEmpleadoDomainADTO(EmpleadoDomain emp){
        return modelMapper.map(emp, EmpleadoDTO.class);
    }

    public EmpleadoDomain convertirEmpleadoDTOaDomain(EmpleadoDTO emp){
        return modelMapper.map(emp, EmpleadoDomain.class);
    }

    public List<EmpleadoDomain> convertirListEmpleadoDTOaDomain(List<EmpleadoDTO> emps){
        List<EmpleadoDomain> empsDomain = new ArrayList<EmpleadoDomain>();
        if(emps != null){
            for(EmpleadoDTO emp : emps){
                empsDomain.add(modelMapper.map(emp,EmpleadoDomain.class));
            }
        }
        return empsDomain;
    }

    public EmpleadoEntity convertirEmpleadoDTOaEntity(EmpleadoDTO emp){
        return modelMapper.map(emp, EmpleadoEntity.class);
    }
}
