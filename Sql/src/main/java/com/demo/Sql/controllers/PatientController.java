package com.demo.Sql.controllers;

import com.demo.Sql.model.Patient;
import com.demo.Sql.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> findAllModels() {
        return patientRepository.findAll();
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<Patient> findUserById(@PathVariable(value = "id") long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isPresent()) {
            return ResponseEntity.ok().body(patient.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/patient/save")
    public Patient savePharmacy(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

}