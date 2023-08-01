package com.api.api.repository.products;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "products")
@Entity(name = "products")

public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    Float price;
    Integer active;
    public Products(String name, Float price, Integer active) {
        this.name = name;
        this.price = price;
        this.active = active;
    }
     public Products() {
       
    }
    
    

}
