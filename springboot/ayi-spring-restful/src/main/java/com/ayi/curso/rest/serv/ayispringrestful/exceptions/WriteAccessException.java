package com.ayi.curso.rest.serv.ayispringrestful.exceptions;

public class WriteAccessException extends ReadAccessException{

    public WriteAccessException(String message){
        super(message);
    }
}
