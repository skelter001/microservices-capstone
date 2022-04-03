package com.xaghoul.catalogapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CatalogAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatalogAppApplication.class, args);
    }

}
