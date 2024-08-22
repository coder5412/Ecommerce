package com.example.Ecommerce.respository;

import com.example.Ecommerce.Entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CouponRespository extends JpaRepository<Coupon, Integer> {
    boolean existsByCode(String code);

    Optional<Object> findByCode(String code);
}
