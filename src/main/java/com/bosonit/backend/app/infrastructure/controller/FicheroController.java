package com.bosonit.backend.app.infrastructure.controller;

import com.bosonit.backend.app.domain.Fichero;
import com.bosonit.backend.app.service.IService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@Slf4j
public class FicheroController {

    @Autowired
    private IService service;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public void addFichero(Fichero fichero) {
        log.info("Datos recibidos: " + fichero);
        service.addFichero(fichero);
    }

    @GetMapping("/ficheros")
    public List<Fichero> getFicheros() {
        log.info("Intentando obtener todos los ficheros...");
        return service.getFicheros();
    }

    @GetMapping("fichero/{id}")
    public Fichero getFichero(@PathVariable String id) {
        log.info("Intentando obtener fichero con id: " + id);
        return service.getFicheroById(id);
    }
}
