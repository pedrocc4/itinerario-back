package com.bosonit.backend.ejercicio3.REST;

import com.bosonit.backend.ejercicio3.entidades.Ciudad;
import com.bosonit.backend.ejercicio3.entidades.Persona;
import com.bosonit.backend.ejercicio3.servicios.ServicioBosonit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("controlador1")
public class Controlador1 {

    private final Logger log = Logger.getLogger(Controlador2.class.getName());

    @Autowired
    private ServicioBosonit servicio;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("addPersona")
    public ResponseEntity<Persona> crearPersona(
            @RequestHeader String nombre,
            @RequestHeader String poblacion,
            @RequestHeader Integer edad) {

        log.info("Nombre: " + nombre + ", " + "Poblacion: " + poblacion + ", " + "Edad: " + edad);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(servicio.crearPersona(nombre, poblacion, edad));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("addCiudad")
    public ResponseEntity<Void> crearCiudad(@RequestBody Ciudad ciudad) {

        log.info("Recibido: " + ciudad);
        servicio.addCiudad(ciudad);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}