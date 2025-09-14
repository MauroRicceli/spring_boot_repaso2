package com.practice2.practice2sboot.repositories;

import com.practice2.practice2sboot.models.entities.EmpleadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoEmpleados extends JpaRepository<EmpleadoEntity, Long> {

}
