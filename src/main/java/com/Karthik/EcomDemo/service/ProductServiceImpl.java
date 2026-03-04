package com.Karthik.EcomDemo.service;

import com.Karthik.EcomDemo.dto.ProductDTO;
import com.Karthik.EcomDemo.mapper.ProductMapper;
import com.Karthik.EcomDemo.model.Product;
import com.Karthik.EcomDemo.repo.ProductRepo;
import com.Karthik.EcomDemo.repo.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public ResponseEntity<Page<ProductDTO>> getAllProducts(int page, int size,String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size,sort);
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
        updatedProduct.setCategory(product.getCategory());
        updatedProduct.setPrice(product.getPrice());
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

    @Override
    public ResponseEntity<Page<ProductDTO>> getFilteredProducts(List<String> category, Long minPrice, Long maxPrice,int page,int size,String sortBy) {
        Sort sort = Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);

        Specification<Product> spec = (root, query, cb) -> cb.conjunction();

        if (category != null && !category.isEmpty()) {
            spec = spec.and(ProductSpecification.hasCategory(category));
        }

        if (minPrice != null) {
            spec = spec.and(ProductSpecification.priceGreaterThanOrEqual(minPrice));
        }

        if (maxPrice != null) {
            spec = spec.and(ProductSpecification.priceLessThanOrEqual(maxPrice));
        }

        Page<Product> products = productRepo.findAll(spec, pageable);

        Page<ProductDTO> dtoPage = products.map(productMapper::toProductDTO);

        return ResponseEntity.ok(dtoPage);

    }

}