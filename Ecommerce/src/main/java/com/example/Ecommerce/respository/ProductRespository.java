package com.example.Ecommerce.respository;


import com.example.Ecommerce.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRespository extends JpaRepository<Product, Integer> {

    List<Product> findAllByNameContaining(String title);


}
