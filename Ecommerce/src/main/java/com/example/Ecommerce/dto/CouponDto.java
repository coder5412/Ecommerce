package com.example.Ecommerce.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CouponDto {

    private int id;
    private String code;
    private String name;
    private String discount;
    private Date expirationDate;


}
