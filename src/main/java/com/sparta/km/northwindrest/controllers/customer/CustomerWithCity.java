package com.sparta.km.northwindrest.controllers.customer;

import com.sparta.km.northwindrest.entities.CustomerEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CustomerWithCity implements Specification<CustomerEntity> {

    private String city;

    public CustomerWithCity(String city) {
        this.city = city;
    }

    @Override
    public Predicate toPredicate(Root<CustomerEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (city == null) {
            return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
        }

        return criteriaBuilder.equal(root.get("city"), this.city);
    }
}
