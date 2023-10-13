package com.jeffersonalves.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

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
            // VALIDAR USUÁRIO

                
            filterChain.doFilter(request, response);
        
    }

    
}