package com.example.carwashfacility.configs;

import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;

public class JwtAuthFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInterval(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServerException, IOException {
        final String authHeader = request.getHeader(AUTHORIZATION);
        final String userEmail;
        final String jwtToken;

        if (authHeader == null || !authHeader.startsWith("Bearer")){
            filterChain.doFilter(request, response);
            return;
        }
        jwtToken = authHeader.substring(7);
        userEmail = "something";
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null){

        }
    }
}
