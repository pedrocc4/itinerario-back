package com.bosonit.backend.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorage {

    private Path root = Paths.get("uploads");

    private String directorio;

    public void init() throws IOException {
        this.root = Paths.get(this.directorio);
        Files.createDirectory(root);
    }

    public void save(MultipartFile file) throws IOException {
        Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
    }

    public Resource load(String filename) throws MalformedURLException {
        Path file = root.resolve(filename);
        Resource resource = new UrlResource((file.toUri()));
        return resource;
    }
}
