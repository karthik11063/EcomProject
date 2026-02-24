package com.Karthik.EcomDemo.service;

import com.Karthik.EcomDemo.dto.ProductDTO;
import com.Karthik.EcomDemo.mapper.ProductMapper;
import com.Karthik.EcomDemo.model.Product;
import com.Karthik.EcomDemo.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductRepo productRepo;
    @Override
    public ResponseEntity<ProductDTO> addProduct(ProductDTO productDTO) {
        Product product = productMapper.toProduct(productDTO);
        productRepo.save(product);
        return ResponseEntity.ok(productDTO);
    }
}
