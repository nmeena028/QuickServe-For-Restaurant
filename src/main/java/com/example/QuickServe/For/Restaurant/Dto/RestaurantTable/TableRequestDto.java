package com.example.QuickServe.For.Restaurant.Dto.RestaurantTable;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableRequestDto {

    @NotBlank
    private String tableNumber;

    private Boolean active;
}
