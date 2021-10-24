package com.sparta.km.northwindrest.services;

import com.sparta.km.northwindrest.dto.SupplierDTO;
import com.sparta.km.northwindrest.entities.SupplierEntity;
import com.sparta.km.northwindrest.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;


    public void setRepo(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<SupplierDTO> getCustomSuppliers(Specification<SupplierEntity> spec) {
        return supplierRepository
                .findAll(spec)
                .stream()
                .map(this::convertToSupDTO)
                .collect(Collectors.toList());
    }

    private SupplierDTO convertToSupDTO(SupplierEntity supplier) {
        SupplierDTO supplierDTO = new SupplierDTO();

        supplierDTO.setCompanyName(supplier.getCompanyName());
        supplierDTO.setContactName(supplier.getContactName());
        supplierDTO.setContactTitle(supplier.getContactTitle());
        supplierDTO.setAddress(supplier.getAddress());
        supplierDTO.setPhone(supplier.getPhone());

        return supplierDTO;
    }
}
