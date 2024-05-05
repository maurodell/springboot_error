package com.example.springboot.error.Spring.Error.controllers;

import com.example.springboot.error.Spring.Error.exceptions.UserNotFoundException;
import com.example.springboot.error.Spring.Error.models.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String , Object> numberFormarException(Exception e){
        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date().toString());
        error.put("error", "value or number incorrect");
        error.put("message", e.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return error;
    }

    @ExceptionHandler({HttpMessageNotWritableException.class,
            NullPointerException.class,
            UserNotFoundException.class})//solo maneja esta exception
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String , Object> userNotFoundException(Exception e){
        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date().toString());
        error.put("error", "el usuario o rol no existe");
        error.put("message", e.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return error;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorDTO> pathNotFound(NoHandlerFoundException ex){
        ErrorDTO error = new ErrorDTO();
        error.setDate(new Date());
        error.setError("Api rest not found");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(404).body(error);
    }
}
