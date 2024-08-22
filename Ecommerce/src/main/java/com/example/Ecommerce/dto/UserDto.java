package com.example.Ecommerce.dto;


import com.example.Ecommerce.Enums.UserRole;
import lombok.Data;

@Data
public class UserDto {
    private int id;
    private String email;
    private String name;
    private UserRole role;

}
