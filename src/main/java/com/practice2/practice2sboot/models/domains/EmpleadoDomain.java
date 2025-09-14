package com.practice2.practice2sboot.models.domains;

import java.util.Objects;

public class EmpleadoDomain {
    private Long id;
    private int edad;
    private String nombre, email;

    public EmpleadoDomain(Long id, String nombre, String email, int edad){
        if(id <= 0){
            throw new IllegalArgumentException("El id del empleado debe ser mayor a 0");
        }
        this.id = id;
        this.edad = edad;
        this.nombre = nombre;
        this.email = email;
    }

    @Override
    public boolean equals(Object object){
        if(object instanceof EmpleadoDomain){
            EmpleadoDomain aux = (EmpleadoDomain) object;
            return Objects.equals(aux.getEdad(), this.edad) && Objects.equals(aux.getEmail(), this.email) && Objects.equals(aux.getId(), this.id)
                    && Objects.equals(aux.getNombre(), this.nombre);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return id.hashCode() + edad + email.hashCode() + nombre.hashCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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
}
