package com.demo.Mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/doctors")
    public List<Doctor> findAllPatients() {
        return doctorRepository.findAll();
    }

    @GetMapping("/doctor/{id}")
    public ResponseEntity<Doctor> findById(@PathVariable(value = "id") String id) {
        Optional<Doctor> user = doctorRepository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok().body(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/doctor/save")
    public Doctor saveUser(@RequestBody Doctor doctor) {
        return doctorRepository.save(doctor);
    }
}