package com.api.api.repository.products;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsInterface extends JpaRepository<Products,Integer> {
    Optional<Products> findByid(Integer id);
}
