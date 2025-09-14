package com.practice2.practice2sboot.services;

import com.practice2.practice2sboot.models.domains.DepartamentoCreateDomain;
import com.practice2.practice2sboot.models.domains.DepartamentoDomain;
import com.practice2.practice2sboot.models.dtos.DepartamentoCreateDTO;
import com.practice2.practice2sboot.models.dtos.DepartamentoDTO;
import com.practice2.practice2sboot.models.entities.DepartamentoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartamentoMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public DepartamentoMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public DepartamentoDTO convertirDepartamentoEntityADTO(DepartamentoEntity dpto){
        return modelMapper.map(dpto, DepartamentoDTO.class);
    }
    public DepartamentoDomain convertirDepartamentoDTOaDomain(DepartamentoDTO dpto){
        return modelMapper.map(dpto, DepartamentoDomain.class);
    }
    public DepartamentoEntity convertirDepartamentoDomainAEntity(DepartamentoDomain dpto){
        return modelMapper.map(dpto, DepartamentoEntity.class);
    }
    public DepartamentoDTO convertirDepartamentoDomainADTO(DepartamentoDomain dpto){
        return modelMapper.map(dpto, DepartamentoDTO.class);
    }
    public DepartamentoDomain convertirDepartamentoEntityADomain(DepartamentoEntity dpto){
        return modelMapper.map(dpto, DepartamentoDomain.class);
    }

    public DepartamentoEntity convertirDepartamentoCreateDTOaDepartamentoEntity(DepartamentoCreateDTO dpto){
        return modelMapper.map(dpto, DepartamentoEntity.class);
    }

    public List<DepartamentoDTO> convertirListaDepartamentosEntityADTO(List<DepartamentoEntity> dptos){
        List<DepartamentoDTO> aux = new ArrayList<DepartamentoDTO>();
        if(dptos != null){
            for(DepartamentoEntity dpto : dptos){
                aux.add(modelMapper.map(dpto, DepartamentoDTO.class));
            }
        }
        return aux;
    }

}
