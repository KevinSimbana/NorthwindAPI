package com.sparta.km.northwindrest.controllers.supplier;

import com.sparta.km.northwindrest.entities.SupplierEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class SupplierWithContactTitle implements Specification<SupplierEntity> {

    private String contactTitle;

    public SupplierWithContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    @Override
    public Predicate toPredicate(Root<SupplierEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (contactTitle == null) {
            return criteriaBuilder.isTrue(criteriaBuilder.literal(true)); //always true = no filtering
        }

        return criteriaBuilder.like(root.get("contactTitle"), this.contactTitle);
    }
}
