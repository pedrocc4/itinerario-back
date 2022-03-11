package com.bosonit.backend.ejercicio2.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {
        "com.bosonit.backend.ejercicio2.REST"
})
@EntityScan(basePackages = "com.bosonit.backend.ejercicio2.entidades")
public class app {

    public static void main(String[] args) {
        SpringApplication.run(app.class, args);
    }

}