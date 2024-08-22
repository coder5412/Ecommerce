package com.example.Ecommerce.service.Customer;

import com.example.Ecommerce.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerProductService {

    List<ProductDto> getAllProducts();
    public List<ProductDto>searchProductByTitle(String title);

}
