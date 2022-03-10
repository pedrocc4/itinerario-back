package com.bosonit.backend.ejercicio1.app;

import com.bosonit.backend.ejercicio1.entidades.Persona;
import com.bosonit.backend.ejercicio1.utils.Lector;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class main {
    public static void main(String[] args) {
        Lector lector = new Lector("datos.txt");

        List<String[]> lectura = lector.lectura();
        List<Persona> personas = new ArrayList<>();

        IntStream.range(0, lectura.size()).forEach(i -> {
            Persona p = new Persona(lectura.get(i)[0], lectura.get(i)[1], Integer.parseInt(lectura.get(i)[2]));
            personas.add(p);
        });

        List<String> menores25 =
                personas.stream()
                        .filter(persona -> persona.getEdad() < 25 && persona.getEdad() != -1)
                        .map(Persona::toString)
                        .collect(Collectors.toList());

        System.out.println(menores25);

    }
}
