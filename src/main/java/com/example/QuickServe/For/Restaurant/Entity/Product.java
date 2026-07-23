package com.example.QuickServe.For.Restaurant.Entity;

import com.example.QuickServe.For.Restaurant.Entity.OrderReleted.OrderItem;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    private Long price;

    private String imageUrl;

    private Boolean available = true;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItems;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

}
