package com.example.QuickServe.For.Restaurant.Dto.Request;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {

    @NotBlank
    private String name;

    private Long price;

    private String imageUrl;

    private Boolean available = true;

    private Long categoryId;
}
