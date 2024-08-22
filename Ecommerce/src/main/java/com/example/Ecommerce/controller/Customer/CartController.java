package com.example.Ecommerce.controller.Customer;

import com.example.Ecommerce.dto.AddProductInCartDto;
import com.example.Ecommerce.dto.OrderDto;
import com.example.Ecommerce.dto.PlaceOrderDto;
import com.example.Ecommerce.exceptions.ValidationException;
import com.example.Ecommerce.service.cart.CartService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CartController {

   private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/cart")
    public ResponseEntity<?>addProductToCart(@RequestBody AddProductInCartDto addProductInCartDto) {
            return cartService.addProductInCart(addProductInCartDto);
        }
    @PostMapping("/cart/{userId}")
    public ResponseEntity<?>getCartByUserId(@PathVariable int userId) {
        OrderDto orderDto = cartService.getCartByUserId(userId);
            return ResponseEntity.status(HttpStatus.OK).body(orderDto);
    }

    public ResponseEntity<?> applyCoupon(@PathVariable int userId,@PathVariable String code) {
       try {
           OrderDto orderDto = cartService.applyCoupon(userId,code);
           return ResponseEntity.ok(orderDto);

       }catch (ValidationException ex){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex);
       }
    }
    @PostMapping("/addition")
    public ResponseEntity<OrderDto>increaseProductQuantity(@RequestBody AddProductInCartDto addProductInCartDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cartService.increaseProductQuantity(addProductInCartDto));
    }


    @PostMapping("/deletion")
    public ResponseEntity<OrderDto>decreaseProductQuantity(@RequestBody AddProductInCartDto addProductInCartDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cartService.decreaseProductQuantity(addProductInCartDto));
    }

    @PostMapping("/placeorder")
    public ResponseEntity<OrderDto>placeOrder(@RequestBody PlaceOrderDto placeOrderDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cartService.placeOrder(placeOrderDto));
    }
    public ResponseEntity<List<OrderDto>> getMyPlacedOrder(@PathVariable int userId){
        return ResponseEntity.ok(cartService.getMyPlaceOrders(userId));
    }
}
