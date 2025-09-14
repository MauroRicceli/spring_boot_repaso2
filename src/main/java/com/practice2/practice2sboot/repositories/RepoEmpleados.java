package com.practice2.practice2sboot.repositories;

import com.practice2.practice2sboot.models.entities.EmpleadoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RepoEmpleados extends CrudRepository<EmpleadoEntity, Long> {

}
