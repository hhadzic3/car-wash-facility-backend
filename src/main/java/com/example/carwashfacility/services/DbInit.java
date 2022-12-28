package com.example.carwashfacility.services;

import com.example.carwashfacility.models.User;
import com.example.carwashfacility.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
       /* this.userRepository.deleteAll();

        // Crete users
        User dan = new User(
                1L,
                "dan@gamil.com",
                passwordEncoder.encode("dan123"),
                true,
                "USER",
                0
        );
        User admin = new User(2L,"admin@gmail.com",passwordEncoder.encode("admin123"),true,"ADMIN",0);

        List<User> users = Arrays.asList(dan,admin);

        // Save to db
        this.userRepository.saveAll(users);*/
    }
}
