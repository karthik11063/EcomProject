package com.Karthik.EcomDemo.dto;

import com.Karthik.EcomDemo.model.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDTO {
    private Long totalAmount;
    private List<OrderItem> orderItems;
}
