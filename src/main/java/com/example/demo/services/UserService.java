package com.example.demo.services;

import com.example.demo.models.UserModel;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel> getUsers(){
        return(ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }

    public Optional<UserModel> getById(Long id){
        return userRepository.findById(id);
    }
    public ArrayList<UserModel> getUserByPriority(Integer prioridad){
        return userRepository.findByPrioridad(prioridad);
    }

    public boolean deleteUser(Long id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}