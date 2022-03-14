package com.bosonit.backend.ejercicio4.perfiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("perfil1")
public class perfil1 implements Perfiles {
    private final String perfil;

    public perfil1() {
        perfil = "perfil1";
    }

    @Override
    public void miFuncion() {
        System.out.println(perfil);
    }
}
