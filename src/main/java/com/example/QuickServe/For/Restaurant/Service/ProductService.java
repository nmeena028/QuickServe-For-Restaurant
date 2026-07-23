package com.example.QuickServe.For.Restaurant.Service;

import com.example.QuickServe.For.Restaurant.Dto.ProductDto.ProductRequestDto;
import com.example.QuickServe.For.Restaurant.Dto.ProductDto.ProductResponseDto;
import com.example.QuickServe.For.Restaurant.Entity.Category;
import com.example.QuickServe.For.Restaurant.Entity.Product;
import com.example.QuickServe.For.Restaurant.Repo.CategoryRepo;
import com.example.QuickServe.For.Restaurant.Repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;

    private final CategoryRepo categoryRepo;

    public List<ProductResponseDto> GetAllProduct() {

        List<Product> product=productRepo.findAll();

        return product.stream().map((PD)->new ProductResponseDto(
                PD.getId(),
                PD.getName(),
                PD.getPrice(),
                PD.getImageUrl(),
                PD.getAvailable(),
                PD.getCategory().getId(),
                PD.getCategory().getName())).toList();
    }

    public String AddProduct(ProductRequestDto productRequestDto) {

        Product product=new Product();

        Category category = categoryRepo.findById(productRequestDto.getCategoryId()).
                orElseThrow(()->new RuntimeException("Category id is Wrong"));

        product.setName(productRequestDto.getName());
        product.setPrice(productRequestDto.getPrice());
        product.setImageUrl(productRequestDto.getImageUrl());
        product.setAvailable(productRequestDto.getAvailable());
        product.setCategory(category);
        product.setCreateAt(LocalDateTime.now());

        productRepo.save(product);

        return "Product Added Successfully";
    }

    public ProductResponseDto GetByID(Long id) {

        Product product= productRepo.findById(id).orElseThrow(()->new RuntimeException("Given id is wrong"));

        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getImageUrl(),
                product.getAvailable(),
                product.getCategory().getId(),
                product.getCategory().getName());
    }

    public String updateProduct(Long id, ProductRequestDto productRequestDto) {

        Product product=productRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Product Id is Wrong"));

        Category category=categoryRepo.findById(productRequestDto.getCategoryId())
                .orElseThrow(()->new RuntimeException("Category Id is Wrong"));

        product.setName(productRequestDto.getName());
        product.setPrice(productRequestDto.getPrice());
        product.setImageUrl(productRequestDto.getImageUrl());
        product.setAvailable(productRequestDto.getAvailable());
        product.setCategory(category);
        product.setUpdateAt(LocalDateTime.now());

        productRepo.save(product);

        return "Product updated";
    }

    public String deleteById(Long id) {

        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        productRepo.delete(product);

        return "Product deleted successfully";
    }

    public ProductResponseDto GetByName(String name) {
        Product product=productRepo.findByName(name).orElseThrow(()->new RuntimeException("Product Id is Wrong"));
        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getImageUrl(),
                product.getAvailable(),
                product.getCategory().getId(),
                product.getCategory().getName()
        );
    }
}
