package com.cage.users.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.Map;


@RestController
public class UserController {


    @Autowired
    UserRepo userRepo;

    @GetMapping("/users")
    public Iterable<Users> getAllUsers(){
        return userRepo.findAll();
    }

    @GetMapping("/users/{id}")
    public Users findByIdUser(@PathVariable Long id){
        return userRepo.findById(id).orElse(null);
    }

    @PostMapping("/users")
    public Users create(@RequestBody Users users){
        return userRepo.save(users);
    }


    @PutMapping("/users/{id}")
    public Users update(@PathVariable Long id, @RequestBody Users user){
        user.setId(id);
        return userRepo.save(user);
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id){
        userRepo.deleteById(id);


    }

    //Change password user
    @PatchMapping("/users/{id}")
    public Users changeUserPass(@PathVariable Long id,@RequestBody Map<Object, Object> mapObject){

        Users user = userRepo.findById(id).orElse(null);

        mapObject.forEach((key,value)->{
            Field field = ReflectionUtils.findField(Users.class, (String) key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, user, value);
        });

        return userRepo.save(user);



    }



}
