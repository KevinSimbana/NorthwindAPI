package com.sparta.km.northwindrest.repositories;

import com.sparta.km.northwindrest.entities.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<SupplierEntity, Integer> {
}