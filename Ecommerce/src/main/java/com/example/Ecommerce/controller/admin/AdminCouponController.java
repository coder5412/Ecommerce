package com.example.Ecommerce.controller.admin;

import com.example.Ecommerce.Entity.Coupon;
import com.example.Ecommerce.exceptions.ValidationException;
import com.example.Ecommerce.service.Admin.Coupon.AdminCouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/coupon")

public class AdminCouponController {


private final AdminCouponService adminCouponService;

    public AdminCouponController(AdminCouponService adminCouponService) {
        this.adminCouponService = adminCouponService;
    }


    @PostMapping
public ResponseEntity<?> createCoupon(Coupon coupon) {
    try {
        Coupon createdcoupon=adminCouponService.createcoupon(coupon);
        return ResponseEntity.ok(createdcoupon);
    }
    catch (ValidationException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
@GetMapping
public ResponseEntity<List<Coupon>> getAllCoupons() {
    return ResponseEntity.ok(adminCouponService.getAllCoupons());
}


















}
