package com.Karthik.EcomDemo.dto;

import com.Karthik.EcomDemo.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDTO {
    private User user;
    private List<OrderItemRequestDTO> orderItems;
}
