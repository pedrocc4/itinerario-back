package com.bosonit.backend.ejercicio3.servicios;

import com.bosonit.backend.ejercicio3.entidades.Ciudad;
import com.bosonit.backend.ejercicio3.entidades.Persona;

import java.util.List;

public interface ServicioBosonit {
    Persona crearPersona(String nombre, String poblacion, Integer edad);

    void addCiudad(Ciudad ciudad);

    List<Persona> getPersonas();

    List<Ciudad> getCiudades();
}
