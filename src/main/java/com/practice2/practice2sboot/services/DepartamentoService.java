package com.practice2.practice2sboot.services;

import com.practice2.practice2sboot.controllers.DepartamentoController;
import com.practice2.practice2sboot.exceptions.newexceptions.DepartamentoDoesntExists;
import com.practice2.practice2sboot.exceptions.newexceptions.EmpleadoIsNotPartOfDepartment;
import com.practice2.practice2sboot.models.domains.DepartamentoCreateDomain;
import com.practice2.practice2sboot.models.domains.DepartamentoDomain;
import com.practice2.practice2sboot.models.dtos.DepartamentoCreateDTO;
import com.practice2.practice2sboot.models.dtos.DepartamentoDTO;
import com.practice2.practice2sboot.models.dtos.EmpleadoDTO;
import com.practice2.practice2sboot.models.entities.DepartamentoEntity;
import com.practice2.practice2sboot.models.entities.EmpleadoEntity;
import com.practice2.practice2sboot.repositories.RepoDepartamento;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    private final DepartamentoMapper departamentoMapper;
    private final RepoDepartamento repositorioDepartamento;
    private final EmpleadoMapper empleadoMapper;
    private final EmpleadoService empleadoService;

    @Autowired
    public DepartamentoService( DepartamentoMapper departamentoMapper, RepoDepartamento repositorioDepartamento, EmpleadoMapper empleadoMapper, EmpleadoService empleadoService){
        this.departamentoMapper = departamentoMapper;
        this.repositorioDepartamento = repositorioDepartamento;
        this.empleadoMapper = empleadoMapper;
        this.empleadoService = empleadoService;
    }

    public DepartamentoCreateDTO crearDepartamento(DepartamentoCreateDTO dpto){
        DepartamentoCreateDomain prueba = new DepartamentoCreateDomain(dpto.getNombre(), dpto.getUbicacion(), empleadoMapper.convertirListEmpleadoDTOaDomain(dpto.getEmpleados()));

        repositorioDepartamento.save(departamentoMapper.convertirDepartamentoCreateDTOaDepartamentoEntity(dpto));
        return dpto;
    }

    public List<DepartamentoDTO> obtenerDepartamentos(){
        List<DepartamentoEntity> list = repositorioDepartamento.findAll();
        return departamentoMapper.convertirListaDepartamentosEntityADTO(list);
    }

    public DepartamentoDTO borrarDepartamento(Long id){

        DepartamentoEntity dpto = repositorioDepartamento.findById(id).orElseThrow(() -> new DepartamentoDoesntExists("El departamento de id "+id+" no existe en el sistema"));

        repositorioDepartamento.deleteById(id);

        return departamentoMapper.convertirDepartamentoEntityADTO(dpto);
    }

    public DepartamentoDTO agregarEmpleado(EmpleadoDTO emp, Long id){
        DepartamentoEntity dpto = repositorioDepartamento.findById(id).orElseThrow(() -> new DepartamentoDoesntExists("El departamento de id \"+id+\" no existe en el sistema"));

        if(!empleadoService.verificarExistenciaEmpleado(emp)){
            return null;
        }

        EmpleadoEntity empleado = empleadoService.obtenerEmpleadoPorID(emp.getId());
        empleado.setDepartamento(dpto);

        dpto.getEmpleados().add(empleado);
        empleadoService.guardarEmpleadoEntity(empleado);
        repositorioDepartamento.save(dpto);

        return departamentoMapper.convertirDepartamentoEntityADTO(dpto);

    }

    public DepartamentoDTO eliminarEmpleado(EmpleadoDTO emp, Long id){
        DepartamentoEntity dpto = repositorioDepartamento.findById(id).orElseThrow(() -> new DepartamentoDoesntExists("El departamento de id \"+id+\" no existe en el sistema"));

        if(!empleadoService.verificarExistenciaEmpleado(emp)){
            return null;
        }

        EmpleadoEntity empleado = empleadoMapper.convertirEmpleadoDTOaEntity(emp);

        System.out.println(empleado);

        if(!dpto.getEmpleados().remove(empleado)){
            throw new EmpleadoIsNotPartOfDepartment("El empleado no es parte del departamento indicado");
        }

        empleado.setDepartamento(null);
        repositorioDepartamento.save(dpto);

        return departamentoMapper.convertirDepartamentoEntityADTO(dpto);

    }

}
