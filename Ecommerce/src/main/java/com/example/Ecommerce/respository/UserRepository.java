package com.example.Ecommerce.respository;


import com.example.Ecommerce.Entity.User;
import com.example.Ecommerce.Enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Integer>{
    Optional<User> findFirstByEmail(String email);

    User findByRole(UserRole role);
}
