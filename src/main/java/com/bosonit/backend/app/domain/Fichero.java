package com.bosonit.backend.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fichero implements Serializable {
    private String id;
    private String nombre;
    private String content;
    private LocalDate fecha_subida;
    private MultipartFile file;
}
