/*
package com.example.Ecommerce.service.auth;

import com.example.Ecommerce.Entity.Order;
import com.example.Ecommerce.Entity.User;
import com.example.Ecommerce.Enums.OrderStatus;
import com.example.Ecommerce.Enums.UserRole;
import com.example.Ecommerce.dto.SignupRequest;
import com.example.Ecommerce.dto.UserDto;
import com.example.Ecommerce.respository.OrderRespository;
import com.example.Ecommerce.respository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImp implements AuthService {
    private final UserRepository userRepository;
    private final OrderRespository orderRespository;
    public AuthServiceImp(UserRepository userRepository,OrderRespository orderRespository) {
        this.orderRespository = orderRespository;
        this.userRepository = userRepository;
    }

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    public UserDto createUser(SignupRequest signupRequest) {
        User user = new User();
        user.setEmail(signupRequest.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(signupRequest.getPassword()));
        user.setUsername(signupRequest.getName());
        user.setRole(UserRole.CUSTOMER);
        User Usercreated = userRepository.save(user);

        Order order= new Order();
        order.setUser(user);
        order.setTotalamount(0);
        order.setAmount(0);
        order.setDiscount(0);
        order.setStatus(OrderStatus.Pending);
        orderRespository.save(order);

        UserDto userDto = new UserDto();
        userDto.setId(Usercreated.getId());

        return userDto;
    }
    public boolean hasUserWithEmail(String email){

        return userRepository.findFirstByEmail(email).isPresent();
    }

    @PostConstruct
    public void createAdminAccount(){
        User adminAccount = userRepository.findByRole(UserRole.ADMIN);
        if (adminAccount == null){
            User user = new User();
            user.setEmail("admin@gmail.com");
            user.setUsername("admin");
            user.setRole(UserRole.ADMIN);
            user.setPassword(bCryptPasswordEncoder.encode("admin"));
            userRepository.save(user);

        }
    }
}*/
