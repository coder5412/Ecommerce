package com.example.Ecommerce.controller.Customer;


import com.example.Ecommerce.dto.ProductDto;
import com.example.Ecommerce.respository.ProductRespository;
import com.example.Ecommerce.service.Customer.CustomerProductService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Getter
@Setter
@RequestMapping("/api/customer")
public class CustomerProductController {


    private final CustomerProductService customerProductService;

    public CustomerProductController(CustomerProductService customerProductService) {
        this.customerProductService = customerProductService;
    }



    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProduct(){
        List<ProductDto> productDtos =customerProductService.getAllProducts();
        return ResponseEntity.ok(productDtos);

    }


    @GetMapping("/search/{name}")
    public ResponseEntity<List<ProductDto>> getAllProductByName(@PathVariable String name){
        List<ProductDto> productDtos =customerProductService.searchProductByTitle(name);
        return ResponseEntity.ok(productDtos);

    }





















}
