package com.bosonit.backend.ejercicio2.REST;

import com.bosonit.backend.ejercicio2.entidades.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("useradd")
    public ResponseEntity<Persona> crearPersona(
            @RequestBody Persona persona) {     // posteriormente usaremos DTO
        log.info("Recibida: " + persona);
        persona.setEdad(persona.getEdad() + 1);
        return ResponseEntity.status(HttpStatus.CREATED).body(persona);
    }
}