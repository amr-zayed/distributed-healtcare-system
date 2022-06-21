package com.demo.Mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BloodTestRecordController {

    @Autowired
    private PatientRepository patientRepository;


    @GetMapping("/blood-tests/{patientId}")
    public ResponseEntity<List<BloodTestRecord>> findById(@PathVariable(value = "patientId") String patientId) {
        Optional<Patient> patient = patientRepository.findById(patientId);
        if (patient.isPresent()) {
            return ResponseEntity.ok().body(patient.get().getBloodTestRecords() == null ? new ArrayList<>() : patient.get().getBloodTestRecords());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/blood-test/save/{patientId}")
    public ResponseEntity<Patient> saveUser(@RequestBody BloodTestRecord record, @PathVariable(value = "patientId") String patientId) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            List<BloodTestRecord> bloodTestRecords = patient.getBloodTestRecords();
            if (bloodTestRecords == null) {
                bloodTestRecords = new ArrayList<>();
            }
            record.setTimestamp(ZonedDateTime.now().toString());
            bloodTestRecords.add(record);
            patient.setBloodTestRecords(bloodTestRecords);

            return ResponseEntity.ok().body(patientRepository.save(patient));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}