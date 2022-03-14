package com.bosonit.backend.ejercicio3.REST;

import com.bosonit.backend.ejercicio3.entidades.Ciudad;
import com.bosonit.backend.ejercicio3.entidades.Persona;
import com.bosonit.backend.ejercicio3.excepciones.PersonaNoEncontrada;
import com.bosonit.backend.ejercicio3.servicios.ServicioBosonit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("controlador2")
public class Controlador2 {
    private final Logger log = Logger.getLogger(Controlador2.class.getName());

    @Autowired
    private ServicioBosonit servicio;

    @Autowired
    Controlador1 controlador1;

    @GetMapping("getPersona/{nombre}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Persona> verPersona(@PathVariable String nombre) {
        List<Persona> personas = servicio.getPersonas();
        log.info("Nombre de persona a buscar: " + nombre);
        return ResponseEntity.status(HttpStatus.OK)
                .body(personas.stream()
                        .filter(persona -> persona.getNombre().contentEquals(nombre))
                        .findFirst()
                        .orElseThrow(PersonaNoEncontrada::new));
    }

    @GetMapping("getPersonas")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Persona>> verPersonas() {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.getPersonas());
    }

    @GetMapping("getCiudades")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Ciudad>> verCiudades() {
        return ResponseEntity.status(HttpStatus.OK).body(servicio.getCiudades());
    }
}