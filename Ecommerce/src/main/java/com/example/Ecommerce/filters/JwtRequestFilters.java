package com.example.Ecommerce.filters;

import com.example.Ecommerce.utilies.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtRequestFilters extends OncePerRequestFilter {

/*    private final UserDetailsService userDetailsService;*/
    private final JwtUtils jwtUtils;



    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        String Token = null;
        String username = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            Token = authHeader.substring(7);
            username = jwtUtils.extractUsername(Token);

        }
        /*if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);


            if (jwtUtils.validateToken(Token, userDetails)) {
                UsernamePasswordAuthenticationToken awtstoken=new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                awtstoken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(awtstoken);
            }
        }*/
            filterChain.doFilter(request, response);
    }
    }

