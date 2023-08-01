package com.api.api.repository.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsInterface extends JpaRepository<Products,Integer> {
    
}
