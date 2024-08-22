package com.example.Ecommerce.controller.admin;


import com.example.Ecommerce.Entity.Category;
import com.example.Ecommerce.dto.CategoryDto;
import com.example.Ecommerce.service.Admin.adminCategory.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminCategoryController {

    private final CategoryService categoryService;

    public AdminCategoryController(CategoryService categoryService) {

        this.categoryService = categoryService;
    }

@PostMapping("/category")
    public ResponseEntity<Category> addCategory(@RequestBody CategoryDto categoryDto) {

    Category category= categoryService.createcategory(categoryDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(category);
}






}
