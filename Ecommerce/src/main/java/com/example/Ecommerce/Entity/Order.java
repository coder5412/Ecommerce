package com.example.Ecommerce.Entity;


import com.example.Ecommerce.Enums.OrderStatus;
import com.example.Ecommerce.dto.OrderDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Getter
@Setter
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String orderDescription;
    private Date date;
    private int amount;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private String address;
    private int totalamount;
    private int discount;
    private UUID trackingid;



    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "order")
    private List<CartItems> cartItems;


    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="coupon_id", referencedColumnName = "id")
    private Coupon coupon;


    public OrderDto getOrderDto(){
        OrderDto orderDto = new OrderDto();
        orderDto.setId(id);
        orderDto.setOrderDescription(orderDescription);
        orderDto.setDate(date);
        orderDto.setAmount(amount);
        orderDto.setStatus(status);
        orderDto.setAddress(address);
        orderDto.setTrackingid(trackingid);
        orderDto.setUserName(user.getUsername());
        if(coupon != null){
            orderDto.setCouponName(coupon.getName());

        }
        return orderDto;
    }







}
