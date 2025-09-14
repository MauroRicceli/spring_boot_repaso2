package com.practice2.practice2sboot;

import com.practice2.practice2sboot.models.domains.EmpleadoDomain;
import com.practice2.practice2sboot.models.entities.EmpleadoEntity;
import com.practice2.practice2sboot.repositories.RepoEmpleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

    @Autowired
    private RepoEmpleados repositorioEmpleados;

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

    //para realizar cosas una vez que el servicio este levantado
    @Override
    public void run(String... args) throws Exception {

    }
}
