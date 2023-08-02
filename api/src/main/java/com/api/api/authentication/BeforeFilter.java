package com.api.api.authentication;

import java.io.IOException;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.api.api.repository.user.UserInterface;
import com.api.api.service.TokenService;
import com.fasterxml.jackson.core.io.JsonEOFException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

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

        if (request.getHeader("Authorization") != null
                && request.getHeader("Authorization").replace("Bearer ", "") != null) {

            String userName = tokenService.verifyToken(request.getHeader("Authorization").replace("Bearer ", ""));
            UserDetails usuario = userInterface.findBylogin(userName);
            var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);

        }
        if (request.getHeader("Authorization") == null) {
            ResponseErrorDTO responseErrorDTO = new ResponseErrorDTO("401", "erro de autenticação");
            response.setContentType( "application/json");
            response.setCharacterEncoding("UTF-8");
            ObjectMapper objectMapper = new ObjectMapper();
            response.getWriter().print(objectMapper.writeValueAsString(responseErrorDTO));
            return;
        }
        filterChain.doFilter(request, response);

    }

}
