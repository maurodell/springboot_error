package com.example.springboot.error.Spring.Error.services.impl;

import com.example.springboot.error.Spring.Error.models.domain.User;
import com.example.springboot.error.Spring.Error.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private List<User> users;

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public Optional<User> findById(Long id) {

//        if(user == null){
//            return Optional.empty();
//        }
        //return Optional.ofNullable(user);//El ofNullable devuelve el objeto, pero si null devuelve un optional empty osea null.
                                        //El ofNullable lo que hace por abajo es un if.
        return users.stream()
                .filter(usr -> usr.getId().equals(id)).findFirst();
    }
}
