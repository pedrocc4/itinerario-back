package com.bosonit.backend.app.service;

import com.bosonit.backend.app.domain.Fichero;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IService {
    void addFichero(Fichero fichero);

    Fichero getFicheroById(String id);

    List<Fichero> getFicheroByName(String name);

    List<Fichero> getFicheros();
}
