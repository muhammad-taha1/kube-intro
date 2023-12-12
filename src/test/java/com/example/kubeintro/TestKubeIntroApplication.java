package com.example.kubeintro;

import com.example.kubeintro.controller.SampleController;
import com.example.kubeintro.model.SampleModel;
import com.example.kubeintro.repository.SampleRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
@SpringBootTest
public class TestKubeIntroApplication {

    @Autowired
    private SampleRepository sampleRepository;

    @Autowired
    private SampleController sampleController;

    @Container
    static MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:latest"));

    @DynamicPropertySource
    static void mongoDbProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }

    @BeforeAll
    public static void  beforeAll() {
        mongoDBContainer.start();
    }

    @BeforeEach
    public void setup()  {
        SampleModel  sampleModel = new SampleModel("dbMsg");
        sampleRepository.save(sampleModel);
    }

    @Test
    public void testMessageRetrievalFromDatabase() {
        assertEquals("dbMsg", sampleController.getMessageFromDatabase());
    }


//    public static void main(String[] args) {
//        SpringApplication.from(KubeIntroApplication::main).with(TestKubeIntroApplication.class).run(args);
//    }

}
