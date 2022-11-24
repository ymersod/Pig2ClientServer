package com.piggyfarm.grpc;

import com.piggyfarm.grpc.slaughterhouse.PigFarm;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;

@SpringBootApplication
public class PigClientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PigClientServiceApplication.class, args);
    }
}
