package com.sparta.km.northwindrest.services;

import com.sparta.km.northwindrest.dto.ProductDTO;
import com.sparta.km.northwindrest.entities.ProductEntity;
import com.sparta.km.northwindrest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void setRepo(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> getCustomProducts(Specification<ProductEntity> spec) {
        return productRepository
                .findAll(spec)
                .stream()
                .map(this::convertToProdDTO)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getDiscontinued() {
        return productRepository
                .findAll()
                .stream()
                .filter(product -> product.getDiscontinued().equals(true))
                .map(this::convertToProdDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO convertToProdDTO(ProductEntity product) {
        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(product.getId());
        productDTO.setProductName(product.getProductName());
        productDTO.setQuantityPerUnit(product.getQuantityPerUnit());
        productDTO.setUnitPrice(product.getUnitPrice());
        productDTO.setUnitsInStock(product.getUnitsInStock());
        productDTO.setDiscontinued(product.getDiscontinued());

        return productDTO;
    }
}
