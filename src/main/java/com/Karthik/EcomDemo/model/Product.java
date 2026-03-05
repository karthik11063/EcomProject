package com.Karthik.EcomDemo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name="products")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private String category;
    private Long price;
    private int quantity;
    @Version
    private Long version;
}