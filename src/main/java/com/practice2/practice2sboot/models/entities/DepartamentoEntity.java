package com.practice2.practice2sboot.models.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="departamentos")
public class DepartamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    private String ubicacion;

    @OneToMany(mappedBy = "departamento", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    List<EmpleadoEntity> empleados = new ArrayList<>();

    public DepartamentoEntity(){}

    public List<EmpleadoEntity> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<EmpleadoEntity> empleados) {
        this.empleados = empleados;
    }

    public DepartamentoEntity(Long id, String nombre, String ubicacion){
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
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
}
