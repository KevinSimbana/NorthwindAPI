package com.sparta.km.northwindrest.controllers;

import com.sparta.km.northwindrest.controllers.customer.CustomerWithCity;
import com.sparta.km.northwindrest.controllers.customer.CustomerWithCountry;
import com.sparta.km.northwindrest.entities.CustomerEntity;
import com.sparta.km.northwindrest.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

//    @GetMapping
//    @ResponseBody
//    public List<CustomerEntity> getAllCustomers(
//            @RequestParam(required = false) String name,
//            @RequestParam(required = false) String country) {
//        if (name == null && country == null) {
//            return customerRepository.findAll();
//        }
//
//        if (name == null && country != null) {
//            return customerRepository.findAll()
//                    .stream()
//                    .filter(customerEntity -> customerEntity.getCountry().contains(country))
//                    .collect(Collectors.toList());
//        }
//
//        if (name != null && country == null) {
//            return customerRepository.findAll()
//                    .stream()
//                    .filter(customerEntity -> customerEntity.getContactName().contains(name))
//                    .collect(Collectors.toList());
//        }
//
//        return customerRepository.findAll()
//                .stream()
//                .filter(customerEntity ->
//                        customerEntity.getContactName().contains(name) &&
//                        customerEntity.getCountry().contains(country))
//                .collect(Collectors.toList());
//    }

    @GetMapping
    public List<CustomerEntity> findCustomers(@RequestParam(value = "city", required = false) String city,
                                              @RequestParam(value = "country", required = false) String country) {
        Specification<CustomerEntity> spec = Specification.where(new CustomerWithCity(city)
                .and(new CustomerWithCountry(country)));

        return customerRepository.findAll(spec);
    }

}
