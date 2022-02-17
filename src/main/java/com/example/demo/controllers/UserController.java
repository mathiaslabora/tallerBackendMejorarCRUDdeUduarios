package com.example.demo.controllers;

import com.example.demo.models.UserModel;
import com.example.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

//refactorizado a ingles

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public ArrayList<UserModel> getUsers(){

        return userService.getUsers();

    }

    @PostMapping()
    public UserModel saveUser(@RequestBody UserModel user){
        return this.userService.saveUser(user);
    }

    @GetMapping( path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") long id){
        return this.userService.getById(id);
    }
    @GetMapping("/query")
    public ArrayList<UserModel> getUserByPriority(@RequestParam("prioridad") Integer priority){
        return this.userService.getUserByPriority(priority);
    }

    @DeleteMapping( path = "/{id}")
    public String deleteById(@PathVariable("id") Long id){
        boolean ok = this.userService.deleteUser(id);
        if(ok){
            return "Se elimino el usuario id: "+ id;
        }else {
            return "No se pudo eliminar el usuario con id: "+id;
        }
    }

}
