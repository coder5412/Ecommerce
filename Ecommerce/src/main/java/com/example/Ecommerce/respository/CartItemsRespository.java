package com.example.Ecommerce.respository;

import com.example.Ecommerce.Entity.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartItemsRespository  extends JpaRepository<CartItems, Integer> {


    static Optional<CartItems> findByProductIdAndOrderIdAndUserId(int productId, int orderId, int userId) {
        return null;
    }
}
