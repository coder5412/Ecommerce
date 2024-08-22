package com.example.Ecommerce.dto;


import lombok.*;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlaceOrderDto {

    private int userId;
    private String address;
    private String orderDescription;







}
