package com.example.Ecommerce.config;


import com.example.Ecommerce.filters.JwtRequestFilters;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
@Configuration
@RequiredArgsConstructor
*/
/*
public class WebSecurityConfiguration {


*/
/* @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        *//*
*/
/*return http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/authenticate", "/sign-up", "/order**").permitAll()
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/api/**").authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(authFilter, UsernamePasswordAuthenticationFilter.class)
                .build();*//*
*/
/*

//        return http
//                .csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/authenticate", "/sign-up", "/order**").permitAll()
//                .and()
//                .authorizeHttpRequests()
//                .requestMatchers("/api/**").authenticated()
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .addFilter(authFilter, UsernamePasswordAuthenticationFilter.class)
//                .build();
        return null;
    }*//*


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();

    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}*/
