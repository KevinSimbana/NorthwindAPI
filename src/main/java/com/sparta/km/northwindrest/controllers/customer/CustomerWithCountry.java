package com.sparta.km.northwindrest.controllers.customer;

import com.sparta.km.northwindrest.entities.CustomerEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CustomerWithCountry implements Specification<CustomerEntity> {

    private String country;

    public CustomerWithCountry(String country) {
        this.country = country;
    }

    @Override
    public Predicate toPredicate(Root<CustomerEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (country == null) {
            return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
        }

        return criteriaBuilder.equal(root.get("country"), this.country);
    }
}
