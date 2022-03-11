package com.bosonit.backend.ejercicio3.entidades;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Ciudad {
    private String nombre;
    private long numHabitantes;

    public Ciudad(String nombre, long numHabitantes) {
        this.nombre = nombre;
        this.numHabitantes = numHabitantes;
    }
}
