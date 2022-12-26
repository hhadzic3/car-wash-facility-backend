package com.example.carwashfacility.controllers;

import com.example.carwashfacility.daos.UserDao;
import com.example.carwashfacility.dtos.AuthentificationRequestDto;
import com.example.carwashfacility.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authentificationManager;
    private final UserDao userDao;
    private final JwtUtils jwtUtils;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(
            @RequestBody AuthentificationRequestDto request
    ){
         authentificationManager.authenticate(new UsernamePasswordAuthenticationToken(
                 request.getEmail(),
                 request.getPassword()
         ));
         final UserDetails user = userDao.findUserByEmail(request.getEmail());
         if (user != null){
            return ResponseEntity.ok(jwtUtils.generateToken(user));
         }
         return ResponseEntity.badRequest().body("Error");
    }
}
