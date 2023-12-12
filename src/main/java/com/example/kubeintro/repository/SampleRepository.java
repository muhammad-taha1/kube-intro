package com.example.kubeintro.repository;

import com.example.kubeintro.model.SampleModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SampleRepository extends MongoRepository<SampleModel, String> {

}
