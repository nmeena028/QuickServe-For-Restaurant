package com.example.QuickServe.For.Restaurant.Dto.RestaurantOrderItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemRequestDto {

    private Long productId;

    private Integer quantity;
}
