package com.example.springboot.error.Spring.Error.services;

import com.example.springboot.error.Spring.Error.models.domain.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findById(Long id);
}
