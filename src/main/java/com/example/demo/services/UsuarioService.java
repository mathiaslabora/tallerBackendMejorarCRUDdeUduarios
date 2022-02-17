package com.example.demo.services;

import com.example.demo.models.UserModel;
import com.example.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UserModel> obtenerUsuarios(){
        return(ArrayList<UserModel>) usuarioRepository.findAll();
    }

    public UserModel guardarUsuario(UserModel usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<UserModel> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }
    public ArrayList<UserModel> obtenerPorPrioridad(Integer prioridad){
        return usuarioRepository.findByPrioridad(prioridad);
    }

    public boolean eliminarUsuario (Long id){
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
