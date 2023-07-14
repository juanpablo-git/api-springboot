package com.api.authentication.comtroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.authentication.domain.LoginDTO;
import com.api.authentication.domain.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Auth
 */
@RestController
@RequestMapping("/auth")
public class Auth {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity getMethodLogin(@RequestParam LoginDTO loginDTO) {
        UserDetails userDetails = userRepository.findByLogin(loginDTO.login());
        
        return ResponseEntity.ok().build();
    }
    
    
}