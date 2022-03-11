package com.bosonit.backend.ejercicio3.servicios;

import com.bosonit.backend.ejercicio3.entidades.Ciudad;
import com.bosonit.backend.ejercicio3.entidades.Persona;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Service
@Validated
public class ServicioBosonit {

    List<Ciudad> ciudades = new ArrayList<>();

    public ServicioBosonit() {
    }

    public Persona crearPersona(
            String nombre, String poblacion, Integer edad) {
        return new Persona(nombre, poblacion, edad);
    }

    public void addCiudad(Ciudad ciudad) {
        ciudades.add(ciudad);
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }
}
