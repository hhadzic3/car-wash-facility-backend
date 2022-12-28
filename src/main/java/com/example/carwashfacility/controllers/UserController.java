package com.example.carwashfacility.controllers;

import com.example.carwashfacility.dtos.RegisterRequestDto;
import com.example.carwashfacility.models.User;
import com.example.carwashfacility.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public List<User> getUsers() {
        return userService.findAllUsers();
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setNumberOdWashes(0);
        user.setActive(true);
        user.setRole(request.getRole());
        if (request.getRole().equals("USER") && request.getRole().equals("ADMIN"))
            return ResponseEntity.badRequest().body("Role error");
        try {
            userService.save(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
        return ResponseEntity.badRequest().body("OK");
    }

}
