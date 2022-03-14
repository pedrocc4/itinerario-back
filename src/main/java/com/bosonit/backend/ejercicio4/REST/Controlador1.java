package com.bosonit.backend.ejercicio4.REST;

import com.bosonit.backend.ejercicio4.configuration.Configuracion;
import com.bosonit.backend.ejercicio4.perfiles.Perfiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador1 {
    @Autowired
    private Configuracion confi;

    @Autowired
    private Perfiles perfil;

    @GetMapping("parametros")
    public String parametros(
            @Value("${url}") String url,
            @Value("${password}") String pass) {
        return url + " " + pass;
    }

    @GetMapping("miconfiguracion")
    public String variables() {
        return confi.getValor1() + " " + confi.getValor2();
    }

    @GetMapping("perfil")
    public void perfil() {
        perfil.miFuncion();
    }
}