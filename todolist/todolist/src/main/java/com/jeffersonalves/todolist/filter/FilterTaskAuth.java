package com.jeffersonalves.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.jeffersonalves.todolist.user.IUserRepository;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    @Autowired
    private IUserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

            // PEGAR A AUTENTICAÇÂO (Usuario e senha)
            var authorization = request.getHeader("Authorization");

            var authEncode = authorization.substring("Basic".length()).trim();

            byte[] authDecode = Base64.getDecoder().decode(authEncode);

            var authString = new String(authDecode);

            System.out.println("Authorization");
            System.out.println(authString);

            String[] credentials = authString.split(":");
            String username = credentials[0];
            String password = credentials[1];

            // VALIDAR USUÁRIO
            var user = this.userRepository.findByUsername(username);
            if(user == null) {
                response.sendError(401);
            } else {
                // VALIDAR SENHA
                var passwordVarify = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
                if(passwordVarify.verified) {
                    filterChain.doFilter(request, response);
                } else {
                    response.sendError(401);
                }
                

                
            }

        
    }

    
}
