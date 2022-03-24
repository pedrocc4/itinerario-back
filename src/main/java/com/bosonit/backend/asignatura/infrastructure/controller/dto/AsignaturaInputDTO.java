package com.bosonit.backend.asignatura.infrastructure.controller.dto;

import com.bosonit.backend.estudiante.domain.Estudiante;

import java.util.List;

public record AsignaturaInputDTO(
        String nombre,
        String descripcion,
        List<Estudiante> estudiantes) {
}
