package com.example.QuickServe.For.Restaurant.Dto.RestaurantOrder;

import com.example.QuickServe.For.Restaurant.Dto.RestaurantOrderItem.OrderItemRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {

    private String customerName;

    private String phoneNumber;

    private Long tableId;

    private List<OrderItemRequestDto> items;
}
