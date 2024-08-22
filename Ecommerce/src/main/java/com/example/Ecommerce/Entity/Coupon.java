package com.example.Ecommerce.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data

public class Coupon {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
        private String code;
        private String name;
        private int discount;
        private Date expirationDate;



}
