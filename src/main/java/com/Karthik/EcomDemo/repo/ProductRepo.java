package com.Karthik.EcomDemo.repo;

import com.Karthik.EcomDemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {
}
