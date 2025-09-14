package com.practice2.practice2sboot.services;

import com.practice2.practice2sboot.models.domains.EmpleadoDomain;
import com.practice2.practice2sboot.models.dtos.EmpleadoDTO;
import com.practice2.practice2sboot.models.entities.EmpleadoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public EmpleadoMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public EmpleadoDTO convertirEmpleadoEntityADTO(EmpleadoEntity emp){
        return modelMapper.map(emp, EmpleadoDTO.class);
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
}
