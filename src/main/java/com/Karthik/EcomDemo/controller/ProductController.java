package com.Karthik.EcomDemo.controller;

import com.Karthik.EcomDemo.dto.ProductDTO;
import com.Karthik.EcomDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    /**     * Endpoint to add a new product to the inventory.
     *
     * @param productDTO The details of the product to be added.
     * @return ResponseEntity containing the added product details.
     */
    @PostMapping("/addProduct")
    public ResponseEntity<ProductDTO> addProduct(ProductDTO productDTO){
        ResponseEntity<ProductDTO> response  = productService.addProduct(productDTO);
        return response; // Return the product details as a response
    }

}
