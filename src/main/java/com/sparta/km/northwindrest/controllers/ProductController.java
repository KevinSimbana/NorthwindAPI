package com.sparta.km.northwindrest.controllers;

import com.sparta.km.northwindrest.dto.ProductDTO;
import com.sparta.km.northwindrest.entities.ProductEntity;
import com.sparta.km.northwindrest.repositories.ProductRepository;
import com.sparta.km.northwindrest.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductService productService;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
        productService = new ProductService();
        productService.setRepo(productRepository);
    }

    @GetMapping
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ProductEntity> getProductById(@PathVariable Integer id) {
        return productRepository.findById(id);
    }

    @GetMapping("/discontinued")
    public List<ProductDTO> getAllDiscontinuedProducts() {
        return productService.getDiscontinued();

    }
}
