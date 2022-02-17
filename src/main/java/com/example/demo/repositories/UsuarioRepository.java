package com.example.demo.repositories;

import com.example.demo.models.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UsuarioRepository extends CrudRepository<UserModel, Long> {
    public abstract ArrayList<UserModel> findByPrioridad(Integer prioridad);
}
