package com.bosonit.backend.ejercicio3.REST;

import com.bosonit.backend.ejercicio3.entidades.Ciudad;
import com.bosonit.backend.ejercicio3.servicios.ServicioBosonit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("controlador2")
public class Controlador2 {
    private final Logger log = Logger.getLogger(Controlador2.class.getName());

    @Autowired
    private ServicioBosonit servicio;

    @GetMapping("getPersona")
    public void verPersona(){
       // controlador1.crearPersona()
    }

    @GetMapping("getCiudades")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Ciudad>> verCiudades(){
     return ResponseEntity.status(HttpStatus.OK).body(servicio.getCiudades());
    }
}