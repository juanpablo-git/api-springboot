package com.api.api.authentication;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.api.api.repository.UserInterface;
import com.api.api.service.TokenService;
import com.auth0.jwt.interfaces.Claim;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class BeforeFilter extends OncePerRequestFilter {
    @Autowired
    TokenService tokenService;

    @Autowired
    UserInterface userInterface;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        if (request.getHeader("Authorization") != null && request.getHeader("Authorization").replace("Bearer ", "") != null) {
                        System.out.println("Chegou aqui");

           
            Claim signin = tokenService.verifyToken(request.getHeader("Authorization").replace("Bearer ", ""));
            UserDetails usuario = userInterface.findBylogin(signin.toString());
            System.out.println(usuario);
            
            // var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
            // SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);

    }

}
