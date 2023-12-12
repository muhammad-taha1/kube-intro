package com.example.kubeintro.controller;

import com.example.kubeintro.repository.SampleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public record SampleController(SampleRepository sampleRepository) {

    @GetMapping("/db-msg")
    public String getMessageFromDatabase() {
        return sampleRepository.findAll().stream().findAny().get().message();
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }
}
