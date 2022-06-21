package com.demo.Mongo.controller;

import com.demo.Mongo.repositories.PatientTestsRepository;
import com.demo.Mongo.models.collections.PatientTests;
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
public class PatientTestsController {

    @Autowired
    private PatientTestsRepository patientTestsRepository;

    @GetMapping("/patientsTests")
    public List<PatientTests> findAllTests() {
        return patientTestsRepository.findAll();
    }

    @GetMapping("/patientTests/{patientId}")
    public ResponseEntity<PatientTests> findTestsById(@PathVariable(value = "patientId") String patientId) {
        Optional<PatientTests> patientTests = patientTestsRepository.findById(patientId);
        if (patientTests.isPresent()) {
            return ResponseEntity.ok().body(patientTests.get());
        } else {
            System.out.println(patientTests.get().get_id());
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/patientTests/save")
    public PatientTests savePatientRecord(@RequestBody PatientTests patientTest) {
        return patientTestsRepository.save(patientTest);
    }
}