package com.example.carwashfacility.controllers;

import com.example.carwashfacility.models.Step;
import com.example.carwashfacility.repositories.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/step")
public class StepController {
    @Autowired
    StepRepository stepRepository;

    @GetMapping
    public ResponseEntity<List<Step>> getSteps() {
        try {
            return new ResponseEntity<>(stepRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Step> getStepById(@PathVariable("id") long id) {
        try {
            //check if step exist in database
            Step step = getRec(id);

            if (step != null) {
                return new ResponseEntity<>(step, HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping
    public ResponseEntity<Step> newStep(@RequestBody Step step) {
        Step newStep = stepRepository
                .save(Step.builder()
                        .name(step.getName())
                        .build());
        return new ResponseEntity<>(newStep, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Step> updateStep(@PathVariable("id") long id, @RequestBody Step step) {

        //check if step exist in database
        Step object = getRec(id);

        if (object != null) {
            object.setName(step.getName());
            return new ResponseEntity<>(stepRepository.save(object), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteStepById(@PathVariable("id") long id) {
        try {
            //check if step exist in database
            Step step = getRec(id);

            if (step != null) {
                stepRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllSteps() {
        try {
            stepRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    private Step getRec(long id) {
        Optional<Step> obj = stepRepository.findById(id);

        if (obj.isPresent()) {
            return obj.get();
        }
        return null;
    }
}
