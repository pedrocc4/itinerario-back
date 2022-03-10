package com.bosonit.backend.app;

import com.bosonit.backend.entidades.Persona;
import com.bosonit.backend.utils.Lector;

import java.util.ArrayList;
import java.util.List;
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

        System.out.println(personas);


    }
}
