package com.bosonit.backend.ejercicio4.perfiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("perfil2")
public class perfil2 implements Perfiles {
    private final String perfil;

    public perfil2() {
        perfil = "perfil2";
    }

    @Override
    public void miFuncion() {
        System.out.println(perfil);
    }
}
