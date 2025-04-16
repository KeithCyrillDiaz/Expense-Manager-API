package com.keithdiaz.training.interceptors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.keithdiaz.training.exceptions.CustomException;
import com.keithdiaz.training.jwt.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class HeaderInterceptor implements HandlerInterceptor {
    
    private final JwtUtil jwtUtil;

    public HeaderInterceptor(JwtUtil jwtUtil){
        this.jwtUtil = jwtUtil;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,  Object handler){
        String authHeader = request.getHeader("Authorization");
        String errorMessage = "Unauthorized User";

        if(authHeader == null  || !authHeader.startsWith("Bearer ") || authHeader.split(" ").length  < 2) {
            throw new CustomException( errorMessage, HttpStatus.UNAUTHORIZED);
        }
        String token = authHeader.split(" ")[1];
        if(token.isEmpty()) {
            throw new CustomException(errorMessage, HttpStatus.UNAUTHORIZED);
            
        }

        boolean isTokenValid = jwtUtil.validateToken(token);

        if(!isTokenValid) {
            throw new CustomException(errorMessage, HttpStatus.UNAUTHORIZED);
        }
        return true;
    }
}
