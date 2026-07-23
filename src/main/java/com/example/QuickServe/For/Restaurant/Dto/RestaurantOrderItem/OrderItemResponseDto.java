package com.example.QuickServe.For.Restaurant.Dto.RestaurantOrderItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemResponseDto {

    private Long productId;

    private String productName;

    private Integer quantity;

    private Long priceAtOrder;

    private Long totalPrice;
}
