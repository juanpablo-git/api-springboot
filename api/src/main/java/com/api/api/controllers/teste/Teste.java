package com.api.api.controllers.teste;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/teste")
public class Teste {
    @PostMapping
    public ResponseEntity postMethodName( ) {
        
        return ResponseEntity.ok().build();
    }
    
}
