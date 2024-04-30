package com.example.springboot.error.Spring.Error.controllers;

import com.example.springboot.error.Spring.Error.models.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice //esto lo que hace es que en vez de mapear un path, mappea una exception.
public class HandlerExceptionController {

    @ExceptionHandler({ArithmeticException.class})
    public ResponseEntity<ErrorDTO> divisionByZero(Exception ex){
        ErrorDTO error = new ErrorDTO();
        error.setDate(new Date());
        error.setError("Error division by zero!");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
        return ResponseEntity.internalServerError().body(error);
    }
}
