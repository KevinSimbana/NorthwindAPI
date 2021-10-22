package com.sparta.km.northwindrest.controllers.supplier;

import com.sparta.km.northwindrest.entities.SupplierEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class SupplierWithCity implements Specification<SupplierEntity> {

    private String city;

    public SupplierWithCity(String city) {
        this.city = city;
    }

    @Override
    public Predicate toPredicate(Root<SupplierEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (city == null) {
            return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
        }

        return criteriaBuilder.equal(root.get("city"), this.city);
    }
}
