package com.example.QuickServe.For.Restaurant.Dto.RestaurantTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableResponseDto {

    private Long id;

    private String tableNumber;

    private Boolean active=true;
}
