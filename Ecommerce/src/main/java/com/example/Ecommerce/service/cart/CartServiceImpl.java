package com.example.Ecommerce.service.cart;


import com.example.Ecommerce.Entity.*;
import com.example.Ecommerce.Enums.OrderStatus;
import com.example.Ecommerce.dto.AddProductInCartDto;
import com.example.Ecommerce.dto.CartItemsDto;
import com.example.Ecommerce.dto.OrderDto;
import com.example.Ecommerce.dto.PlaceOrderDto;
import com.example.Ecommerce.exceptions.ValidationException;
import com.example.Ecommerce.respository.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.example.Ecommerce.Enums.OrderStatus.Pending;


@Service
public class CartServiceImpl  implements CartService{


    private final OrderRespository orderRespository;
    private final UserRepository userRepository;
    private final ProductRespository productRespository;
    private final CouponRespository couponRespository;
    private final CartItemsRespository cartItemsRespository;
    public CartServiceImpl(OrderRespository orderRespository,CartItemsRespository cartItemsRespository, CouponRespository couponRespository,UserRepository userRepository, ProductRespository productRespository) {
        this.orderRespository = orderRespository;
        this.userRepository = userRepository;
        this.productRespository = productRespository;
        this.couponRespository = couponRespository;
        this.cartItemsRespository=cartItemsRespository;
    }



    public ResponseEntity<?> addProductInCart(AddProductInCartDto addProductInCartDto) {
        Order activeOrder = orderRespository.findByUserIdAndStatus(addProductInCartDto.getUserId(), Pending);
        Optional<CartItems> optionalCartItems = CartItemsRespository.findByProductIdAndOrderIdAndUserId
                (addProductInCartDto.getProductId(), activeOrder.getId(), addProductInCartDto.getUserId());

        if (optionalCartItems.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        } else {
                Optional<Product> optionalProduct=productRespository.findById(addProductInCartDto.getProductId());
            Optional<User> optionalUser=userRepository.findById(addProductInCartDto.getUserId());
            if (optionalProduct.isPresent() && optionalUser.isPresent()) {
                CartItems cart = new CartItems();
                cart.setProduct(optionalProduct.get());
                cart.setPrice(optionalProduct.get().getPrice());
                cart.setQuantity(1);
                cart.setUser(optionalUser.get());
                cart.setOrder(activeOrder);

            CartItems updateCart=new CartItems();
            activeOrder.setTotalamount((int) (activeOrder.getTotalamount()+cart.getPrice()));
            activeOrder.setAmount((int) (activeOrder.getAmount() + cart.getPrice()));
            activeOrder.getCartItems().add(cart);


            orderRespository.save(activeOrder);
            return ResponseEntity.status(HttpStatus.CREATED).body(cart);

            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }
        }
    }
    public OrderDto getCartByUserId(int userid){
        Order activeOrder = orderRespository.findByUserIdAndStatus(userid, Pending);
        List<CartItemsDto> cartItemsDtoList=activeOrder.getCartItems().stream().map(CartItems::getCartItemsDto).collect(Collectors.toList());
        OrderDto orderDto=new OrderDto();
        orderDto.setAmount(activeOrder.getAmount());
        orderDto.setId(activeOrder.getId());
        orderDto.setStatus(activeOrder.getStatus());
        orderDto.setDiscount(activeOrder.getDiscount());
        orderDto.setTotalamount(activeOrder.getTotalamount());
        orderDto.setCartItems(cartItemsDtoList);
        return orderDto;

    }
    public  OrderDto applyCoupon(int userId, String code){
        Order activeOrder = orderRespository.findByUserIdAndStatus(userId, OrderStatus.Pending);
        Coupon coupon= (Coupon) couponRespository.findByCode(code).orElseThrow(()-> new ValidationException("Coupon not found"));


    if(couponIsExpired(coupon)){
        throw new ValidationException("Coupon is expired");
    }
    int discountAmount=((coupon.getDiscount()/100)*activeOrder.getTotalamount());
    double netAmount=activeOrder.getTotalamount()-discountAmount;

    activeOrder.setTotalamount((int) netAmount);
    activeOrder.setDiscount(discountAmount);
    activeOrder.setCoupon(coupon);

    orderRespository.save(activeOrder);
    return activeOrder.getOrderDto() ;

    }

