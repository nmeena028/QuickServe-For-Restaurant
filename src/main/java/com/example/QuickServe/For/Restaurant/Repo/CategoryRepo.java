package com.example.QuickServe.For.Restaurant.Repo;

import com.example.QuickServe.For.Restaurant.Dto.Response.CategoryResponseDto;
import com.example.QuickServe.For.Restaurant.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {

    Category findByName(String name);
}
