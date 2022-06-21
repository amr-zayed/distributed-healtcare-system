package com.demo.Mongo.models.collections;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@Document("patient")
public class Patient {
	@Id
	private String _id;
	private Name name;
	private String phone;
	private int age;
	private String gender;
	private List<BloodTestRecord> bloodTestRecords;

	public Patient(Name name, String phone, int age, String gender, List<BloodTestRecord> bloodTestRecords) {
		this.name = name;
		this.phone = phone;
		this.age = age;
		this.gender = gender;
		this.bloodTestRecords = bloodTestRecords;
	}
}
