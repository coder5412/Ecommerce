package com.example.Ecommerce.Entity;


import com.example.Ecommerce.dto.ProductDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    private String name;
    private double price;
    private String description;



    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Category category;
    public ProductDto getProductDto() {
        ProductDto productDto = new ProductDto();
        productDto.setId(id);
        productDto.setName(name);
        productDto.setDescription(description);
        productDto.setCategoryName(category.getName());
        productDto.setCategoryId(category.getId());
        return productDto;
    }


    public ProductDto getDto() {
        return null;
    }
}
