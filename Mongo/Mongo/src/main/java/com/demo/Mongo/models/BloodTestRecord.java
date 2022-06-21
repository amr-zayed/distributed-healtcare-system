package com.demo.Mongo.models;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class BloodTestRecord {
    private String timestamp;
    private String wbc;
    private String rbc;
    private String platelets;
    private String hemoglobin;
}
