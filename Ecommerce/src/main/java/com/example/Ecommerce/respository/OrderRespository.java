package com.example.Ecommerce.respository;


import com.example.Ecommerce.Entity.Order;
import com.example.Ecommerce.Enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRespository extends JpaRepository<Order, Integer> {

    Order findByUserIdAndStatus(int userId, OrderStatus orderStatus);

    List<Order> findAllByStatusIn(List<OrderStatus> orderStatusList);
       List<Order> findByUserIdAndStatusIn(int userId, List<OrderStatus> orderStatus);


}
