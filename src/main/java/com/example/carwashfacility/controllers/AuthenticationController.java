package com.example.carwashfacility.controllers;

import com.example.carwashfacility.dtos.AuthentificationRequestDto;
import com.example.carwashfacility.dtos.RegisterRequestDto;
import com.example.carwashfacility.models.User;
import com.example.carwashfacility.repositories.UserRepository;
import com.example.carwashfacility.services.UserService;
import com.example.carwashfacility.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationManager authentificationManager;
    @Autowired
    private final UserService userService;
    private final JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<String> authenticate(
            @RequestBody AuthentificationRequestDto request
    ){
         authentificationManager.authenticate(new UsernamePasswordAuthenticationToken(
                 request.getEmail(),
                 request.getPassword()
         ));
         final User appUser = userService.findUserByEmail(request.getEmail());
         if (appUser != null){
             final UserDetails user = new org.springframework.security.core.userdetails.User(
                     appUser.getEmail(),
                     appUser.getPassword(),
                     Collections.singleton(new SimpleGrantedAuthority(appUser.getRole()))
             );
            return ResponseEntity.ok(jwtUtils.generateToken(user));
         }
         return ResponseEntity.badRequest().body("Error");
    }

}
