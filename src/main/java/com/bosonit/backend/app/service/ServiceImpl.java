package com.bosonit.backend.app.service;

import com.bosonit.backend.app.domain.Fichero;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ServiceImpl implements IService {
    private HashMap<String, Fichero> ficheros;
    private String id;

    @PostConstruct
    private void init() {
        id = "FICH";
        ficheros = new HashMap<>();
    }

    @Override
    public void addFichero(Fichero fichero) {
        fichero.setFecha_subida(LocalDate.now());
        fichero.setId(id + ficheros.size());
     //   fichero.setFile(document);
        ficheros.put(fichero.getId(), fichero);
        log.info(fichero + " agregado");
    }

    @Override
    public Fichero getFicheroById(String id) {
        log.info(String.valueOf(ficheros.get(id)));
        return ficheros.get(id);
    }

    @Override
    public List<Fichero> getFicheroByName(String name) {
        return ficheros.entrySet()
                .stream()
                .filter(fichero -> fichero.getValue().getNombre().equals(name))
                .map(ficheros -> ficheros.getValue())
                .collect(Collectors.toList());
    }

    @Override
    public List<Fichero> getFicheros() {
        return ficheros.values().stream().toList();
    }
}
