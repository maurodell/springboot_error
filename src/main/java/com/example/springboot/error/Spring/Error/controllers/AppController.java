package com.example.springboot.error.Spring.Error.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/app")
    public String index(){
        //int value = 100 / 0;
        int value = Integer.parseInt("10x");
        return "ok 200";
    }
}
