package com.practice2.practice2sboot.models.domains;

import java.util.List;
import java.util.Objects;

public class DepartamentoDomain {
    private Long id;
    private String nombre, ubicacion;
    private List<EmpleadoDomain> empleados;

    public DepartamentoDomain(){}

    public DepartamentoDomain(Long id, String nombre, String ubicacion, List<EmpleadoDomain> empleados){
        if(id == null || id <= 0){
            throw new IllegalArgumentException("El id es vacio o inválido");
        }

        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.empleados = empleados;
    }

    @Override
    public boolean equals(Object object) {
        if(object instanceof DepartamentoDomain){
            DepartamentoDomain aux = (DepartamentoDomain) object;
            return Objects.equals(aux.getId(), this.id) && Objects.equals(aux.getNombre(), this.nombre) && Objects.equals(aux.getUbicacion(), this.ubicacion);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, ubicacion);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<EmpleadoDomain> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<EmpleadoDomain> empleados) {
        this.empleados = empleados;
    }
}
