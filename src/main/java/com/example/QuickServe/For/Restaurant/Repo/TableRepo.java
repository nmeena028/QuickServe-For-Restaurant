package com.example.QuickServe.For.Restaurant.Repo;

import com.example.QuickServe.For.Restaurant.Entity.OrderReleted.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepo extends JpaRepository<Table,Long> {

    Table findByTableNumber(String tableNumber);
}