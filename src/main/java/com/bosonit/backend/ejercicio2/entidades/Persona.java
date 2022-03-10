package com.bosonit.backend.ejercicio2.entidades;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Persona {
    String nombre;
    String poblacion;
    Integer edad;

    public Persona() {
    }

    public Persona(String nombre, String poblacion, Integer edad) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.edad = edad;
    }
}
