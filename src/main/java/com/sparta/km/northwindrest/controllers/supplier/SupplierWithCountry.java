package com.sparta.km.northwindrest.controllers.supplier;

import com.sparta.km.northwindrest.entities.SupplierEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class SupplierWithCountry implements Specification<SupplierEntity> {

    private String country;

    public SupplierWithCountry(String country) {
        this.country = country;
    }

    @Override
    public Predicate toPredicate(Root<SupplierEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (country == null) {
            return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
        }

        return criteriaBuilder.equal(root.get("country"), this.country);
    }
}
