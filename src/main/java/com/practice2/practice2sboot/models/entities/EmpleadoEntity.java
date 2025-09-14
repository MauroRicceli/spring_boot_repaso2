package com.practice2.practice2sboot.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Objects;

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
    @JsonManagedReference
    private Long departamento_id;

    public EmpleadoEntity(){}

    public EmpleadoEntity(Long id, String nombre, String email, int edad, Long departamento){
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
        this.departamento_id = departamento;
    }

    @Override
    public String toString() {
        return "EmpleadoEntity{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", edad=" + edad + '\'' +
                ", departamento="+departamento_id+
                '}';
    }

    @Override
    public boolean equals(Object object){
        if(object instanceof EmpleadoEntity){
            EmpleadoEntity aux = (EmpleadoEntity) object;
            return Objects.equals(aux.getId(), this.id) && Objects.equals(aux.getDepartamento(), this.departamento_id) && Objects.equals(aux.getEdad(), this.edad)
                    && Objects.equals(aux.getEmail(), this.email) && Objects.equals(aux.getNombre(), this.nombre);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, edad, nombre, email);
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

    public Long getDepartamento() {
        return departamento_id;
    }

    public void setDepartamento(Long departamento) {
        this.departamento_id = departamento;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
