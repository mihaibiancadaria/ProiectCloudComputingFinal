package com.example.cloudprojectseminar;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCleanDTO {
    private String name;
    private String surname;
    private String email;
    private String description;
    private Integer age;

    public UserCleanDTO(String name, String surname, String email, String description, Integer age) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.description = description;
        this.age = age;
    }
}

