package com.practice2.practice2sboot.exceptions.newexceptions;

public class DepartamentoDoesntExists extends RuntimeException {

    public DepartamentoDoesntExists(String message){
        super(message);
    }
}
