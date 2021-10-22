package com.sparta.km.northwindrest.repositories;

import com.sparta.km.northwindrest.entities.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SupplierRepository extends JpaRepository<SupplierEntity, Integer> , JpaSpecificationExecutor<SupplierEntity> {
}