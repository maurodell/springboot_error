package com.example.springboot.error.Spring.Error.services.impl;

import com.example.springboot.error.Spring.Error.models.domain.User;
import com.example.springboot.error.Spring.Error.services.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private List<User> users;
    public UserServiceImpl() {
        this.users = new ArrayList<>();
        users.add(new User(1L, "some name", "some last name"));
        users.add(new User(2L, "Buzz", "Light"));
        users.add(new User(3L, "Buddy", "Friend"));
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findById(Long id) {
        User user = null;
        for (User u : users) {
            if (u.getId().equals(id)){
                user = u;
                break;
            }
        }
        return user;
    }
}
