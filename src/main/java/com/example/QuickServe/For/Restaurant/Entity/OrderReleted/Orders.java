package com.example.QuickServe.For.Restaurant.Entity.OrderReleted;

import com.example.QuickServe.For.Restaurant.Entity.Enum.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@jakarta.persistence.Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;

    private String phoneNumber;

    private Long totalAmount;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private LocalDateTime createdAt;


    //connect to the Table (Many Order on one table) that's why we are used ManyToOne mapping by Orders
    @ManyToOne
    @JoinColumn(name = "table_id")
    private Table tableRestaurant;


    //connect to the OrderItem (one Order have many items) that's why we are used OneToMany mapping by Orders
    @OneToMany(mappedBy = "orderRestaurant",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<OrderItem> orderItems;
}