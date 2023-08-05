package com.example.carros.domain;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repositorio;


    public Iterable<Usuario> getUserAll() {
        return repositorio.findAll();
    }
}
