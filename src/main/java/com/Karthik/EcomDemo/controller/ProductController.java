package com.Karthik.EcomDemo.controller;

import com.Karthik.EcomDemo.dto.ProductDTO;
import com.Karthik.EcomDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping("/products")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO){
        ResponseEntity<ProductDTO> response  = productService.addProduct(productDTO);
        return response; // Return the product details as a response
    }
    /**     * Endpoint to retrieve a paginated list of all products in the inventory.
     *
     * @param page The page number to retrieve (default is 0).
     * @param size The number of products per page (default is 10).
     * @return ResponseEntity containing a paginated list of product details.
     */
    @GetMapping("/products")
    public ResponseEntity<Page<ProductDTO>>getAllProducts(@RequestParam(name="page",defaultValue = "0") int page,
                                                          @RequestParam(name="size",defaultValue = "10") int size){
        ResponseEntity<Page<ProductDTO>>response = productService.getAllProducts(page,size);
        return response;
    }
    /**     * Endpoint to update the details of an existing product in the inventory.
     *
     * @param id The ID of the product to be updated.
     * @param productDTO The updated details of the product.
     * @return ResponseEntity containing the updated product details.
     */
    @PutMapping("/products/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        ResponseEntity<ProductDTO> response = productService.updateProduct(id, productDTO);
        return ResponseEntity.ok(productDTO); // Return the updated product details as a response
    }
    /**     * Endpoint to delete a product from the inventory.
     *
     * @param id The ID of the product to be deleted.
     * @return ResponseEntity containing a success message upon successful deletion.
     */
    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        ResponseEntity<String> response = productService.deleteProduct(id);
        return response;
    }
}