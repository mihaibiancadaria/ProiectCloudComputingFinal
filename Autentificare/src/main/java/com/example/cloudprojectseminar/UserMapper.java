package com.example.cloudprojectseminar;


import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User dtoToEntity(UserDTO userDTO){
        return new User(userDTO.getName(), userDTO.getSurname(), userDTO.getEmail(), userDTO.getDescription(), userDTO.getPassword(), userDTO.getAge());
    }

    public UserCleanDTO entityToDto(User user){
        return new UserCleanDTO(user.getName(), user.getSurname(), user.getEmail(), user.getDescription(),user.getAge());
    }

}