 private Boolean couponIsExpired(Coupon coupon){
    Date currentDate = new Date();
    Date expirationDate=coupon.getExpirationDate();
    return expirationDate!=null && currentDate.after(expirationDate);

}

        public OrderDto increaseProductQuantity(AddProductInCartDto addProductInCartDto){
        Order activeOrder = orderRespository.findByUserIdAndStatus(addProductInCartDto.getUserId(), OrderStatus.Pending);
        Optional<Product> optionalProduct=productRespository.findById(addProductInCartDto.getUserId());


        Optional<CartItems> optionalCartItems= CartItemsRespository.findByProductIdAndOrderIdAndUserId(
                addProductInCartDto.getProductId(),activeOrder.getId(),addProductInCartDto.getUserId()
        );
        if (optionalProduct.isPresent() && optionalCartItems.isPresent()) {
            CartItems cartItems = optionalCartItems.get();
            Product product=optionalProduct.get();


            activeOrder.setAmount((int) (activeOrder.getAmount()+product.getPrice()));
            activeOrder.setTotalamount((int) (activeOrder.getTotalamount()+product.getPrice()));

            cartItems.setQuantity(cartItems.getQuantity()+1);
            if (activeOrder.getCartItems()!=null) {
                int discountAmount=((activeOrder.getCoupon().getDiscount()/100)*activeOrder.getTotalamount());
                double netAmount=activeOrder.getTotalamount()-discountAmount;

                activeOrder.setTotalamount((int) netAmount);
                activeOrder.setDiscount(discountAmount);


            }
            orderRespository.save(activeOrder);
            cartItemsRespository.save(cartItems);

                return activeOrder.getOrderDto();
        }
        return null;

        }


    public OrderDto decreaseProductQuantity(AddProductInCartDto addProductInCartDto){
        Order activeOrder = orderRespository.findByUserIdAndStatus(addProductInCartDto.getUserId(), OrderStatus.Pending);
        Optional<Product> optionalProduct=productRespository.findById(addProductInCartDto.getUserId());


        Optional<CartItems> optionalCartItems= CartItemsRespository.findByProductIdAndOrderIdAndUserId(
                addProductInCartDto.getProductId(),activeOrder.getId(),addProductInCartDto.getUserId()
        );
        if (optionalProduct.isPresent() && optionalCartItems.isPresent()) {
            CartItems cartItems = optionalCartItems.get();
            Product product=optionalProduct.get();


            activeOrder.setAmount((int) (activeOrder.getAmount()-product.getPrice()));
            activeOrder.setTotalamount((int) (activeOrder.getTotalamount()-product.getPrice()));

            cartItems.setQuantity(cartItems.getQuantity()-1);
            if (activeOrder.getCartItems()!=null) {
                int discountAmount=((activeOrder.getCoupon().getDiscount()/100)*activeOrder.getTotalamount());
                double netAmount=activeOrder.getTotalamount()-discountAmount;

                activeOrder.setTotalamount((int) netAmount);
                activeOrder.setDiscount(discountAmount);


            }
            orderRespository.save(activeOrder);
            cartItemsRespository.save(cartItems);

            return activeOrder.getOrderDto();
        }
        return null;

    }
    public OrderDto placeOrder(PlaceOrderDto placeOrderDto){
        Order activeOrder = orderRespository.findByUserIdAndStatus(placeOrderDto.getUserId(), OrderStatus.Pending);
        Optional<User> optionalUser=userRepository.findById(placeOrderDto.getUserId());
        if (optionalUser.isPresent()){

            activeOrder.setOrderDescription(placeOrderDto.getOrderDescription());
            activeOrder.setAddress(placeOrderDto.getAddress());
            activeOrder.setDate(new Date());
            activeOrder.setStatus(OrderStatus.Pending);
            activeOrder.setTrackingid(UUID.randomUUID());

            orderRespository.save(activeOrder);



            Order order= new Order();
            order.setUser(optionalUser.get());
            order.setTotalamount(0);
            order.setAmount(0);
            order.setDiscount(0);
            order.setStatus(OrderStatus.Pending);
            orderRespository.save(order);


                return activeOrder.getOrderDto();

        }
        return null;
    }
     public List<OrderDto> getMyPlaceOrders(int userId){
        return orderRespository.findByUserIdAndStatusIn(userId,List.of(OrderStatus.Placed,OrderStatus.Shipped,OrderStatus.Delivered)).stream().map(Order::getOrderDto).collect(Collectors.toList());

     }
}