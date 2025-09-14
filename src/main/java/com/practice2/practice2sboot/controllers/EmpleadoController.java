package com.practice2.practice2sboot.controllers;

import com.practice2.practice2sboot.models.dtos.EmpleadoCreateDTO;
import com.practice2.practice2sboot.models.dtos.EmpleadoDTO;
import com.practice2.practice2sboot.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping(value="/register", produces = "application/json", consumes = "application/json")
    public ResponseEntity<EmpleadoCreateDTO> registerEmpleado(@RequestBody EmpleadoCreateDTO emp){
        return new ResponseEntity<>(empleadoService.registrarEmpleado(emp), HttpStatus.ACCEPTED);
    }

    @GetMapping(value="/allempleados", produces = "application/json")
    public ResponseEntity<List<EmpleadoDTO>> getAllEmpleados(){
        return new ResponseEntity<>(empleadoService.obtenerEmpleadosRegistrados(), HttpStatus.ACCEPTED);
    }
}
