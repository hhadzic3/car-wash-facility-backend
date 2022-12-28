package com.example.carwashfacility.repositories;

import com.example.carwashfacility.models.PackageStep;
import com.example.carwashfacility.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageStepRepository extends JpaRepository<PackageStep, Long> {
}
