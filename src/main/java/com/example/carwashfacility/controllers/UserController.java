package com.example.carwashfacility.controllers;

import com.example.carwashfacility.dtos.UsersWithActivitiesDto;
import com.example.carwashfacility.models.User;
import com.example.carwashfacility.repositories.UserRepository;
import com.example.carwashfacility.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService,
                          UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public List<UsersWithActivitiesDto> getUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/{email}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<User> getUserById(@PathVariable("email") String email) {
        try {
            User empObj = getUserIfExists(email);

            if (empObj != null) {
                return new ResponseEntity<>(empObj, HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    private User getUserIfExists(String email) {
        Optional<User> user = Optional.ofNullable(userRepository.findUserByEmail(email));

        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }
}
