package com.example.QuickServe.For.Restaurant.Controller;

import com.example.QuickServe.For.Restaurant.Dto.Request.ProductRequestDto;
import com.example.QuickServe.For.Restaurant.Dto.Response.CategoryResponseDto;
import com.example.QuickServe.For.Restaurant.Dto.Response.ProductResponseDto;
import com.example.QuickServe.For.Restaurant.Entity.Product;
import com.example.QuickServe.For.Restaurant.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public ResponseEntity<List<ProductResponseDto>> GetAllProduct(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.GetAllProduct());
    }

    @PostMapping()
    public ResponseEntity<String> AddProduct(@RequestBody ProductRequestDto productRequestDto){
        return ResponseEntity.status(HttpStatus.OK).body(productService.AddProduct(productRequestDto));
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductResponseDto> GetById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.GetByID(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<String> UpdateProductById(@PathVariable Long id, @RequestBody ProductRequestDto productRequestDto){
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(id,productRequestDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> DeleteById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.deleteById(id));
    }

    @GetMapping("{name}")
    public ResponseEntity<ProductResponseDto> GetById(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK).body(productService.GetByName(name));
    }
}
