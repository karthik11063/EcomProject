package com.Karthik.EcomDemo.service;

import com.Karthik.EcomDemo.dto.OrderRequestDTO;
import com.Karthik.EcomDemo.dto.OrderResponseDTO;
import org.springframework.http.ResponseEntity;

public interface OrderService {
    ResponseEntity<?> placeOrder(OrderRequestDTO order);

    OrderResponseDTO getAllUserOrders(Long userId);
}
