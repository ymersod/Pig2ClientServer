package com.piggyfarm.grpc;

import com.domain.Pig;
import com.domain.Product;
import com.piggyfarm.grpc.slaughterhouse.PigFarm;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

@SpringBootApplication
public class PigClientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PigClientServiceApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}
