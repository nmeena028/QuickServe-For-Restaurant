package com.example.QuickServe.For.Restaurant.Service;

import com.example.QuickServe.For.Restaurant.Dto.Request.CategoryRequestDto;
import com.example.QuickServe.For.Restaurant.Dto.Response.CategoryResponseDto;
import com.example.QuickServe.For.Restaurant.Entity.Category;
import com.example.QuickServe.For.Restaurant.Repo.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.InterpreterRuleContext;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepo categoryRepo;

    public List<CategoryResponseDto> GetAllCategory() {
         List<Category> category= categoryRepo.findAll();

         return category.stream().map((Cl)->new CategoryResponseDto(Cl.getId(),Cl.getName())).toList();
    }

    public String AddCategory(CategoryRequestDto categoryRequestDto) {
        Category category=new Category();

        category.setName(categoryRequestDto.getName());
        category.setCreateIt(LocalDateTime.now());

        categoryRepo.save(category);

        return "Product Added";
    }

    public CategoryResponseDto GetByID(Long id) {
        Category category=categoryRepo.findById(id).orElseThrow(()->new RuntimeException("Given id is wrong"));

        return new CategoryResponseDto(category.getId(), category.getName());
    }

    public String updateCategory(Long id, CategoryRequestDto categoryRequestDto) {
        Category category = categoryRepo.findById(id).orElseThrow(()->new RuntimeException("Given id is Wrong"));

        category.setName(categoryRequestDto.getName());
        category.setUpdateIt(LocalDateTime.now());

        categoryRepo.save(category);
        return "category Updated";
    }

    public String deleteById(Long id) {
        Category category=categoryRepo.findById(id).orElseThrow();
        if (!category.getProducts().isEmpty()) {
            throw new RuntimeException(
                    "Cannot delete category because products exist.");
        }
        categoryRepo.delete(category);

        return "Category Deleted Successfully";
        }

    public CategoryResponseDto GetByName(String name) {
        Category category= categoryRepo.findByName(name);
        return new CategoryResponseDto(category.getId(),category.getName());
    }
}
