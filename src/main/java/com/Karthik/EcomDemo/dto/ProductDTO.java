package com.Karthik.EcomDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements Serializable {
    private String productName ;
    private int quantity;
    private String category;
    private Long price;
}
