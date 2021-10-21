package com.sparta.km.northwindrest.controllers;

import com.sparta.km.northwindrest.entities.CustomerEntity;
import com.sparta.km.northwindrest.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers")
    @ResponseBody
    public List<CustomerEntity> getAllCustomers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String country) {
        if (name == null && country == null) {
            return customerRepository.findAll();
        }

        if (name == null && country != null) {
            return customerRepository.findAll()
                    .stream()
                    .filter(customerEntity -> customerEntity.getCountry().contains(country))
                    .collect(Collectors.toList());
        }

        if (name != null && country == null) {
            return customerRepository.findAll()
                    .stream()
                    .filter(customerEntity -> customerEntity.getContactName().contains(name))
                    .collect(Collectors.toList());
        }

        return customerRepository.findAll()
                .stream()
                .filter(customerEntity ->
                        customerEntity.getContactName().contains(name) &&
                        customerEntity.getCountry().contains(country))
                .collect(Collectors.toList());

//        List<CustomerEntity> foundCustomers = new ArrayList<>();
//        for (CustomerEntity customerEntity : customerRepository.findAll()) {
//            if (customerEntity.getContactName().contains(name)) {
//                foundCustomers.add(customerEntity);
//            }
//        }
//
//        return foundCustomers;
    }

}
