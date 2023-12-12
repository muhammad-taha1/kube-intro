package com.example.kubeintro.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SampleModel")
public record SampleModel(String message) {
}
