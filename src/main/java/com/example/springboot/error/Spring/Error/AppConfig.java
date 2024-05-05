package com.example.springboot.error.Spring.Error;

import com.example.springboot.error.Spring.Error.models.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    //simulación base de datos en memoria
    @Bean
    List<User> users() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "some name", "some last name"));
        users.add(new User(2L, "Buzz", "Light"));
        users.add(new User(3L, "Buddy", "Friend"));

        return users;
    }
}
