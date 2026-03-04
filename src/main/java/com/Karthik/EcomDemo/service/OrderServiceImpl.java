package com.Karthik.EcomDemo.service;

import com.Karthik.EcomDemo.dto.OrderRequestDTO;
import com.Karthik.EcomDemo.dto.OrderResponseDTO;
import com.Karthik.EcomDemo.model.Order;
import com.Karthik.EcomDemo.model.OrderItem;
import com.Karthik.EcomDemo.model.Product;
import com.Karthik.EcomDemo.model.User;
import com.Karthik.EcomDemo.repo.OrderRepo;
import com.Karthik.EcomDemo.repo.ProductRepo;
import com.Karthik.EcomDemo.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ProductRepo productRepo;

    @Override
    @Transactional
    public ResponseEntity<?> placeOrder(OrderRequestDTO order) {

        User findUser = userRepo.findById(order.getUser().getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Order newOrder = new Order();
        newOrder.setUser(findUser);

        List<OrderItem> orderItems = new ArrayList<>();

        order.getOrderItems().forEach(item -> {

            Product findProduct = productRepo.findById(item.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            if (item.getQuantity() > findProduct.getQuantity()) {
                throw new RuntimeException("Insufficient stock for product: " + findProduct.getProductName());
            }

            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(findProduct);
            orderItem.setQuantity(item.getQuantity());
            orderItem.setPurchasePrice(findProduct.getPrice() * item.getQuantity());
            orderItem.setOrder(newOrder);

            findProduct.setQuantity(findProduct.getQuantity() - item.getQuantity());

            orderItems.add(orderItem);
        });

        newOrder.setOrderItems(orderItems);

        long totalAmount = orderItems.stream()
                .mapToLong(OrderItem::getPurchasePrice)
                .sum();

        newOrder.setTotalAmount(totalAmount);
        try {
            orderRepo.save(newOrder);
        }
        catch (ObjectOptimisticLockingFailureException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Stock changed while placing order. Please try again.");
        }

        return ResponseEntity.ok("Order placed successfully");
    }

    @Override
    public OrderResponseDTO getAllUserOrders(Long userId) {
        User findUser = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<OrderItem> orders = orderRepo.findByUser(findUser);

        long totalAmount = 0;

        for (OrderItem order : orders) {
            totalAmount += order.getPurchasePrice();
        }

        return new OrderResponseDTO(totalAmount, orders);
    }
}
