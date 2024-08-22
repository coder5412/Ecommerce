/*
package com.example.Ecommerce.controller;

import com.example.Ecommerce.Entity.User;
import com.example.Ecommerce.dto.AuthenticationRequest;
import com.example.Ecommerce.dto.SignupRequest;
import com.example.Ecommerce.dto.UserDto;
import com.example.Ecommerce.respository.UserRepository;
import com.example.Ecommerce.service.auth.AuthService;
import com.example.Ecommerce.utilies.JwtUtils;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Optional;

@RestController

public class AuthController {


    private  AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final UserRepository userRepository;
    private final AuthService authService;
    private final JwtUtils jwtUtils;


    public AuthController( UserDetailsService userDetailsService, UserRepository userRepository, AuthService authService, JwtUtils jwtUtils) {
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
        this.authService = authService;
        this.jwtUtils = jwtUtils;
    }

    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

    @PostMapping("/authenticate")
    public void authenticate(@RequestBody AuthenticationRequest authenticationRequest,
                             HttpServletResponse response) throws IOException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("incorrect user name and password");

        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        Optional<User> optionalUser = userRepository.findFirstByEmail(userDetails.getUsername());
        final String jwt = jwtUtils.generateToken(userDetails.getUsername());

        try {
            if (optionalUser.isPresent()) {
                response.getWriter().write(new JSONObject().put("userID", optionalUser.get().getId())
                        .put("role", optionalUser.get().getRole())
                        .toString());
            }

            response.addHeader(HEADER_STRING, TOKEN_PREFIX + jwt);
        } catch (JSONException e) {
            System.out.println(e.getMessage());
        }
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUser(@RequestBody SignupRequest signupRequest) {

        if (authService.hasUserWithEmail(signupRequest.getEmail())){

            return new ResponseEntity<>("user already exists", HttpStatus.NOT_ACCEPTABLE);
    }


        UserDto userDto=authService.createUser(signupRequest);
    return new ResponseEntity(userDto,HttpStatus.OK);
}
}*/
