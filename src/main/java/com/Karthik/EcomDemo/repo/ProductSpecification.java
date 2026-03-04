package com.Karthik.EcomDemo.repo;

import com.Karthik.EcomDemo.model.Product;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class ProductSpecification {
    public static Specification<Product> hasCategory(List<String> categories) {
        return (root, query, cb) ->
                root.get("category").in(categories);
    }
    public static Specification<Product> priceGreaterThanOrEqual(Long minPrice) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<Product> priceLessThanOrEqual(Long maxPrice) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
    }
}
