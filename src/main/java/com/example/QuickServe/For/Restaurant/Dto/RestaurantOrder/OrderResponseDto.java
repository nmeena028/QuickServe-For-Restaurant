package com.example.QuickServe.For.Restaurant.Dto.RestaurantOrder;


import com.example.QuickServe.For.Restaurant.Dto.RestaurantOrderItem.OrderItemResponseDto;
import com.example.QuickServe.For.Restaurant.Entity.Enum.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {

    private Long id;

    private String customerName;

    private String phoneNumber;

    private String tableNumber;

    private OrderStatus status;

    private Long totalAmount;

    private List<OrderItemResponseDto> items;
}
