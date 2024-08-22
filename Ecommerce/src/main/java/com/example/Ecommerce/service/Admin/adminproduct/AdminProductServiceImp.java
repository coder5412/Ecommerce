package com.example.Ecommerce.service.Admin.adminproduct;

import com.example.Ecommerce.Entity.Category;
import com.example.Ecommerce.Entity.Product;
import com.example.Ecommerce.dto.ProductDto;
import com.example.Ecommerce.respository.CategoryRespository;
import com.example.Ecommerce.respository.ProductRespository;
import io.jsonwebtoken.io.IOException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminProductServiceImp implements AdminProductService{


    private final ProductRespository productRepository;
    private final CategoryRespository categoryRepository;

    public AdminProductServiceImp(ProductRespository productRepository, CategoryRespository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    public ProductDto addproduct(ProductDto productDto) throws IOException {
        Product product = new Product();
    product.setName(productDto.getName());
    product.setDescription(productDto.getDescription());
    product.setPrice(productDto.getPrice());

    Category category = categoryRepository.findById(productDto.getCategoryId()).orElse(null);
    product.setCategory(category);


        return productRepository.save(product).getDto();
    }
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(Product::getDto).collect(Collectors.toList());
    }

    public List<ProductDto> getAllProductsByName(String name) {
        List<Product> products = productRepository.findAllByNameContaining(name);
        return products.stream().map(Product::getDto).collect(Collectors.toList());
    }
    public Boolean deleteProduct(Integer id) {
        Optional<Product> optionalProduct= productRepository.findById(id);
        if(optionalProduct.isPresent()){
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public ProductDto getProductById(Integer productid) {
        Optional<Product> optionalProduct = productRepository.findById(productid);
        if(optionalProduct.isPresent()){
            return optionalProduct.get().getDto();
        }else {
            return null;
        }

    }
    public ProductDto updateProduct(Integer id, ProductDto productDto) {
        Optional<Product> optionalProduct = productRepository.findById(productDto.getId());
        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategoryId());
        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            product.setName(productDto.getName());
            product.setDescription(productDto.getDescription());
            product.setPrice(productDto.getPrice());
            Category category = categoryRepository.findById(productDto.getCategoryId()).orElse(null);
            product.setCategory(category);
            return productRepository.save(product).getDto();
        }
        else {
            return null;
        }
    }
}
