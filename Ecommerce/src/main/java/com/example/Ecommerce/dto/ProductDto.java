package com.example.Ecommerce.dto;


import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private int id;
    private String name;
    private String description;
    private int price;
    private int categoryId;
    private String categoryName;
}
