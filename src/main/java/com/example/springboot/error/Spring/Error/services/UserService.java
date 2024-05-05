package com.example.springboot.error.Spring.Error.services;

import com.example.springboot.error.Spring.Error.models.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();
    Optional<User> findById(Long id);
}
