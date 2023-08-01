package com.api.api.controllers.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.api.repository.user.UserInterface;
import com.api.api.service.TokenService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/login")
public class Login {
    @Autowired
    UserInterface user;
    @Autowired
    TokenService tokenService;

    @PostMapping
    public ResponseEntity postMethodName(@RequestBody LoginDTO data) {
        
        UserDetails login = this.user.findBylogin(data.user());
        String token = tokenService.createJWT(login);
        ResponseDTO res  = new ResponseDTO(login, token);
        return ResponseEntity.ok(res);
    }

    
}
