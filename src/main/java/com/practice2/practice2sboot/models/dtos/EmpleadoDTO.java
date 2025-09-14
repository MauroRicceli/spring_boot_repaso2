package com.practice2.practice2sboot.models.dtos;


import com.practice2.practice2sboot.models.entities.DepartamentoEntity;

public class EmpleadoDTO {
    private Long id;
    private String nombre, email;
    private int edad;
    private DepartamentoDTO dpto;

    public EmpleadoDTO(){}

    public EmpleadoDTO(Long id, String nombre, String email, int edad, DepartamentoDTO dpto){
        this.id = id;
        this.edad = edad;
        this.nombre = nombre;
        this.email = email;
        this.dpto = dpto;
    }

    public DepartamentoDTO getDpto() {
        return dpto;
    }

    public void setDpto(DepartamentoDTO dpto) {
        this.dpto = dpto;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
