package com.practice2.practice2sboot.exceptions;

import com.practice2.practice2sboot.exceptions.newexceptions.DepartamentoDoesntExists;
import com.practice2.practice2sboot.exceptions.newexceptions.EmpleadoAlreadyRegistered;
import com.practice2.practice2sboot.exceptions.newexceptions.EmpleadoDoesntExists;
import com.practice2.practice2sboot.exceptions.newexceptions.EmpleadoIsNotPartOfDepartment;
import org.apache.coyote.Response;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Handler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> catchIllegalArgumentException(IllegalArgumentException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmpleadoAlreadyRegistered.class)
    public ResponseEntity<String> catchEmpleadoAlreadyRegisteredException(EmpleadoAlreadyRegistered e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> catchDataIntegrityViolationException(DataIntegrityViolationException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmpleadoDoesntExists.class)
    public ResponseEntity<String> catchEmpleadoDoesntExists(EmpleadoDoesntExists e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DepartamentoDoesntExists.class)
    public ResponseEntity<String> catchDepartamentoDoesntExists(DepartamentoDoesntExists e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmpleadoIsNotPartOfDepartment.class)
    public ResponseEntity<String> catchEmpleadoIsNotPartOfDepartment(EmpleadoIsNotPartOfDepartment e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
