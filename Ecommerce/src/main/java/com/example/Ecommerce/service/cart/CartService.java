package com.example.Ecommerce.service.cart;

import com.example.Ecommerce.dto.AddProductInCartDto;
import com.example.Ecommerce.dto.OrderDto;
import com.example.Ecommerce.dto.PlaceOrderDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CartService {

    ResponseEntity<?> addProductInCart(AddProductInCartDto addProductInCartDto);
    OrderDto getCartByUserId(int userid);
    OrderDto applyCoupon(int userId, String code);

    OrderDto increaseProductQuantity(AddProductInCartDto addProductInCartDto);
    OrderDto decreaseProductQuantity(AddProductInCartDto addProductInCartDto);
    OrderDto placeOrder(PlaceOrderDto placeOrderDto);
    List<OrderDto> getMyPlaceOrders(int userId);

}
