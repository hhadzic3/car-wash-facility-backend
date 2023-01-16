package com.example.carwashfacility.repositories;

import com.example.carwashfacility.models.Package;
import com.example.carwashfacility.models.PackageStep;
import com.example.carwashfacility.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageStepRepository extends JpaRepository<PackageStep, Long> {
    List<PackageStep> findByPack(Package pack);
}
