package com.demo.Mongo.controller;

import com.demo.Mongo.models.collections.PatientTests;
import com.demo.Mongo.models.test;
import com.demo.Mongo.repositories.PatientTestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class TestController {

    @Autowired
    private PatientTestsRepository patientTestsRepository;

    @GetMapping("/Test/{patientId}")
    public ResponseEntity<List> findTestsById(@PathVariable(value = "patientId") String patientId,
                                                      @RequestParam String testType) {
        System.out.println(testType);
        Optional<PatientTests> optionalPatientTests = patientTestsRepository.findById(patientId);
        if (optionalPatientTests.isPresent()) {
            PatientTests patientTests = optionalPatientTests.get();
            List<test> TestRecords = patientTests.getDocument();
            if (TestRecords != null) {
                List<test> FilteredTestRecords = TestRecords.stream().filter(p -> p.getType() != testType).collect(Collectors.toList());
                return ResponseEntity.ok().body(FilteredTestRecords);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/Test/save/{patientId}")
    public ResponseEntity<PatientTests> saveUser(@RequestBody test record,
                                                 @PathVariable(value = "patientId") String patientId) {

        Optional<PatientTests> optionalPatient = patientTestsRepository.findById(patientId);
        if (optionalPatient.isPresent()) {
            PatientTests patientTests = optionalPatient.get();
            List<test> TestRecords = patientTests.getDocument();
            if (TestRecords == null) {
                TestRecords = new ArrayList<>();
            }
            TestRecords.add(record);
            patientTests.setDocument(TestRecords);

            return ResponseEntity.ok().body(patientTestsRepository.save(patientTests));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}