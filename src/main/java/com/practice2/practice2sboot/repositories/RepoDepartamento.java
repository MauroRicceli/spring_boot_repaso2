package com.practice2.practice2sboot.repositories;

import com.practice2.practice2sboot.models.entities.DepartamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoDepartamento extends JpaRepository<DepartamentoEntity, Long> {
}
