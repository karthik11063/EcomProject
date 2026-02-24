package com.Karthik.EcomDemo.mapper;

import com.Karthik.EcomDemo.dto.ProductDTO;
import com.Karthik.EcomDemo.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(ProductDTO productDTO);
}
