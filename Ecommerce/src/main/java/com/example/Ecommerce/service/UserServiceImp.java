package com.example.Ecommerce.service;


import com.example.Ecommerce.Entity.User;
import com.example.Ecommerce.respository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServiceImp /*implements UserDetailsService*/ {



    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }/*

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser=userRepository.findFirstByEmail(username);
            if(optionalUser.isEmpty())throw new UsernameNotFoundException("user name not found ",null);
        return new org.springframework.security.core.userdetails.User(optionalUser.get().getEmail(), optionalUser.get().getPassword(), new ArrayList<>());
    }*/
    }

