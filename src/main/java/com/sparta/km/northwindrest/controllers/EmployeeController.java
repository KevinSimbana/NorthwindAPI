package com.sparta.km.northwindrest.controllers;

import com.sparta.km.northwindrest.entities.EmployeeEntity;
import com.sparta.km.northwindrest.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees")
    @ResponseBody
    public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false) String name) {
        if (name == null) {
            return employeeRepository.findAll();
        }

        List<EmployeeEntity> foundEmployees = new ArrayList<>();
        for (EmployeeEntity employeeEntity : employeeRepository.findAll()) {
            if (employeeEntity.getFirstName().contains(name)) {
                foundEmployees.add(employeeEntity);
            }
        }

        return foundEmployees;
    }
}
