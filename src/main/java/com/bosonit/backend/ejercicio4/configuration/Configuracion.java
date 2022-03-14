package com.bosonit.backend.ejercicio4.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:miconfiguracion.properties")
@Getter
public class Configuracion {
    @Value("${valor1}")
    String valor1;

    @Value("${valor2}")
    String valor2;

}
