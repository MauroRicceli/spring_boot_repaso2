package com.practice2.practice2sboot.exceptions.newexceptions;

public class EmpleadoIsNotPartOfDepartment extends RuntimeException{

    public EmpleadoIsNotPartOfDepartment(String message){
        super(message);
    }
}
