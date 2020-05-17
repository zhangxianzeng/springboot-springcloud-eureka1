package com.example.demoshengchanzhe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DemoshengchanzheApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoshengchanzheApplication.class, args);
    }

}
