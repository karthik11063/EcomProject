package com.Karthik.EcomDemo.service;

import com.Karthik.EcomDemo.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    ResponseEntity<ProductDTO> addProduct(ProductDTO productDTO);

    List<ProductDTO> getAllProducts(int page, int size,String sortBy, String sortDir);

    ResponseEntity<ProductDTO> updateProduct(Long id, ProductDTO productDTO);

    ResponseEntity<String> deleteProduct(Long id);

    ResponseEntity<Page<ProductDTO>> getFilteredProducts(List<String> category, Long minPrice, Long maxPrice,int page,int size,String sortBy);
}
