package com.Karthik.EcomDemo.repo;

import com.Karthik.EcomDemo.model.Order;
import com.Karthik.EcomDemo.model.OrderItem;
import com.Karthik.EcomDemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {
    @Query("SELECT o.orderItems from Order o where o.user = :findUser")
    List<OrderItem> findByUser(User findUser);
}
