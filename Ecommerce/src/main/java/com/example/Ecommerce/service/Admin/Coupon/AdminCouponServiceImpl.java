package com.example.Ecommerce.service.Admin.Coupon;


import com.example.Ecommerce.Entity.Coupon;

import com.example.Ecommerce.exceptions.ValidationException;
import com.example.Ecommerce.respository.CouponRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.support.BeanDefinitionValidationException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.ValidationAnnotationUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminCouponServiceImpl implements AdminCouponService{


    private final CouponRespository couponRepository;

    public Coupon createcoupon(Coupon coupon){

        if(couponRepository.existsByCode(coupon.getCode())){
            throw new ValidationException("Coupon already exists");
        }
        return couponRepository.save(coupon);
    }
    public List<Coupon> getAllCoupons(){
        return couponRepository.findAll();
    }
}
