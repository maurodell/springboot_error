package com.example.springboot.error.Spring.Error.models.domain;

public class User {
    private Long id;
    private String name;
    private String lastname;

    private Rol role;

    public User() {
    }

    public User(Long id, String name, String lastname) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
    }

    public Rol getRole() {
        return role;
    }
//    public String getRoleName() {
//        return role.getName();
//    }

    public void setRole(Rol role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
