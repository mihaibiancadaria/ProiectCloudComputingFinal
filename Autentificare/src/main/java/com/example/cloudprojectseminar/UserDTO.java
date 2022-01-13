package com.example.cloudprojectseminar;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class UserDTO {
    @NotNull
    private String name;
    private String surname;
    @NotBlank(message = "Email can NOT be empty")
    @Pattern(regexp = "^(.+)@(.+)$")
    private String email;
    private String description;
    @NotBlank
    private String password;
    @Min(1)
    private Integer age;

    public UserDTO(String name, String surname, String email, String description, String password, Integer age) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.description = description;
        this.password = password;
        this.age = age;
    }
}
