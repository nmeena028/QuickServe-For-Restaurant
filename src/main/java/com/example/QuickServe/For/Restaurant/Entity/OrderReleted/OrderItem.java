package com.example.QuickServe.For.Restaurant.Entity.OrderReleted;

import com.example.QuickServe.For.Restaurant.Entity.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;

    private Long priceAtOrder;

    //connect to the Orders (Many items in one Order)that's why we are used ManyToOne mapping in RestauranOrderItem
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    //connect to the Product (Many items in one Order)that's why we are used ManyToOne mapping in RestauranOrderItem
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;
}
