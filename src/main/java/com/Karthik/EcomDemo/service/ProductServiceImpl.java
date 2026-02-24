package com.Karthik.EcomDemo.service;

import com.Karthik.EcomDemo.dto.ProductDTO;
import com.Karthik.EcomDemo.mapper.ProductMapper;
import com.Karthik.EcomDemo.model.Product;
import com.Karthik.EcomDemo.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public ResponseEntity<Page<ProductDTO>> getAllProducts(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Product> products = productRepo.findAll(pageable);
        Page<ProductDTO> dtoPage = products.map(productMapper::toProductDTO);
        return ResponseEntity.ok(dtoPage);
    }

    @Override
    public ResponseEntity<ProductDTO> updateProduct(Long id, ProductDTO productDTO) {
        Product product = productMapper.toProduct(productDTO);
        Optional<Product> existingProduct = productRepo.findById(id);
        if (!existingProduct.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Product updatedProduct = existingProduct.get();
        updatedProduct.setProductName(product.getProductName());
        updatedProduct.setQuantity(product.getQuantity());
        productRepo.save(updatedProduct);
        return ResponseEntity.ok(productDTO);
    }

    @Override
    public ResponseEntity<String> deleteProduct(Long id) {
        Optional<Product> existingProduct = productRepo.findById(id);
        if (!existingProduct.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        productRepo.deleteById(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

}