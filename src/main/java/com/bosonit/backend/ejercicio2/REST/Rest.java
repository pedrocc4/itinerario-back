package com.bosonit.backend.ejercicio2.REST;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class Rest {
    private final Logger log = Logger.getLogger(Rest.class.getName());

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("user/{nombre}")
    public ResponseEntity<String> obtenerHola(@PathVariable String nombre) {
        log.info("Nombre: " + nombre);
        String hola = "Hola: " + nombre;
        return ResponseEntity.ok(hola);
    }
}
