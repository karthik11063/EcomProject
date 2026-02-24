package com.Karthik.EcomDemo.service;

import com.Karthik.EcomDemo.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    ResponseEntity<ProductDTO> addProduct(ProductDTO productDTO);

    ResponseEntity<Page<ProductDTO>> getAllProducts(int page, int size);

    ResponseEntity<ProductDTO> updateProduct(Long id, ProductDTO productDTO);

    ResponseEntity<String> deleteProduct(Long id);
}
