package com.example.carros.Api;
import com.example.carros.domain.UserService;
import com.example.carros.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public Iterable<Usuario> get() {
        return service.getUserAll();
    }



    @GetMapping("/todos")
    public String getUser() {
        return "Todos os Usuários";
    }
    int qtdInicio = 10;
    @GetMapping("/quantidade")
    public int qtdUsuario() {
        return qtdInicio;
    }

    @PostMapping("/somando")
    public int somando(@RequestParam int soma) {
        return soma + qtdInicio;
    }

}
