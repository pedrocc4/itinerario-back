package com.bosonit.backend.app.infrastructure.controller;

import com.bosonit.backend.app.domain.Fichero;
import com.bosonit.backend.app.domain.Multip;
import com.bosonit.backend.app.service.IService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@Slf4j
public class FicheroController {

    @Autowired
    private IService service;

    @ResponseStatus(HttpStatus.CREATED)
    //@RequestMapping(path = "/fichero", method = POST, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @PostMapping("/fichero")
    public String addFichero(@ModelAttribute Fichero fichero, Model model) {
        model.addAttribute("fichero", fichero);
        log.info("Datos recibidos: " + fichero.getFile().getOriginalFilename());
        service.addFichero(fichero);
        return "fichero";
    }

    @GetMapping("/ficheros")
    public String getFicheros(Model model) {
        log.info("Intentando obtener todos los ficheros...");
        List<Fichero> ficheros = service.getFicheros();
        log.info(String.valueOf(ficheros));
        model.addAttribute("ficheros", ficheros);
        return "ficheros";
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("fichero/{id}")
    public ResponseEntity<Fichero> getFichero(@PathVariable String id) {
        log.info("Intentando obtener fichero con id: " + id);
        return ResponseEntity.status(HttpStatus.OK).body(service.getFicheroById(id));
    }

    @GetMapping("/fichero")
    public String greetingForm(Model model) {

        model.addAttribute("fichero", new Fichero());
        return "fichero";
    }

    @GetMapping("/fichero/ficheros")
    public String ten(Model model) {
        List<Fichero> ficheros = service.getFicheros();
        log.info(String.valueOf(ficheros));
        model.addAttribute("ficheros", ficheros);
        return "fichero/ficheros";
    }
}
