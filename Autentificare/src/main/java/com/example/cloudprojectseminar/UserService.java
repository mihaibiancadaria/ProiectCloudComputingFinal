package com.example.cloudprojectseminar;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements ServiceI<User>{
    private UserRepo userRepo;
    private UserMapper userMapper;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserCleanDTO saveObject(User user){
        User userSaved =  userRepo.save(user);
//        UserCleanDTO userCleanDTO = new UserCleanDTO(userSaved.getName(), userSaved.getSurname(), userSaved.getEmail(), userSaved.getDescription(), userSaved.getAge());
        UserCleanDTO userCleanDTO = new UserCleanDTO(user.getName(), user.getSurname(), user.getEmail(), user.getDescription(),user.getAge());
        return userCleanDTO;
    }

    public User getObject(Long id){
        Optional<User> userFound = userRepo.getObject(id);
        if(userFound.isPresent()){
            return userFound.get();
        }
        throw new UserNotFoundException(id);
    }

    public List<User> getObject_name(String name){
        return userRepo.getObject_name(name);
    }

    public List<User> getAllObjects(){
        return userRepo.getAll();
    }

    public boolean deleteObject(Long id){
        return userRepo.delete(id);
    }

}
