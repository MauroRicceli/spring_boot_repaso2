package com.practice2.practice2sboot.controllers;

import com.practice2.practice2sboot.models.dtos.DepartamentoCreateDTO;
import com.practice2.practice2sboot.models.dtos.DepartamentoDTO;
import com.practice2.practice2sboot.models.dtos.EmpleadoDTO;
import com.practice2.practice2sboot.services.DepartamentoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departamento")
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    @Autowired
    public DepartamentoController(DepartamentoService departamentoService){
        this.departamentoService = departamentoService;
    }

    @PutMapping(value="/crearDepartamento", produces = "application/json", consumes = "application/json")
    public ResponseEntity<DepartamentoCreateDTO> crearDepartamento(@RequestBody DepartamentoCreateDTO dpto){
        return new ResponseEntity<>(departamentoService.crearDepartamento(dpto), HttpStatus.ACCEPTED);
    }

    @GetMapping(value="/obtenerDepartamentos", produces = "application/json")
    public ResponseEntity<List<DepartamentoDTO>> obtenerDepartamentos(){
        return new ResponseEntity<>(departamentoService.obtenerDepartamentos(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value="/borrarDepartamento/{id}", produces="application/json")
    public ResponseEntity<DepartamentoDTO> borrarDepartamento(@PathVariable Long id){
        return new ResponseEntity<>(departamentoService.borrarDepartamento(id), HttpStatus.ACCEPTED);
    }

    @PostMapping(value="/agregarEmpleado/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<DepartamentoDTO> agregarEmpleado(@RequestBody EmpleadoDTO emp, @PathVariable Long id){
        return new ResponseEntity<>(departamentoService.agregarEmpleado(emp, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value="/eliminarEmpleado/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<DepartamentoDTO> eliminarEmpleado(@RequestBody EmpleadoDTO emp, @PathVariable Long id){
        return new ResponseEntity<>(departamentoService.eliminarEmpleado(emp, id), HttpStatus.ACCEPTED);
    }
}
