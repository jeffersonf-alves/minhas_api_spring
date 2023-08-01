package com.example.carros.Api;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

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
