package com.bosonit.backend.estudiante_asignatura.infrastructure.controller.dto;

import com.bosonit.backend.asignatura.domain.Asignatura;
import com.bosonit.backend.estudiante.domain.Estudiante;

import java.util.Date;

public record Estudiante_AsignaturaInputDTO(
        String comments,
        Date initial_date,
        Date finish_date,
        Estudiante id_estudiante,
        Asignatura id_asignatura) {
}
