package com.example.Ecommerce.service.Admin.adminCategory;

import com.example.Ecommerce.Entity.Category;
import com.example.Ecommerce.dto.CategoryDto;
import com.example.Ecommerce.respository.CategoryRespository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImp implements CategoryService {

   private final CategoryRespository categoryRespository;


    @Override
    public Category createcategory(CategoryDto categoryDto) {
        Category category=new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        return categoryRespository.save(category);
    }
}
