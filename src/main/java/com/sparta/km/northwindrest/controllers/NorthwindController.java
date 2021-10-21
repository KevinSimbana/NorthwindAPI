package com.sparta.km.northwindrest.controllers;

import com.sparta.km.northwindrest.entities.CustomerEntity;
import com.sparta.km.northwindrest.entities.ProductEntity;
import com.sparta.km.northwindrest.repositories.CustomerRepository;
import com.sparta.km.northwindrest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class NorthwindController {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    @Autowired
    public NorthwindController(CustomerRepository customerRepository, ProductRepository productRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/customers")
    @ResponseBody
    public List<CustomerEntity> getAllCustomers(@RequestParam(required = false) String name) {
        if (name == null) {
            return customerRepository.findAll();
        }

        List<CustomerEntity> foundCustomers = new ArrayList<>();

        for (CustomerEntity customerEntity : customerRepository.findAll()) {
            if (customerEntity.getContactName().contains(name)) {
                foundCustomers.add(customerEntity);
            }
        }

        return foundCustomers;
    }

    @GetMapping("/products")
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Optional<ProductEntity> getProductsById(@PathVariable Integer id) {
        return productRepository.findById(id);
    }
}
