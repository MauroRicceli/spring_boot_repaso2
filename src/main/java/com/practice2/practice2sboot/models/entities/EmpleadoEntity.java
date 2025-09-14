package com.practice2.practice2sboot.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name="empleados")
public class EmpleadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(nullable = false, unique = true)
    private String email;
    private int edad;

    @ManyToOne
    @JoinColumn(name = "departamento_id", nullable = true)
    private DepartamentoEntity departamento;

    public EmpleadoEntity(){}

    public EmpleadoEntity(Long id, String nombre, String email, int edad, DepartamentoEntity departamento){
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "EmpleadoEntity{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", edad=" + edad + '\'' +
                ", departamento="+departamento+
                '}';
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public DepartamentoEntity getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoEntity departamento) {
        this.departamento = departamento;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
