package com.practice2.practice2sboot.models.domains;

import java.util.List;

public class DepartamentoCreateDomain {

    private String nombre, ubicacion;
    private List<EmpleadoDomain> empleados;

    public DepartamentoCreateDomain(String nombre, String ubicacion, List<EmpleadoDomain> empleados){
        if(nombre == null || nombre.length() <= 2){
            throw new IllegalArgumentException("El nombre no puede tener menos de 3 caracteres");
        }
        if(ubicacion == null || ubicacion.length() <= 10){
            throw new IllegalArgumentException("La ubicacion no puede tener menos de 10 caracteres");
        }
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.empleados = empleados;
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
