package com.example.Ecommerce.service.Admin.Coupon;

import com.example.Ecommerce.Entity.Coupon;

import java.util.List;

public interface AdminCouponService {
    Coupon createcoupon(Coupon coupon);
    List<Coupon> getAllCoupons();
}
