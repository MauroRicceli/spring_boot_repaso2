package com.practice2.practice2sboot.models.dtos;

import java.util.List;

public class DepartamentoCreateDTO {
    private String nombre, ubicacion;
    private List<EmpleadoDTO> empleados;

    public DepartamentoCreateDTO(){}

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

    public List<EmpleadoDTO> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<EmpleadoDTO> empleados) {
        this.empleados = empleados;
    }
}
