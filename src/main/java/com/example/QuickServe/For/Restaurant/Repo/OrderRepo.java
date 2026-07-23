package com.example.QuickServe.For.Restaurant.Repo;

import com.example.QuickServe.For.Restaurant.Entity.OrderReleted.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Orders,Long> {
}
