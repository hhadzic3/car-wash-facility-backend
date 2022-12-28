package com.example.carwashfacility.controllers;

import com.example.carwashfacility.models.Package;
import com.example.carwashfacility.repositories.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/package")
public class PackageController {
    @Autowired
    PackageRepository packageRepository;

    @GetMapping
    public ResponseEntity<List<Package>> getPackages() {
        try {
            return new ResponseEntity<>(packageRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Package> getPackageById(@PathVariable("id") long id) {
        try {
            //check if package exist in database
            Package pack = getRec(id);

            if (pack != null) {
                return new ResponseEntity<>(pack, HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping
    public ResponseEntity<Package> newPackage(@RequestBody Package pack) {
        Package newPackage = packageRepository
                .save(Package.builder()
                        .name(pack.getName())
                        .cost(pack.getCost())
                        .build());
        return new ResponseEntity<>(newPackage, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Package> updatePackage(@PathVariable("id") long id, @RequestBody Package pack) {

        //check if pack exist in database
        Package object = getRec(id);

        if (object != null) {
            object.setName(pack.getName());
            object.setCost(pack.getCost());
            return new ResponseEntity<>(packageRepository.save(object), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePackageById(@PathVariable("id") long id) {
        try {
            //check if package exist in database
            Package pack = getRec(id);

            if (pack != null) {
                packageRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllPackages() {
        try {
            packageRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    private Package getRec(long id) {
        Optional<Package> obj = packageRepository.findById(id);

        if (obj.isPresent()) {
            return obj.get();
        }
        return null;
    }

}
