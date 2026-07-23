package com.example.QuickServe.For.Restaurant.Dto.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {

    private Long id;

    private String name;

    private Long price;

    private String imageUrl;

    private Boolean available = true;

    private Long categoryId;

    private String categoryName;

}
