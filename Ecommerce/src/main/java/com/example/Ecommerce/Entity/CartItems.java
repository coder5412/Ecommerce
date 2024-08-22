package com.example.Ecommerce.Entity;


import com.example.Ecommerce.dto.CartItemsDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
@Getter
@Setter
public class CartItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private int quantity;
    private double price;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "user_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "product_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Product product;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

  public CartItemsDto getCartItemsDto() {
      CartItemsDto cartItemsDto = new CartItemsDto();
      cartItemsDto.setId(id);
      cartItemsDto.setQuantity(quantity);
      cartItemsDto.setPrice(price);
      cartItemsDto.setProduct_id(product.getId());
      cartItemsDto.setProduct_name(product.getName());
      cartItemsDto.setId(user.getId());
      return cartItemsDto;


      
  }
}
