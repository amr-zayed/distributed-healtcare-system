package com.demo.Sql.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "patients")
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Double weight;
    private Double height;
    private String gender;
    private String phoneNo;
    private String dateOfBirth;

    public Patient(String firstName, String middleName, String lastName, Double weight, Double height, String gender, String phoneNo, String dateOfBirth) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return this.gender;
    }

}
