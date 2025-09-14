package com.practice2.practice2sboot.models.domains;

public class EmpleadoCreateDomain {
    private int edad;
    private String nombre, email;

    public EmpleadoCreateDomain(){}

    public EmpleadoCreateDomain(String nombre, String email, int edad){
        if(edad < 18 || edad > 90){
            throw new IllegalArgumentException("La edad ingresada es inválida");
        }
        if(nombre == null || nombre.length() <= 2){
            throw new IllegalArgumentException("El nombre ingresado es inválido");
        }
        if(email == null || email.length() <= 11){
            throw new IllegalArgumentException("El email ingresado es inválido");
        }
        this.edad = edad;
        this.nombre = nombre;
        this.email = email;
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
