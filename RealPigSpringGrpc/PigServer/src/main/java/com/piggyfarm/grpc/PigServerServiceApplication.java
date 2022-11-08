package com.piggyfarm.grpc;

import com.piggyfarm.grpc.service.DataBaseAccess;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PigServerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PigServerServiceApplication.class, args);
    }


    @Bean
    public static DataBaseAccess getDataBaseAccess()
    {
        return new DataBaseAccess();
    }
}
