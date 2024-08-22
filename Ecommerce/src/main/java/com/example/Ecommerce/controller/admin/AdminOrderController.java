package com.example.Ecommerce.controller.admin;

import com.example.Ecommerce.dto.OrderDto;
import com.example.Ecommerce.service.Admin.adminOrder.AdminOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@RequestMapping("/api/admin")
public class AdminOrderController {


    private final AdminOrderService adminOrderService;

    public AdminOrderController(AdminOrderService adminOrderService){
        this.adminOrderService = adminOrderService;
    }


    @GetMapping("/placeorders")
    public ResponseEntity<List<OrderDto>> getAllPlaceOrder() {

        return ResponseEntity.ok(adminOrderService.getAllOrders());

    }
    @GetMapping("/order/{orderId}/{status}")
    public ResponseEntity<?> changeOrderStatus(@PathVariable int orderId, @PathVariable String status) {
        OrderDto orderDto=adminOrderService.changeStatus(orderId, status);
        if (orderDto==null) {
            return new ResponseEntity<>("Something went wronge", HttpStatus.BAD_REQUEST);

        }
        return ResponseEntity.status(HttpStatus.OK).body(orderDto);
    }























}
