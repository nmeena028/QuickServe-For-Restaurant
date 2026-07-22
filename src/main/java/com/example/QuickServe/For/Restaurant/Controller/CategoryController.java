package com.example.QuickServe.For.Restaurant.Controller;

import com.example.QuickServe.For.Restaurant.Dto.Request.CategoryRequestDto;
import com.example.QuickServe.For.Restaurant.Dto.Response.CategoryResponseDto;
import com.example.QuickServe.For.Restaurant.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("category")
public class CategoryController {

    private final CategoryService categoryService;



    @GetMapping()
    public ResponseEntity<List<CategoryResponseDto>> GetAllCategory(){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.GetAllCategory());
    }

    @PostMapping()
    public ResponseEntity<String> AddCategory(@RequestBody CategoryRequestDto categoryRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.AddCategory(categoryRequestDto));
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryResponseDto> GetById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.GetByID(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<String> UpdateCategoryById(@PathVariable Long id, @RequestBody CategoryRequestDto categoryRequestDto){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.updateCategory(id,categoryRequestDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> DeleteById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.deleteById(id));
    }

    @GetMapping("{name}")
    public ResponseEntity<CategoryResponseDto> GetById(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.GetByName(name));
    }
}
