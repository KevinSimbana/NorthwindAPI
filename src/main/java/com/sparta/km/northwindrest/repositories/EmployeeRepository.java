package com.sparta.km.northwindrest.repositories;

import com.sparta.km.northwindrest.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
}