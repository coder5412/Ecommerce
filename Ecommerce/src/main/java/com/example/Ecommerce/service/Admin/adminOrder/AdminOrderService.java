package com.example.Ecommerce.service.Admin.adminOrder;

import com.example.Ecommerce.dto.OrderDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AdminOrderService {

    List<OrderDto> getAllOrders();
    OrderDto changeStatus(int orderId, String status);
}
