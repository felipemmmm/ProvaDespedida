package com.example.ProvaProfessor.controller;

import com.example.ProvaProfessor.entity.Usuario;
import com.example.ProvaProfessor.service.UsuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cadastro")
public class UsuController {

    @Autowired
    private UsuService usuService;

    //1. Buscar todos
    @GetMapping
    public List<Usuario> getAll(){
        return usuService.getAllUsers();
    }

}
