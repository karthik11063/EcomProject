package com.Karthik.EcomDemo.repo;

import com.Karthik.EcomDemo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Long>, JpaSpecificationExecutor<Product> {

    @Query("SELECT p from Product p " +
            "WHERE (:category IS NULL OR p.category IN :category) " +
            "AND (:minPrice IS NULL OR p.price >= :minPrice) " +
            "AND (:maxPrice IS NULL OR p.price <= :maxPrice)")
    Page<Product> getFilteredData(List<String> category, Long minPrice, Long maxPrice, Pageable pageable);
}
