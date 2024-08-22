package com.example.Ecommerce.dto;


import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CartItemsDto {
    private int id;
    private int quantity;
    private double price;
    private int product_id;
    private int order_id;
    private String product_name;
























}
