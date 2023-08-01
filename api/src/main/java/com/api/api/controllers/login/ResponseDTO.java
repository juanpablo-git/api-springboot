package com.api.api.controllers.login;

import org.springframework.security.core.userdetails.UserDetails;

public record ResponseDTO(UserDetails login,String token) {
    
}
