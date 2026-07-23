package com.example.QuickServe.For.Restaurant.Repo;

import com.example.QuickServe.For.Restaurant.Entity.OrderReleted.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepo extends JpaRepository<OrderItem,Long> {

}
