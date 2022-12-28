package com.example.carwashfacility.repositories;

import com.example.carwashfacility.models.Step;
import com.example.carwashfacility.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepRepository extends JpaRepository<Step, Long> {
}
