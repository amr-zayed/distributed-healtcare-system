package com.demo.Mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<Patient> findById(@PathVariable(value = "id") String id) {
        Optional<Patient> user = patientRepository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok().body(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/patient/save")
    public Patient saveUser(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }
}