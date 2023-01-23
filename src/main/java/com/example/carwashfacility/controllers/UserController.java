package com.example.carwashfacility.controllers;

import com.example.carwashfacility.dtos.RegisterRequestDto;
import com.example.carwashfacility.dtos.UsersWithActivitiesDto;
import com.example.carwashfacility.models.User;
import com.example.carwashfacility.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public List<UsersWithActivitiesDto> getUsers() {
        return userService.findAllUsers();
    }
}
