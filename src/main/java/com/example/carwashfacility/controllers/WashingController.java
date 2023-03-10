package com.example.carwashfacility.controllers;

import com.example.carwashfacility.dtos.CreateWashingDto;
import com.example.carwashfacility.models.Washing;
import com.example.carwashfacility.repositories.WashingRepository;
import com.example.carwashfacility.services.WashingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/washing")
public class WashingController {

    @Autowired
    WashingService washingService;

    @Autowired
    WashingRepository washingRepository;

    /**
     * Get all the washings
     *
     * @return ResponseEntity
     */
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<List<Washing>> getWashings() {
        try {
            return new ResponseEntity<>(washingRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get the washing by id
     *
     * @param id
     * @return ResponseEntity
     */
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<Washing> getWashingById(@PathVariable("id") long id) {
        try {
            //check if washing exist in database
            Washing washing = getRec(id);

            if (washing != null) {
                return new ResponseEntity<>(washing, HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * Create new washing
     *
     * @param washingDto
     * @return ResponseEntity
     */
    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<Washing> newWashing(@RequestBody CreateWashingDto washingDto) {

        Washing newWashing = washingService.save(washingDto);

        return new ResponseEntity<>(newWashing, HttpStatus.OK);
    }

    /**
     * Update Washing record by using it's id
     *
     * @param id
     * @param washing
     * @return
     */
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<Washing> updateWashing(@PathVariable("id") long id, @RequestBody Washing washing) {

        //check if washing exist in database
        Washing object = getRec(id);

        if (object != null) {
            object.setLocation(washing.getLocation());
            object.setPack(washing.getPack());
            object.setUser(washing.getUser());
            object.setTime(washing.getTime());
            return new ResponseEntity<>(washingRepository.save(object), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Delete Washing by Id
     *
     * @param id
     * @return ResponseEntity
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<HttpStatus> deleteWashingById(@PathVariable("id") long id) {
        try {
            //check if washing exist in database
            Washing washing = getRec(id);

            if (washing != null) {
                washingRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * Delete all washings
     *
     * @return ResponseEntity
     */
    @DeleteMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<HttpStatus> deleteAllWashings() {
        try {
            washingRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * Method to get the washing record by id
     *
     * @param id
     * @return Washing
     */
    private Washing getRec(long id) {
        Optional<Washing> obj = washingRepository.findById(id);

        if (obj.isPresent()) {
            return obj.get();
        }
        return null;
    }

}
