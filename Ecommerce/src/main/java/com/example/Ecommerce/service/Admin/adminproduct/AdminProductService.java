package com.example.Ecommerce.service.Admin.adminproduct;

import com.example.Ecommerce.dto.ProductDto;

import java.io.IOException;
import java.util.List;

public interface AdminProductService {


    ProductDto addproduct(ProductDto productDto) throws IOException;
    List<ProductDto> getAllProducts();
    public List<ProductDto> getAllProductsByName(String name);
    Boolean deleteProduct(Integer id);
    ProductDto getProductById(Integer productid);
    ProductDto updateProduct(Integer id, ProductDto productDto);
}
