package com.example.Ecommerce.controller.admin;

import com.example.Ecommerce.dto.ProductDto;
import com.example.Ecommerce.service.Admin.adminproduct.AdminProductService;
import io.jsonwebtoken.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/admin")
public class AdminProductController {


private final AdminProductService adminProductService;
    public AdminProductController(AdminProductService adminProductService) {
        this.adminProductService = adminProductService;
    }
    @PostMapping("/products")
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) throws IOException, java.io.IOException {
        ProductDto productDto1= adminProductService.addproduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDto1);
    }
    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProduct(){
    List<ProductDto> productDtos =adminProductService.getAllProducts();
    return ResponseEntity.ok(productDtos);

    }


    @GetMapping("/search/{name}")
    public ResponseEntity<List<ProductDto>> getAllProductByName(@PathVariable String name){
        List<ProductDto> productDtos =adminProductService.getAllProductsByName(name);
        return ResponseEntity.ok(productDtos);

    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<ProductDto> deleteProduct(@PathVariable int productId){
        boolean deleted = adminProductService.deleteProduct(productId);
        if(deleted){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/product/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable int productId){
        ProductDto productDto = adminProductService.getProductById(productId);
        if(productDto != null){
            return ResponseEntity.ok(productDto);

        }else {
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/product/{productId}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable int productId,@ModelAttribute ProductDto productDto){
        ProductDto updateProduct= adminProductService.updateProduct(productId,productDto);
        if(updateProduct != null){
            return ResponseEntity.ok(updateProduct);

        }else {
            return ResponseEntity.notFound().build();
        }

    }
    
}

