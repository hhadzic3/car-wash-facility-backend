package com.example.carwashfacility.repositories;

import com.example.carwashfacility.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
    @Query(
            value = "SELECT * FROM user u WHERE u.role = USER",
            nativeQuery = true)
    List<User> findAllUsers();
}
