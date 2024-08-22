package com.example.Ecommerce.Entity;


import com.example.Ecommerce.Enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;


    private String Password;


    private String Username;

@Enumerated(EnumType.STRING)
    private UserRole role;



    //private Byte[]img;



}

