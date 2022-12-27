package com.example.carwashfacility.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloController {
    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Helo");
    }
    @GetMapping("/good-bye")
    public ResponseEntity<String> sayGoodBye() {
        return ResponseEntity.ok("Good Bye");
    }

 /*   @GetMapping("/users")
    public ResponseEntity<User> getUsers() {
        return ResponseEntity.ok();
    }
*/
}
