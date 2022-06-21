package com.demo.Mongo.repositories;

import com.demo.Mongo.models.collections.PatientTests;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientTestsRepository extends MongoRepository<PatientTests, String> {
}
