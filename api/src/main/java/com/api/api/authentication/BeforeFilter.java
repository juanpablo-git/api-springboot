package com.api.api.authentication;

import java.io.IOException;

import org.antlr.v4.runtime.atn.SemanticContext.OR;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class BeforeFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                if(request.getHeader("Authorization") == null || request.getHeader("Authorization").isEmpty() ){

                    System.out.println("teste");
                    response.getWriter().write("Teste");
                }
                    filterChain.doFilter(request, response);
                    
                
    }

}
