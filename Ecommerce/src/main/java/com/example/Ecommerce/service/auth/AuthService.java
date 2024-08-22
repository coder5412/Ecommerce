package com.example.Ecommerce.service.auth;

import com.example.Ecommerce.dto.SignupRequest;
import com.example.Ecommerce.dto.UserDto;

public interface AuthService {

    UserDto createUser(SignupRequest signupRequest);


    boolean hasUserWithEmail(String email);
}
