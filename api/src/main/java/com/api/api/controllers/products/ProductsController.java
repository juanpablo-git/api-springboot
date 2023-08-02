package com.api.api.controllers.products;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import com.api.api.repository.products.Products;
import com.api.api.repository.products.ProductsDTO;
import com.api.api.repository.products.ProductsInterface;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping(value="/products",produces = "application/json")
public class ProductsController {
    @Autowired
    ProductsInterface productsInterface;

    @GetMapping()
    public List<Products> getMethodName() {
        List<Products> products = this.productsInterface.findAll().stream().map((i) -> {
            Products p = new Products(i.getName(),i.getPrice(),i.getActive()) ;
            return p;
        } ).toList();
        return products;
    }
    
    
    @PostMapping()
    public ResponseEntity postMethodName(@RequestBody ProductsDTO data) {
       Products products = new Products(data.name(), data.price(), 1);
        productsInterface.save(products);
        return ResponseEntity.ok().build();
    }

    
    @DeleteMapping()
    public ResponseEntity deleteMethodName(@RequestBody DeleteProductsDTO id) {
        productsInterface.deleteById(id.id());
        return ResponseEntity.ok().build();
    }
    
}
