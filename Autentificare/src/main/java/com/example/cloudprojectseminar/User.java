package com.example.cloudprojectseminar;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String description;
    private String password;
    private Integer age;

    public User(Long id, String name, String surname, String email, String description, String password, Integer age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.description = description;
        this.password = password;
        this.age = age;
    }

    public User(String name, String surname, String email, String description, String password, Integer age) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.description = description;
        this.password = password;
        this.age = age;
    }

    public User() {

    }
}
