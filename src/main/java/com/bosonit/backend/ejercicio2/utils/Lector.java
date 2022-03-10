package com.bosonit.backend.ejercicio2.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lector {
    private final String ruta;

    public Lector(String ruta) {
        this.ruta = ruta;
    }

    public List<String[]> lectura() {
        String[] lectura;
        List<String[]> lect = new ArrayList<>();
        String linea;
        FileReader f;
        try {
            f = new FileReader(ruta);
            BufferedReader b = new BufferedReader(f);

            while ((linea = b.readLine()) != null) {

                // para errores cuando no se introduce edad
                if (linea.endsWith(":")) {
                    linea += "-1";
                }

                lectura = linea.split(":");
                lect.add(lectura);
            }

            b.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lect;
    }

}
