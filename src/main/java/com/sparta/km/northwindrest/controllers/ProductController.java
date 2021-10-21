package com.sparta.km.northwindrest.controllers;

import com.sparta.km.northwindrest.entities.ProductEntity;
import com.sparta.km.northwindrest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Optional<ProductEntity> getProductById(@PathVariable Integer id) {
        return productRepository.findById(id);
    }
}
