package com.example.Ecommerce.service.Admin.adminOrder;

import com.example.Ecommerce.Entity.Order;
import com.example.Ecommerce.Enums.OrderStatus;
import com.example.Ecommerce.dto.OrderDto;
import com.example.Ecommerce.respository.OrderRespository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminOrderServiceImpl implements AdminOrderService {



    private final OrderRespository orderRepository;
    public AdminOrderServiceImpl(OrderRespository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderDto> getAllOrders() {
        List<Order> ordersList = orderRepository.findAllByStatusIn(List.of(OrderStatus.Placed,OrderStatus.Shipped,OrderStatus.Delivered));
        return ordersList.stream().map(Order::getOrderDto).collect(Collectors.toList());

    }
    public OrderDto changeStatus(int orderId, String status) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();

            if ((Objects.equals(status,"Shipped"))){
                order.setStatus(OrderStatus.Shipped);
            }
            else if (Objects.equals(status,"Delivered")){
                order.setStatus(OrderStatus.Delivered);
            }
            return orderRepository.save(order).getOrderDto();
        }
        return null;



    }
}
