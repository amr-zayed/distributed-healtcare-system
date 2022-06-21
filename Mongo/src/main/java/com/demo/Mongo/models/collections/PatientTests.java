package com.demo.Mongo.models.collections;

import com.demo.Mongo.models.test;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("patientTests")
public class PatientTests {

	@Id
	private String _id;
    private String patientId;
	private List<test> document;

	public PatientTests(){
	}

	public PatientTests(String patientId) {
		this.patientId = patientId;
	}

	public PatientTests(String patientId, List<test> document) {
		this.patientId = patientId;
		this.document = document;
	}

	public void setDocument(List<test> document) {
		this.document = document;
	}

	public String get_id() {
		return _id;
	}

	public List<test> getDocument() {
		return document;
	}
}
