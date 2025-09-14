package com.practice2.practice2sboot.exceptions.newexceptions;

public class EmpleadoDoesntExists extends RuntimeException{

    public EmpleadoDoesntExists(String message){
        super(message);
    }
}
