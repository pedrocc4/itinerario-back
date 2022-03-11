package com.bosonit.backend.ejercicio3.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {
        "com.bosonit.backend.ejercicio3.REST",
        "com.bosonit.backend.ejercicio3.servicios"
})
@EntityScan(basePackages = "com.bosonit.backend.ejercicio3.entidades")
public class app {

    public static void main(String[] args) {
        SpringApplication.run(app.class, args);
    }

}