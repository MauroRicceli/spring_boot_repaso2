package com.practice2.practice2sboot.exceptions;

import com.practice2.practice2sboot.exceptions.newexceptions.EmpleadoAlreadyRegistered;
import org.apache.coyote.Response;
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
}
