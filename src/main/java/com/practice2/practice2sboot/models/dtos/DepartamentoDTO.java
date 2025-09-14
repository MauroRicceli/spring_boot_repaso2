package com.practice2.practice2sboot.models.dtos;

import java.util.List;

public class DepartamentoDTO {
    private long id;
    private String nombre, ubicacion;
    private List<EmpleadoDTO> empleados;

    public DepartamentoDTO(){}

    public DepartamentoDTO(Long id, String nombre, String ubicacion, List<EmpleadoDTO> empleados){
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.empleados = empleados;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
