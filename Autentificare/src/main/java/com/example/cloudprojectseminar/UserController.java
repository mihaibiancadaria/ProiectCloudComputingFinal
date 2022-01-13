package com.example.cloudprojectseminar;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public UserCleanDTO saveUser(@Valid @RequestBody UserDTO userRequest){
        User userHelp = userMapper.dtoToEntity(userRequest);
        UserCleanDTO userClean = userService.saveObject(userHelp);
        return userClean;
    }

    @GetMapping("/{id}")
    public UserCleanDTO getUser(@PathVariable Long id){
        return userMapper.entityToDto(userService.getObject(id));
    }

    @GetMapping
    public List<UserCleanDTO> getAllUsers(){
        List<User> userList = userService.getAllObjects();
        List<UserCleanDTO> usersDTOlist = new ArrayList<>();
        for(User user:userList){
            usersDTOlist.add(userMapper.entityToDto(user));
        }
        return usersDTOlist;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        if(userService.deleteObject(id))
            return "Userul a fost sters.";
        return  "Userul nu a fost gasit.";
    }


}
