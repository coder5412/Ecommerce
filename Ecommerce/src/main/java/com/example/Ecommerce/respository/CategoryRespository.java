package com.example.Ecommerce.respository;

import com.example.Ecommerce.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRespository extends JpaRepository<Category, Integer> {
}
