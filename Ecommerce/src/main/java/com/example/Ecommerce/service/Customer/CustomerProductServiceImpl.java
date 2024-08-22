package com.example.Ecommerce.service.Customer;


import com.example.Ecommerce.Entity.Product;
import com.example.Ecommerce.dto.ProductDto;
import com.example.Ecommerce.respository.CategoryRespository;
import com.example.Ecommerce.respository.ProductRespository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class CustomerProductServiceImpl implements CustomerProductService {




private final ProductRespository productRespository;

    public CustomerProductServiceImpl(ProductRespository productRespository) {
        this.productRespository = productRespository;
      }




    public List<ProductDto> getAllProducts() {
        List<Product> products = productRespository.findAll();
        return products.stream().map(Product::getDto).collect(Collectors.toList());
    }


    public List<ProductDto> searchProductByTitle(String title) {
        List<Product> products = productRespository.findAllByNameContaining(title);
        return products.stream().map(Product::getDto).collect(Collectors.toList());
    }













}
