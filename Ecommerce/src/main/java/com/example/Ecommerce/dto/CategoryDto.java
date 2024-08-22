package com.example.Ecommerce.dto;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CategoryDto {

    private int id;
    private String name;
    private String description;

}
