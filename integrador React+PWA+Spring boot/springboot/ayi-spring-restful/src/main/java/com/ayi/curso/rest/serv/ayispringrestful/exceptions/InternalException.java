package com.ayi.curso.rest.serv.ayispringrestful.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalException extends Exception {

    public InternalException(String message, Throwable cause){
        super(message, cause);
    }

    public InternalException(String message){
        super(message);
    }
}
