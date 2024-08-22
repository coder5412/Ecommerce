package com.example.Ecommerce.dto;

import com.example.Ecommerce.Entity.CartItems;
import com.example.Ecommerce.Entity.User;
import com.example.Ecommerce.Enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private int id;
    private String orderDescription;
    private Date date;
    private int amount;
    private OrderStatus status;
    private String address;
    private int totalamount;
    private int discount;
    private UUID trackingid;



    private String couponName;
    private String  UserName;

    private List<CartItemsDto> cartItems;

}
