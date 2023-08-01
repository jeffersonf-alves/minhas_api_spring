package com.example.carros.Api;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping()
    public String get() { return "API dos carros!"; }
    @GetMapping("/login")
    public String login(@RequestParam("login") String login, @RequestParam("senha") String senha) {
            return "Login efetuado!" +"Login: "+ login+" Senha: "+senha;
    }
    @GetMapping("/user/{id}")
    public String getId(@PathVariable("id") String id) {
        return "Id do usuário: " + id;
    }

    @PostMapping("/user")
    public String setUser(@RequestParam("email") String email, @RequestParam("senha") String senha) {
        return "E-mail do usuário: "+email+" Senha: "+senha;
    }
}
