package com.example.carwashfacility.controllers;

import com.example.carwashfacility.models.Location;
import com.example.carwashfacility.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/location")
public class LocationController {
    @Autowired
    LocationRepository locationRepository;

    /**
     * Get all the locations
     *
     * @return ResponseEntity
     */
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<List<Location>> getLocations() {
        try {
            return new ResponseEntity<>(locationRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get the location by id
     *
     * @param id
     * @return ResponseEntity
     */
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<Location> getLocationById(@PathVariable("id") long id) {
        try {
            //check if location exist in database
            Location empObj = getLocRec(id);

            if (empObj != null) {
                return new ResponseEntity<>(empObj, HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * Create new location
     *
     * @param location
     * @return ResponseEntity
     */
    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<Location> newLocation(@RequestBody Location location) {
        Location newLocation = locationRepository
                .save(Location.builder()
                        .name(location.getName())
                        .build());
        return new ResponseEntity<>(newLocation, HttpStatus.OK);
    }

    /**
     * Update Location record by using it's id
     *
     * @param id
     * @param location
     * @return
     */
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<Location> updateLocation(@PathVariable("id") long id, @RequestBody Location location) {

        //check if location exist in database
        Location empObj = getLocRec(id);

        if (empObj != null) {
            empObj.setName(location.getName());
            return new ResponseEntity<>(locationRepository.save(empObj), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Delete Location by Id
     *
     * @param id
     * @return ResponseEntity
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<HttpStatus> deleteLocationById(@PathVariable("id") long id) {
        try {
            //check if location exist in database
            Location emp = getLocRec(id);

            if (emp != null) {
                locationRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * Delete all locations
     *
     * @return ResponseEntity
     */
    @DeleteMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<HttpStatus> deleteAllLocations() {
        try {
            locationRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * Method to get the location record by id
     *
     * @param id
     * @return Location
     */
    private Location getLocRec(long id) {
        Optional<Location> locObj = locationRepository.findById(id);

        if (locObj.isPresent()) {
            return locObj.get();
        }
        return null;
    }

}
