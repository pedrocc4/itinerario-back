package com.bosonit.backend.ejercicio4.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {
        "com.bosonit.backend.ejercicio4.REST",
        "com.bosonit.backend.ejercicio4.configuration",
        "com.bosonit.backend.ejercicio4.perfiles"
})
public class app {

    public static void main(String[] args) {
        SpringApplication.run(app.class, args);
    }

}