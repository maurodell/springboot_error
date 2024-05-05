package com.example.springboot.error.Spring.Error.controllers;

import com.example.springboot.error.Spring.Error.exceptions.UserNotFoundException;
import com.example.springboot.error.Spring.Error.models.domain.User;
import com.example.springboot.error.Spring.Error.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private UserService service;

    @GetMapping
    public String index(){
        //int value = 100 / 0;
        int value = Integer.parseInt("10x");
        return "ok 200";
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<?> viewUser(@PathVariable(name = "id") Long id){
        User user = service.findById(id).orElseThrow(() -> new UserNotFoundException("Error, el usuario no existe!"));
//        Optional<User> user = service.findById(id);
//        if(user.isEmpty()){
//            return ResponseEntity.notFound().build();
//        }
        System.out.println(user.getName());
        return ResponseEntity.ok(user);
    }
}
