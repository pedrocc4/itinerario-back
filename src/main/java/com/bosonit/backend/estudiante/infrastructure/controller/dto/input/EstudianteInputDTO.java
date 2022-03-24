package com.bosonit.backend.estudiante.infrastructure.controller.dto.input;

import com.bosonit.backend.asignatura.domain.Asignatura;
import com.bosonit.backend.persona.domain.Persona;

import java.util.List;

public record EstudianteInputDTO(
        int num_hours_week,
        String comments,
        String branch,
        Persona id_persona,
        List<Asignatura> asignaturas) {
}
