package com.example.carwashfacility.repositories;

import com.example.carwashfacility.models.User;
import com.example.carwashfacility.models.Washing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WashingRepository extends JpaRepository<Washing, Long> {
}
