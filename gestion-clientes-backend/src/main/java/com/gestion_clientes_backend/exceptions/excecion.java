package com.gestion_clientes_backend.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class excecion  extends RuntimeException{

    private static final Long serialVersionUID = 1L;

    public excecion (String message){
        super(message);
    }
}
