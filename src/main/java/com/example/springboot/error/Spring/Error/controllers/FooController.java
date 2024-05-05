package com.example.springboot.error.Spring.Error.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class FooController {

    @GetMapping("/interceptor/foo")
    public ResponseEntity<?> foo(){
        return new ResponseEntity<>(Collections.singletonMap("message", "handler of foo controller"), HttpStatus.OK);
    }
    @GetMapping("/interceptor/bar")
    public ResponseEntity<?> bar(){
        return new ResponseEntity<>(Collections.singletonMap("message", "handler of bar controller"), HttpStatus.OK);
    }
    @GetMapping("/interceptor/baz")
    public ResponseEntity<?> baz(){
        return new ResponseEntity<>(Collections.singletonMap("message", "handler of baz controller"), HttpStatus.OK);
    }
}
