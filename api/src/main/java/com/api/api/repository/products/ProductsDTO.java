package com.api.api.repository.products;

import org.springframework.stereotype.Repository;

public record ProductsDTO(String name,Float price,Integer active) {
    
}
