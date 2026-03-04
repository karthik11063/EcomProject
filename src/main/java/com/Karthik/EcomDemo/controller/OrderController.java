package com.Karthik.EcomDemo.controller;

import com.Karthik.EcomDemo.dto.OrderRequestDTO;
import com.Karthik.EcomDemo.dto.OrderResponseDTO;
import com.Karthik.EcomDemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/orders")
   public ResponseEntity<?> placeOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        ResponseEntity<?> response = orderService.placeOrder(orderRequestDTO);
        return response;
    }
    @GetMapping("/orders/{userId}")
    public ResponseEntity<OrderResponseDTO> getAllUserOrders(@PathVariable Long userId) {
        OrderResponseDTO orderResponseDTO = orderService.getAllUserOrders(userId);
        return ResponseEntity.ok(orderResponseDTO);
    }

}
