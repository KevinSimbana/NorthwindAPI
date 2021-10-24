package com.sparta.km.northwindrest.repositories;

import com.sparta.km.northwindrest.entities.CustomerEntity;
import com.sparta.km.northwindrest.entities.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CustomerRepository extends JpaRepository<CustomerEntity, String>, JpaSpecificationExecutor<CustomerEntity> {
}