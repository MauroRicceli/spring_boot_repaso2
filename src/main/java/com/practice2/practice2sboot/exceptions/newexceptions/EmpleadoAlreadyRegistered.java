package com.practice2.practice2sboot.exceptions.newexceptions;

public class EmpleadoAlreadyRegistered extends RuntimeException{

    public EmpleadoAlreadyRegistered(String message){
        super(message);
    }
}
